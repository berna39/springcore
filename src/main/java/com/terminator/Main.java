package com.terminator;

import com.terminator.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // --------- Loading XML configuration ----------- //
        // BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml")); // depreciated
        // BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml"); // okay but
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml"); // Recommended
        EmailService emailService = context.getBean("emailService", EmailService.class);
        emailService.sendEmail("kalema@gmail.com", "Hello from London");

        // --------- Loading Configuration class ----------- //
        ApplicationContext context1 = new AnnotationConfigApplicationContext(AppConfig.class);
        EmailService emailService1 = context1.getBean("getEmailService", EmailService.class); // the Bean ID is the method name in this case
        emailService1.sendEmail("toby@gmail.com", "Another one");


        // By Default the scope of the beans is Singleton, with mean one instance per application context //
        // ------------------------- Prototype Scope ---------------------- //
        EmailService emailServiceProto = context.getBean("emailServiceProto", EmailService.class);
        emailServiceProto.setValue("Value one");
        System.out.println(emailServiceProto.getValue());

        EmailService emailServiceProto1 = context.getBean("emailServiceProto", EmailService.class);
        System.out.println(emailServiceProto1.getValue()); // Null because it's a new instance

        // --------------- Same example with config class --------------- //
        EmailService emailServiceProto2 = context1.getBean("prototypeEmailService", EmailService.class);
        emailServiceProto2.setValue("Value two");
        System.out.println(emailServiceProto2.getValue());

        EmailService emailServiceProto3 = context1.getBean("prototypeEmailService", EmailService.class);
        System.out.println(emailServiceProto3.getValue()); // Null because it's a new instance
    }
}
