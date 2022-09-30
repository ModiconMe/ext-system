package edu.javacourse.register.rest;

import edu.javacourse.register.view.MarriageRequest;
import edu.javacourse.register.view.MarriageResponse;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MarriageControllerTest {

    @Test
    public void findMarriageCertificate() {
        MarriageController controller = new MarriageController();
        MarriageRequest request = new MarriageRequest();
        request.setHusbandSurname("Васильев");
        request.setHusbandGivenName("Олег");
        request.setHusbandPatronymic("Петрович");
        request.setHusbandDateOfBirth(LocalDate.of(1997,10,16));
        request.setHusbandPassportSeries("50000");
        request.setHusbandPassportNumber("654321");
        request.setHusbandPassportIssueDate("2018-05-10");

        request.setHusbandSurname("Васильева");
        request.setHusbandGivenName("Елена");
        request.setHusbandPatronymic("Сергеевна");
        request.setHusbandDateOfBirth(LocalDate.of(1998,03,24));
        request.setHusbandPassportSeries("40000");
        request.setHusbandPassportNumber("123456");
        request.setHusbandPassportIssueDate("2018-04-10");

        request.setMarriageCertificateNumber("123 Marriag");
        request.setMarriageCertificateDate(LocalDate.of(2018,1,01));

        MarriageResponse response = controller.findMarriageCertificate(request);

        System.out.println(response.isExist());
    }
}