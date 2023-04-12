package com.terminator.config;

import com.terminator.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public EmailService getEmailService(){
        return new EmailService();
    }

    @Bean
    @Scope("prototype")
    public EmailService prototypeEmailService(){
        return  new EmailService();
    }
}
