package edu.javacourse.register;

import edu.javacourse.register.rest.MarriageController;
import edu.javacourse.register.view.MarriageRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

@ImportResource({ "classpath:springContext.xml" })
public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");

        MarriageController controller = context.getBean("controller", MarriageController.class);
        MarriageRequest request = new MarriageRequest();
        request.setHusbandSurname("Васильев");
        request.setHusbandGivenName("Олег");
        request.setHusbandPatronymic("Петрович");
        request.setHusbandDateOfBirth(LocalDate.of(1997,10,16));
        request.setHusbandPassportSeries("50000");
        request.setHusbandPassportNumber("654321");
        request.setHusbandPassportIssueDate("2018-05-10");

        request.setWifeSurname("Васильева");
        request.setWifeGivenName("Елена");
        request.setWifePatronymic("Сергеевна");
        request.setWifeDateOfBirth(LocalDate.of(1998,3,24));
        request.setWifePassportSeries("40000");
        request.setWifePassportNumber("123456");
        request.setWifePassportIssueDate("2018-04-10");

        request.setMarriageCertificateNumber("123 Marriage");
        request.setMarriageCertificateDate(LocalDate.of(2018,1,1));

//        System.out.println(controller.findMarriageCertificate(new MarriageRequest()).isExist());
        System.out.println(controller.findMarriageCertificate(request).isExist());
    }
}
