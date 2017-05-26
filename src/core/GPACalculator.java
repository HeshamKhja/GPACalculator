package core;

import interfaces.IGPACalculator;
import java.util.Scanner;

public class GPACalculator implements IGPACalculator{
    
    private static final Scanner SCANNER = new Scanner(System.in);
    private double w;
    private double gpa = 0.0;
    private int cot = 0;
    private int co;
    private static GPACalculator instance = null;

    private GPACalculator(){
        
    }
    
    public static GPACalculator getInstance(){
        if (instance == null) {
            instance = new GPACalculator();
        }
        return instance;
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
        String grade = SCANNER.next();
        while (!grade.equalsIgnoreCase("stop")) {
            co = SCANNER.nextInt();
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
            grade = SCANNER.next();
        }
        gpa = gpa / cot;
    }
    
    @Override
    public void CGPA(){
        System.out.println("Enter old GPA | old credit hours:");
        double oldgpa = SCANNER.nextDouble();
        co = SCANNER.nextInt();
        gpa = ((gpa * cot) + (oldgpa * co))/(cot + co);
    }
    
}
