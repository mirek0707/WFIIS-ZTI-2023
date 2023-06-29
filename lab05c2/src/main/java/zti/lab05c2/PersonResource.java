package zti.lab05c2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zti.lab05c2.exception.PersonNotFoundException;
import zti.lab05c2.model.Person;

@RestController
class PersonResource {

    @Autowired
    private  PersonRepository personRepository;


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/person")
    List<Person> all() {
        return personRepository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/person")
    Person newPerson(@RequestBody Person newPerson) {
        return personRepository.save(newPerson);
    }

    // Single item

    @GetMapping("/person/{id}")
    Person one(@PathVariable Integer id) {

        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @PutMapping("/person/{id}")
    Person replacePerson(@RequestBody Person newPerson, @PathVariable Integer id) {

        return personRepository.findById(id)
                .map(person -> {
                    person.setFname(newPerson.getFname());
                    person.setLname(newPerson.getLname());
                    return personRepository.save(person);
                })
                .orElseGet(() -> {
                    newPerson.setId(id);
                    return personRepository.save(newPerson);
                });
    }

    @DeleteMapping("/person/{id}")
    void deletePerson(@PathVariable Integer id) {
        personRepository.deleteById(id);
    }
}