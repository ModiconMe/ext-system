package edu.javacourse.register.business;

import edu.javacourse.register.dao.MarriageDAO;
import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.rest.MarriageController;
import edu.javacourse.register.view.MarriageRequest;
import edu.javacourse.register.view.MarriageResponse;
import org.apache.log4j.Logger;

import java.util.List;

public class MarriageManager {
    private final static Logger LOGGER = Logger.getLogger(MarriageController.class);
    private MarriageDAO marriageDAO = new MarriageDAO();

    public MarriageResponse findMarriageCertificate(MarriageRequest request) throws Exception {
        LOGGER.info("MarriageManager.findMarriageCertificate called");
        MarriageCertificate marriageCertificate = marriageDAO.findMarriageCertificate(request);
        MarriageResponse response = new MarriageResponse();
        if (marriageCertificate.isActive()) {
            response.setExist(true);
            System.out.println(marriageCertificate.getNumber());
        }
        return response;
    }
}
