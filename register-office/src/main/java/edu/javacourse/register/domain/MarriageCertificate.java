package edu.javacourse.register.domain;

import java.time.LocalDate;

public class MarriageCertificate {
    private Long marriageCertificateId;
    private String number;
    private LocalDate issueDate;
    private PersonMale husband;
    private PersonFemale wife;
    private boolean active;
    private LocalDate endDate;
}
