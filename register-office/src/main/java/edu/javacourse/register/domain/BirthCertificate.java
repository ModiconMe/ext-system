package edu.javacourse.register.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "ro_birth_certificate")
@Entity
public class BirthCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificate_id")
    private Long certificateId;
    @Column(name = "number")
    private String number;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "father_id")
    private PersonMale father;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "mother_id")
    private PersonFemale mother;

    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonMale getFather() {
        return father;
    }

    public void setFather(PersonMale father) {
        this.father = father;
    }

    public PersonFemale getMother() {
        return mother;
    }

    public void setMother(PersonFemale mother) {
        this.mother = mother;
    }
}
