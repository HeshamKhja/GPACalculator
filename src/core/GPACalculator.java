package core;

import interfaces.IGPACalculator;
import java.util.Scanner;

public class GPACalculator implements IGPACalculator{
    
    private static final Scanner s = new Scanner(System.in);
    private double w;
    private double gpa = 0.0;
    private int cot = 0;
    private int co;

    public GPACalculator(){
        
    }
        
    @Override
    public double getGpa() {
        return gpa;
    }

    @Override
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
