package com.custom.emailapp;

import lombok.Data;

import java.util.Scanner;

@Data
public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String emailAddress;
    private String department;
    private int mailBoxCapacity=500;
    private String alternateEmail;
    private int defaultPasswordLength=8;
    private String companyName="avi";


    // Constructor to receive names

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED -->" + this.firstName + "  " + this.lastName);

        // call a method asking for a dept
        this.department = setDepartment();
        System.out.println(" DEPARTMENT is " + this.department);

        // call a method for random password
        this.password = getRandomPassword(defaultPasswordLength);
        System.out.println("PASSWORD is " + this.password) ;

        // generate Email
        this.emailAddress = firstName.toLowerCase()+"."+lastName.toLowerCase()+"_"+this.department+"@"+ companyName+".com";
        System.out.println("EMAIL CREATED :" + this.emailAddress);
    }

    //ask for department
    private String setDepartment(){
        System.out.print("DEPARTMENT CODES : \n 1 for Sales \n 2 for Development \n 3 for Accounting" +
                "\n 0 for none");

        System.out.println("Enter the Department Code:");

        Scanner in = new Scanner(System.in);
        int deptChoice = in.nextInt();
        if (deptChoice == 1) {
            return "sales";
        } else if (deptChoice == 2) {
            return "dev";
        } else if (deptChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    // Generate Random Password
    private String getRandomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char [] password = new char[length];
        for(int i =0; i< length;i++) {
            int rand= (int) (Math.random() * passwordSet.length());
            password[i]= passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailBoxCapacity=capacity;
    }

    /// set alternate email
    public void alternateEmail(String altEmail){
        this.alternateEmail= altEmail;
    }

    // change password
    public void changePassword(String passowrd){
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailBoxCapacity;
    }

    public String getAltEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    // Show info
    public void showInfo() {
        System.out.println(" FIRST NAME : " + firstName + "\n SECOND NAME : " + lastName + "\nEMAIL CREATED: " +
                emailAddress );
    }

}
