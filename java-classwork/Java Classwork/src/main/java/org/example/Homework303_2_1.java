package org.example;

public class Homework303_2_1 {

    public static void main(String[] arg){

        // Write a program that declares two integer variables, assigns an integer to each, and adds them together.
        // Assign the sum to a variable. Print out the result.
        int num1 = 10;
        int num2 = 20;

        int sum = num1 + num2;
        System.out.println("The sum of " + sum);

        // Write a program that declares two double variables, assigns a number to each, and adds them together.
        // Assign the sum to a variable. Print out the result.
        double d1 = 10.5d;
        double d2 = 20.5d;

        double dSum = d1 + d2;
        System.out.println(dSum);

        // Write a program that declares an integer variable and a double variable, assigns numbers to each, and adds them together.
        // Assign the sum to a variable. Print out the result. What variable type must the sum be?
        int x = 10;
        double y = 50.55;

        double sum3 = x + y;
        System.out.println(sum3);

        // Write a program that declares two integer variables, assigns an integer to each, and divides the larger number by the smaller number.
        // Assign the result to a variable. Print out the result. Now change the larger number to a decimal. What happens? What corrections are needed?
        int v1 = 80;
        int v2 = 50;

        double div = (double)v1 / (double)v2;
        System.out.println(div);

        // Write a program that declares two double variables, assigns a number to each, and divides the larger by the smaller number.
        // Assign the result to a variable. Print out the result. Now, cast the result to an integer. Print out the result again.
        double n1 = 10.0;
        double n2 = 5.0;

        double result = n1 / n2;

        System.out.println("The result of dividing " + num1 + " by " + num2 + " is: " + result);
        // Skipped casting

        //



    }
}
