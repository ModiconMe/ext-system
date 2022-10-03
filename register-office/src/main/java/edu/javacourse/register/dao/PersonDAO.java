package edu.javacourse.register.dao;

import edu.javacourse.register.domain.Person;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Service
public class PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

//    public PersonDAO() {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
//        entityManager = factory.createEntityManager();
//    }

    public List<Person> findPerson() {
        Query namedQuery = entityManager.createNamedQuery("Person.findPersons");
        return namedQuery.getResultList();
    }

    public Long addPerson(Person person) {
        entityManager.persist(person);
        entityManager.flush();
        return person.getPersonId();
    }
}
