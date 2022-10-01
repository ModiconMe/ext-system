package edu.javacourse.register.dao;

import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.view.MarriageRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Component
public class MarriageDAO {
    private final static Logger LOGGER = Logger.getLogger(MarriageDAO.class);
    private EntityManager entityManager;

    public void setTest(String test) {
        this.test = test;
    }

    @Value("${test.value}")
    private String test;

    public MarriageDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    public MarriageCertificate findMarriageCertificate(MarriageRequest request) throws Exception {
        LOGGER.info("findMarriageCertificate called " + test);
        Query namedQuery = entityManager.createNamedQuery("MarriageCertificate.findCertificate");
        namedQuery.setParameter("number", request.getMarriageCertificateNumber());
        MarriageCertificate certificate = (MarriageCertificate) namedQuery.getSingleResult();
        if (certificate != null) {
            return certificate;
        }
        throw new Exception();
    }
}
