package ru.alishev.springcourse.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.alishev.springcourse.models.Person;

import java.util.List;

@Repository
public class PersonDaoImp implements PersonDao {

    private final SessionFactory sessionFactory;

    public PersonDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Override
    public List<Person> findAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select p from Person p", Person.class)
                .getResultList();
    }

    @Override
    public Person findById(int id) {
        return sessionFactory.getCurrentSession()
                .createQuery("select p from Person p where p.id = :id", Person.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void update(Person person) {
        sessionFactory
                .getCurrentSession()
                .createQuery("update Person p set p.name = :name where p.id = :id")
                .setParameter("id", person.getId())
                .setParameter("name", person.getName())
                .executeUpdate();
    }

    @Override
    public void delete(int id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete from Person p where p.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
