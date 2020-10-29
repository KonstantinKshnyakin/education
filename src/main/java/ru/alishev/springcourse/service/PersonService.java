package ru.alishev.springcourse.service;

import ru.alishev.springcourse.models.Person;

import java.util.List;

public interface PersonService {

    void save(Person person);

    List<Person> findAll();

    Person findById(int id);

    void update(Person person);

    void delete(int id);
}
