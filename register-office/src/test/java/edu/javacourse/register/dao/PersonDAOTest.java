package edu.javacourse.register.dao;

import edu.javacourse.register.domain.Person;
import edu.javacourse.register.domain.PersonFemale;
import edu.javacourse.register.domain.PersonMale;
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
            System.out.println(p.getBirthCertificate());
            if (p instanceof PersonMale) {
                System.out.println(((PersonMale)p).getMarriageCertificates().size());
                System.out.println(((PersonMale)p).getBirthCertificates().size());
            } else {
                System.out.println(((PersonFemale)p).getMarriageCertificates().size());
                System.out.println(((PersonFemale)p).getBirthCertificates().size());
            }
        }
    }
}