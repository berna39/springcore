package com.terminator.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// @Scope("prototype") -> this by default is Singleton
public class CloudService {

    private String name;

    public void deploy(){
        System.out.println(String.format("The Application is being deployed to %s", this.getName()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
