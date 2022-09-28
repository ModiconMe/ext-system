package edu.javacourse.register.dao;

import edu.javacourse.register.domain.Person;
import org.junit.Test;

import java.util.List;

public class PersonDAOTest {

    @Test
    public void findPerson() {
        PersonDAO dao = new PersonDAO();
        List<Person> person = dao.findPerson();
        for (Person p : person) {
            System.out.println(p.getFirstName());
            System.out.println(p.getClass().getSimpleName());
            System.out.println(p.getPassports().size());
        }
    }
}