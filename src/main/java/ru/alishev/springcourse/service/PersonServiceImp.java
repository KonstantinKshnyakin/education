package ru.alishev.springcourse.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.dao.PersonDao;
import ru.alishev.springcourse.models.Person;

import java.util.List;

@Service
public class PersonServiceImp implements PersonService {

    private final PersonDao personDao;

    public PersonServiceImp(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Person person) {
        personDao.save(person);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Person findById(int id) {
        return personDao.findById(id);
    }
}
