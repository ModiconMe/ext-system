package edu.javacourse.register.rest;

import edu.javacourse.register.business.MarriageManager;
import edu.javacourse.register.view.MarriageRequest;
import edu.javacourse.register.view.MarriageResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("controller")
public class MarriageController {
    private final static Logger LOGGER = Logger.getLogger(MarriageController.class);
    @Autowired
    @Qualifier("marriageService")
    private MarriageManager marriageManager;

    public MarriageResponse findMarriageCertificate(MarriageRequest request) {
        LOGGER.info("findMarriageCertificate called");
        MarriageResponse response = null;
        System.out.println(request);
        try {
            response = marriageManager.findMarriageCertificate((request));
        } catch (Exception e) {
            LOGGER.error(e);
            MarriageResponse response1 = new MarriageResponse();
            response1.setExist(false);
            return response1;
        }
        return response;
    }
}
