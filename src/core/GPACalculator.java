package core;

import interfaces.IGPACalculator;
import java.util.Scanner;

public class GPACalculator implements IGPACalculator{
    
    private static final Scanner s = new Scanner(System.in);
    private double w = 0.0;
    private double gpa = 0.0;
    private int cot = 0;
    private int co = 0;

    public GPACalculator(){
        
    }
        
    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    @Override
    public void SGPA(){
        System.out.println("Enter Grades | Credit hours (To stop type \"stop\"):");
        String grade = s.next();
        while (!grade.equalsIgnoreCase("stop")) {
            co = s.nextInt();
            switch (grade){
                case "A+" : w = 4.00; break;
                case "A" : w = 3.75; break;
                case "B+" : w = 3.50; break;
                case "B" : w = 3.00; break;
                case "C+" : w = 2.50; break;
                case "C" : w = 2.00; break;
                case "D+" : w = 1.50; break;
                case "D" : w = 1.00; break;
                case "F" : w = 0.00;
            }
            cot += co;
            gpa += (co * w);
            grade = s.next();
        }
        gpa = gpa / cot;
    }
    
    @Override
    public void CGPA(){
        System.out.println("Enter old GPA | old credit hours:");
        double oldgpa = s.nextDouble();
        co = s.nextInt();
        gpa = ((gpa * cot) + (oldgpa * co))/(cot + co);
    }
    
}


/*
    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        double w = 0.0;
        double gpa = 0.0;
        int cot = 0;
        int co = 0;
        System.out.println("Enter Grades | Credit hours (To stop type \"stop\"):");
        String grade = s.next();
        while (!grade.equalsIgnoreCase("stop")) {
            co = s.nextInt();
            switch (grade){
                case "A+" : w = 4.00; break;
                case "A" : w = 3.75; break;
                case "B+" : w = 3.50; break;
                case "B" : w = 3.00; break;
                case "C+" : w = 2.50; break;
                case "C" : w = 2.00; break;
                case "D+" : w = 1.50; break;
                case "D" : w = 1.00; break;
                case "F" : w = 0.00;
            }
            cot += co;
            gpa += (co * w);
            grade = s.next();
        }
        gpa = gpa / cot;
        System.out.println("Do you have old GPA? (Yes/No)");
        if(s.next().equalsIgnoreCase("yes")){
            System.out.println("Enter old GPA | old credit hours:");
            double oldgpa = s.nextDouble();
            co = s.nextInt();
            gpa = ((gpa * cot) + (oldgpa * co))/(cot + co);
        }
        System.out.println("gpa " + gpa);
    }
*/
