package com.terminator;

public class EmailService {

    private String Value;

    public void sendEmail(String receiver, String message){
        System.out.println(String.format("Sending %s to %s", message, receiver));
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
