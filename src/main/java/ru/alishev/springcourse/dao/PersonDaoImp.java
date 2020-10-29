package ru.alishev.springcourse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.models.Person;

import java.util.List;

@Repository
public class PersonDaoImp implements PersonDao {

    private final SessionFactory sessionFactory;

    public PersonDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void save(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Override
    @Transactional
    public List<Person> findAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select p from Person p", Person.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Person findById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Person> query = currentSession.createQuery(
                "select p from Person p where p.id = :id", Person.class
        );
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
