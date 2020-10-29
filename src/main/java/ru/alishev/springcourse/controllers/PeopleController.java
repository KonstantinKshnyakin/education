package ru.alishev.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import ru.alishev.springcourse.dao.PersonDAO1;
import ru.alishev.springcourse.dao.PersonDao;
import ru.alishev.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Alishev
 */
@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDao personDao;

    @Autowired
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Person> people = personDao.findAll();
        model.addAttribute("people", people);
        return "people/index";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        Person person = personDao.findById(id);
        model.addAttribute("person", person);
        return "people/show";
    }
}
