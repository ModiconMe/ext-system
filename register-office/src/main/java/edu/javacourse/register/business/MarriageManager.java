package edu.javacourse.register.business;

import edu.javacourse.register.dao.MarriageDAO;
import edu.javacourse.register.dao.PersonDAO;
import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.domain.Person;
import edu.javacourse.register.domain.PersonFemale;
import edu.javacourse.register.domain.PersonMale;
import edu.javacourse.register.rest.MarriageController;
import edu.javacourse.register.view.MarriageRequest;
import edu.javacourse.register.view.MarriageResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service("marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarriageManager {
    private final static Logger LOGGER = Logger.getLogger(MarriageController.class);
    @Autowired
    private MarriageDAO marriageDAO;
    @Autowired
    private PersonDAO personDAO;

    @Transactional
    public MarriageResponse findMarriageCertificate(MarriageRequest request) throws Exception {
        LOGGER.info("MarriageManager.findMarriageCertificate called");
//        MarriageCertificate marriageCertificate = marriageDAO.findMarriageCertificate(request);

        personDAO.addPerson(getPerson(1));
        personDAO.addPerson(getPerson(2));
        MarriageCertificate mc = getMarriageCertificate();
        marriageDAO.saveAndFlush(mc);
        marriageDAO.findAll();
        MarriageResponse response = new MarriageResponse();

        if (mc.isActive()) {
            response.setExist(true);
            System.out.println(mc.getNumber());
        }
        return response;
    }

    private MarriageCertificate getMarriageCertificate() {
        MarriageCertificate mc = new MarriageCertificate();
        mc.setIssueDate(LocalDate.now());
        mc.setNumber("12345");
        mc.setActive(true);

        List<Person> persons = personDAO.findPerson();
        for (Person person : persons) {
            if (person instanceof PersonMale) {
                mc.setHusband((PersonMale) person);
            } else {
                mc.setWife((PersonFemale) person);
            }
        }
        return mc;
    }

    private Person getPerson(int sex) {
        Person person = sex == 1 ? new PersonMale() : new PersonFemale();
        person.setFirstName("1_" + sex);
        person.setLastName("2_" + sex);
        person.setPatronymic("3_" + sex);
        person.setDateOfBirth(LocalDate.of(1991, 3, 12));
        return person;
    }
}
