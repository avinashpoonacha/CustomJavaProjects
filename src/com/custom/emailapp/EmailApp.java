package com.custom.emailapp;

public class EmailApp {
    public static void main(String[] args) {

        Email johnEmail = new Email("John","Smith");

        johnEmail.setAlternateEmail("hohn@avi.com");
        System.out.println(johnEmail.getAlternateEmail());

        johnEmail.showInfo();
    }
}
