package com.terminator.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class); // Loading the context
        // Could also load like this using an XML Configuration file:
        // ApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation.xml");

        CloudService cloudService = context.getBean(CloudService.class); // Bean request
        // Could also request the Bean like this using byName:
        // CloudService cloudService = context.getBean("myBeanName", CloudService.class);
        cloudService.setName("GCP");
        cloudService.deploy();

        CloudService cloudService1 = context.getBean(CloudService.class);
        System.out.println(cloudService1.getName()); // GCP Because the scope is Singleton by default
    }
}
