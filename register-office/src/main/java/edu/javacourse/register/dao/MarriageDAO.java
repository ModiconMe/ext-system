package edu.javacourse.register.dao;

import edu.javacourse.register.domain.MarriageCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarriageDAO extends JpaRepository<MarriageCertificate, Long> {
//    private final static Logger LOGGER = Logger.getLogger(MarriageDAO.class);
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public void setTest(String test) {
//        this.test = test;
//    }
//
//    @Value("${test.value}")
//    private String test;
//
//    public MarriageDAO() {
////        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
////        entityManager = factory.createEntityManager();
//    }
//    public MarriageCertificate findMarriageCertificate(MarriageRequest request) throws Exception {
//        LOGGER.info("findMarriageCertificate called " + test);
//        Query namedQuery = entityManager.createNamedQuery("MarriageCertificate.findCertificate");
//        namedQuery.setParameter("number", request.getMarriageCertificateNumber());
//        MarriageCertificate certificate = (MarriageCertificate) namedQuery.getSingleResult();
//
//        Person person = new PersonMale();
//        person.setFirstName("1");
//        person.setLastName("2");
//        person.setPatronymic("3");
//        person.setDateOfBirth(LocalDate.of(1991, 3, 12));
//        entityManager.persist(person);
//
//        if (certificate != null) {
//            return certificate;
//        }
//        throw new Exception();
//    }
}
