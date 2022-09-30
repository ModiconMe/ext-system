package edu.javacourse.register.rest;

import edu.javacourse.register.business.MarriageManager;
import edu.javacourse.register.view.MarriageRequest;
import edu.javacourse.register.view.MarriageResponse;
import org.apache.log4j.Logger;

public class MarriageController {
    private final static Logger LOGGER = Logger.getLogger(MarriageController.class);
    private MarriageManager marriageManager = new MarriageManager();

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called");
        MarriageResponse response = null;
        try {
            response = marriageManager.findMarriageCertificate((request));
        } catch (Exception e) {
            MarriageResponse response1 = new MarriageResponse();
            response1.setExist(false);
            return response1;
        }
        return response;
    }
}
