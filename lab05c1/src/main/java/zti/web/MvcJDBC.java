package zti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import zti.model.Person;
import zti.model.PersonDaoImpl;

@Controller(value = "MvcController")
@RequestMapping("/mvc")
public class MvcJDBC {

    @Autowired
    PersonDaoImpl personDao;

    @RequestMapping(value = "/list")
    public String getTable(Model model) {
        // logger.info("Start getAllEmployees.");
        List<Person> people = personDao.getPeople() ;
        model.addAttribute("table",people);
        return "list.jsp";
    }
    @RequestMapping(value = "/list2")
    public String getTable2(Model model) {
        // logger.info("Start getAllEmployees.");
        List<Person> people = personDao.getPeople() ;
        model.addAttribute("table",people);
        return "list.html";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam("id") int id, Model model) {
        System.out.println(personDao.getPersonByID(id));
        Person person = personDao.getPersonByID(id);
        System.out.println("///////////////////////////////////////");
        System.out.println(person);
        System.out.println("////////////////////////////////////////");
        model.addAttribute("person", person);
        return "edit.jsp";
    }

    @RequestMapping(value = "/save{id}", method = RequestMethod.POST)
    public String save(@PathVariable("id") int id, @ModelAttribute("person") Person person) {

        //Person person = new Person(lname, fname, city, email, tel, id);
        personDao.update(person);
        return "redirect:/mvc/list";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@ModelAttribute("person") Person person) {
        personDao.save(person);
        return "redirect:/mvc/list";
    }
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(Model model) {
        model.addAttribute("person", new Person());
        return "insert.jsp";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model) {
        personDao.delete(id);
        return "redirect:/mvc/list";
    }

}