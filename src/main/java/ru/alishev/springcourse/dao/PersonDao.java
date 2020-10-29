package ru.alishev.springcourse.dao;

import ru.alishev.springcourse.models.Person;

import java.util.List;

public interface PersonDao {

    void save(Person person);

    List<Person> findAll();

    Person findById(int id);
}
