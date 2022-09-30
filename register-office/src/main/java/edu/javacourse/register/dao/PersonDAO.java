package edu.javacourse.register.dao;

import edu.javacourse.register.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class PersonDAO {
    private EntityManager entityManager;

    public PersonDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    public List<Person> findPerson() {
        Query namedQuery = entityManager.createNamedQuery("Person.findPersons");
        namedQuery.setParameter("personId", 1);
        return namedQuery.getResultList();
    }
}
