package edu.javacourse.register.view;

import java.io.Serializable;
import java.time.LocalDate;

public class MarriageRequest implements Serializable {
    private String husbandSurname;
    private String husbandGivenName;
    private String husbandPatronymic;
    private LocalDate husbandDateOfBirth;
    private String husbandPassportSeries;
    private String husbandPassportNumber;
    private String husbandPassportIssueDate;
    private String wifeSurname;
    private String wifeGivenName;
    private String wifePatronymic;
    private LocalDate wifeDateOfBirth;
    private String wifePassportSeries;
    private String wifePassportNumber;
    private String wifePassportIssueDate;

    private String marriageCertificateNumber;
    private LocalDate marriageCertificateDate;

    public String getHusbandSurname() {
        return husbandSurname;
    }

    public void setHusbandSurname(String husbandSurname) {
        this.husbandSurname = husbandSurname;
    }

    public String getHusbandGivenName() {
        return husbandGivenName;
    }

    public void setHusbandGivenName(String husbandGivenName) {
        this.husbandGivenName = husbandGivenName;
    }

    public String getHusbandPatronymic() {
        return husbandPatronymic;
    }

    public void setHusbandPatronymic(String husbandPatronymic) {
        this.husbandPatronymic = husbandPatronymic;
    }

    public LocalDate getHusbandDateOfBirth() {
        return husbandDateOfBirth;
    }

    public void setHusbandDateOfBirth(LocalDate husbandDateOfBirth) {
        this.husbandDateOfBirth = husbandDateOfBirth;
    }

    public String getHusbandPassportSeries() {
        return husbandPassportSeries;
    }

    public void setHusbandPassportSeries(String husbandPassportSeries) {
        this.husbandPassportSeries = husbandPassportSeries;
    }

    public String getHusbandPassportNumber() {
        return husbandPassportNumber;
    }

    public void setHusbandPassportNumber(String husbandPassportNumber) {
        this.husbandPassportNumber = husbandPassportNumber;
    }

    public String getHusbandPassportIssueDate() {
        return husbandPassportIssueDate;
    }

    public void setHusbandPassportIssueDate(String husbandPassportIssueDate) {
        this.husbandPassportIssueDate = husbandPassportIssueDate;
    }

    public String getWifeSurname() {
        return wifeSurname;
    }

    public void setWifeSurname(String wifeSurname) {
        this.wifeSurname = wifeSurname;
    }

    public String getWifeGivenName() {
        return wifeGivenName;
    }

    public void setWifeGivenName(String wifeGivenName) {
        this.wifeGivenName = wifeGivenName;
    }

    public String getWifePatronymic() {
        return wifePatronymic;
    }

    public void setWifePatronymic(String wifePatronymic) {
        this.wifePatronymic = wifePatronymic;
    }

    public LocalDate getWifeDateOfBirth() {
        return wifeDateOfBirth;
    }

    public void setWifeDateOfBirth(LocalDate wifeDateOfBirth) {
        this.wifeDateOfBirth = wifeDateOfBirth;
    }

    public String getWifePassportSeries() {
        return wifePassportSeries;
    }

    public void setWifePassportSeries(String wifePassportSeries) {
        this.wifePassportSeries = wifePassportSeries;
    }

    public String getWifePassportNumber() {
        return wifePassportNumber;
    }

    public void setWifePassportNumber(String wifePassportNumber) {
        this.wifePassportNumber = wifePassportNumber;
    }

    public String getWifePassportIssueDate() {
        return wifePassportIssueDate;
    }

    public void setWifePassportIssueDate(String wifePassportIssueDate) {
        this.wifePassportIssueDate = wifePassportIssueDate;
    }

    public String getMarriageCertificateNumber() {
        return marriageCertificateNumber;
    }

    public void setMarriageCertificateNumber(String marriageCertificateNumber) {
        this.marriageCertificateNumber = marriageCertificateNumber;
    }

    public LocalDate getMarriageCertificateDate() {
        return marriageCertificateDate;
    }

    public void setMarriageCertificateDate(LocalDate marriageCertificateDate) {
        this.marriageCertificateDate = marriageCertificateDate;
    }

    @Override
    public String toString() {
        return "MarriageRequest{" +
                "husbandSurname='" + husbandSurname + '\'' +
                ", husbandGivenName='" + husbandGivenName + '\'' +
                ", husbandPatronymic='" + husbandPatronymic + '\'' +
                ", husbandDateOfBirth=" + husbandDateOfBirth +
                ", husbandPassportSeries='" + husbandPassportSeries + '\'' +
                ", husbandPassportNumber='" + husbandPassportNumber + '\'' +
                ", husbandPassportIssueDate='" + husbandPassportIssueDate + '\'' +
                ", wifeSurname='" + wifeSurname + '\'' +
                ", wifeGivenName='" + wifeGivenName + '\'' +
                ", wifePatronymic='" + wifePatronymic + '\'' +
                ", wifeDateOfBirth=" + wifeDateOfBirth +
                ", wifePassportSeries='" + wifePassportSeries + '\'' +
                ", wifePassportNumber='" + wifePassportNumber + '\'' +
                ", wifePassportIssueDate='" + wifePassportIssueDate + '\'' +
                ", marriageCertificateNumber='" + marriageCertificateNumber + '\'' +
                ", marriageCertificateDate=" + marriageCertificateDate +
                '}';
    }
}
