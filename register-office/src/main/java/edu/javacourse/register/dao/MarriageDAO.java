package edu.javacourse.register.dao;

import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.view.MarriageRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.apache.log4j.Logger;

import java.util.List;

public class MarriageDAO {
    private final static Logger LOGGER = Logger.getLogger(MarriageDAO.class);
    private EntityManager entityManager;

    public void setTest(String test) {
        this.test = test;
    }

    private String test;

    public MarriageDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
        entityManager = factory.createEntityManager();
    }

    public MarriageCertificate findMarriageCertificate(MarriageRequest request) throws Exception {
        Query namedQuery = entityManager.createNamedQuery("MarriageCertificate.findCertificate");
        namedQuery.setParameter("number", request.getMarriageCertificateNumber());
        MarriageCertificate certificate = (MarriageCertificate) namedQuery.getSingleResult();
        if (certificate != null) {
            return certificate;
        }
        throw new Exception();
    }
}
