package edu.javacourse.register.dao;

import edu.javacourse.register.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

//    public PersonDAO() {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
//        entityManager = factory.createEntityManager();
//    }

    public List<Person> findPerson() {
        Query namedQuery = entityManager.createNamedQuery("Person.findPersons");
        namedQuery.setParameter("personId", 1);
        return namedQuery.getResultList();
    }

    public Long addPerson(Person person) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(person);
        entityManager.flush();
        return person.getPersonId();
    }
}
