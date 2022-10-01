package edu.javacourse.register;

import edu.javacourse.register.rest.MarriageController;
import edu.javacourse.register.view.MarriageRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");

        MarriageController controller = context.getBean("controller", MarriageController.class);
        System.out.println(controller.findMarriageCertificate(new MarriageRequest()).isExist());
    }
}
