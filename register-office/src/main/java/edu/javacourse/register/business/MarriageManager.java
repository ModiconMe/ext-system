package edu.javacourse.register.business;

import edu.javacourse.register.dao.MarriageDAO;
import edu.javacourse.register.dao.PersonDAO;
import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.rest.MarriageController;
import edu.javacourse.register.view.MarriageRequest;
import edu.javacourse.register.view.MarriageResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarriageManager {
    private final static Logger LOGGER = Logger.getLogger(MarriageController.class);
    @Autowired
    private MarriageDAO marriageDAO;
    @Autowired
    private PersonDAO personDAO;

    @Autowired
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public MarriageResponse findMarriageCertificate(MarriageRequest request) throws Exception {
        LOGGER.info("MarriageManager.findMarriageCertificate called");
        MarriageCertificate marriageCertificate = marriageDAO.findMarriageCertificate(request);
        MarriageResponse response = new MarriageResponse();
        personDAO.findPerson();
        if (marriageCertificate.isActive()) {
            response.setExist(true);
            System.out.println(marriageCertificate.getNumber());
        }
        return response;
    }
}
