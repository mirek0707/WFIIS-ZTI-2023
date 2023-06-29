package zti.lab05c2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zti.lab05c2.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}