package core;

import java.util.Scanner;

public class GPACalculatorTest {
    
    public static void main(String [] args){
        GPACalculator calc = new GPACalculator();
        Scanner s = new Scanner(System.in);
        calc.SGPA();
        System.out.println("Do you have old GPA? (Yes/No)");
        if(s.next().equalsIgnoreCase("yes"))calc.CGPA();
        System.out.printf("Your GPA is: %.2f\n", calc.getGpa());
    }
}
