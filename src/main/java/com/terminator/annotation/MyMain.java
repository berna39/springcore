package com.terminator.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyAppConfig.class); // Loading the context
        CloudService cloudService = context.getBean(CloudService.class); // Bean request
        cloudService.setName("GCP");
        cloudService.deploy();

        CloudService cloudService1 = context.getBean(CloudService.class);
        System.out.println(cloudService1.getName()); // GCP Because the scope is Singleton by default
    }
}
