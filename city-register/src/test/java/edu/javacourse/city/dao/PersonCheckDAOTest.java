package edu.javacourse.city.dao;

import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class PersonCheckDAOTest {
    private static final Logger logger = Logger.getLogger(PersonCheckDAOTest.class);

    @Test
    public void checkPerson1() {
        PersonCheckDAO personCheckDAO = new PersonCheckDAO();
//        personCheckDAO.setConnectionBuilder(new DirectConnectionBuilder());
        personCheckDAO.setConnectionBuilder(new PoolConnectionBuilder());
        PersonRequest personRequest = new PersonRequest();
        personRequest.setSurName("Popov");
        personRequest.setGivenName("Dmitry");
        personRequest.setPatronymic("Olegovich");
        personRequest.setDateOfBirth(LocalDate.of(1995, 3, 18));
        personRequest.setStreetCode(1);
        personRequest.setBuilding("10");
        personRequest.setExtension("2");
        personRequest.setApartment("121");
        try {
            PersonResponse response = personCheckDAO.checkPerson(personRequest);
            Assert.assertTrue(response.isRegistered());
            Assert.assertFalse(response.isTemporal());
        } catch (Exception e) {
            logger.error(e);
        }
    }

    @Test
    public void checkPerson2() {
        PersonCheckDAO personCheckDAO = new PersonCheckDAO();
        personCheckDAO.setConnectionBuilder(new DirectConnectionBuilder());
        PersonRequest personRequest = new PersonRequest();
        personRequest.setSurName("Popova");
        personRequest.setGivenName("Polina");
        personRequest.setPatronymic("Igorevna");
        personRequest.setDateOfBirth(LocalDate.of(1997, 8, 21));
        personRequest.setStreetCode(2);
        personRequest.setBuilding("12");
        personRequest.setExtension(null);
        personRequest.setApartment(null);
        try {
            PersonResponse response = personCheckDAO.checkPerson(personRequest);
            Assert.assertTrue(response.isRegistered());
            Assert.assertFalse(response.isTemporal());
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
