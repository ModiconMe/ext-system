package edu.javacourse.register.domain;

import jakarta.persistence.*;

import java.util.List;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class PersonFemale extends Person {
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY,
            mappedBy = "person")
    private List<MarriageCertificate> marriageCertificates;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY,
            mappedBy = "person")
    private List<BirthCertificate> birthCertificates;

    public void setMarriageCertificates(List<MarriageCertificate> marriageCertificates) {
        this.marriageCertificates = marriageCertificates;
    }

    public List<BirthCertificate> getBirthCertificates() {
        return birthCertificates;
    }

    public void setBirthCertificates(List<BirthCertificate> birthCertificates) {
        this.birthCertificates = birthCertificates;
    }
}
