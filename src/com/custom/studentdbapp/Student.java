package com.custom.studentdbapp;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentId;
    private String courses=""; // can be list or data structure
    private int tuitionBalance;
    private static int courseCost=20000;
    private static int id=1000;


    // constructor to prompt student name and year

    public Student(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Student First Name :");
        this.firstName =in.nextLine();

        System.out.println("Enter Student Last Name :");
        this.lastName =in.nextLine();

        System.out.println("\n enter 1 - freshman  , 2 - sophmore  , 3 - junior , 4 senior");
        System.out.println("\n Enter Student class level  :");
        this.gradeYear =in.nextInt();


        System.out.println(firstName + " " + lastName + " "+ gradeYear);
        setStudentId();
        System.out.println(this.studentId);
    }
    // generate an ID
    private void setStudentId() {
        // Grade Level + ID
        id++;
        this.studentId= gradeYear+""+id;
    }

    // enroll in courses
    public void enroll() {
        do {
            System.out.println(" Enter Course to enroll , Q to Quit !");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n" + course;
                tuitionBalance += courseCost;
            } else {
                break;
            }
        } while (1!=0);
        System.out.println("enrolled in "+ courses );
        System.out.println(" tuition balance " + tuitionBalance);
    }

    // view balance
    public void viewBalance(){
        System.out.println("Balance is : $"+ tuitionBalance);
    }

    // pay tuition
    public void payTuition(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Payment Amount:");
        int paymentAmount=in.nextInt();
        this.tuitionBalance -= paymentAmount;
        System.out.println(" thank you for your payment of " + paymentAmount);
        viewBalance();

    }


    //  show status
    public void showInfo(){
        System.out.println("\n"+firstName+
                " " + lastName
        + "enrolled as a " + gradeName(gradeYear) +
                "remaining balance " + tuitionBalance);
    }


    enum Grade {
        FRESHMAN(1),
        SOPHMORE(2),
        JUNIOR(3),
        SENIOR(4);

        private int gradeCode;

        public int getGradeCode() {
            return this.gradeCode;
        }

        Grade(){}
        private Grade(int gradeCode){
            this.gradeCode = gradeCode;
        }


    }


    public String gradeName(int gradeCode) {
        for (Grade g  : Grade.values()){
            if(gradeCode==g.gradeCode){
                return g.name();
            }
        }
        return "";
    }
}
