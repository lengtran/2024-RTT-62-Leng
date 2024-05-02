package org.example;

import java.text.DecimalFormat;

public class Homework303_2_1 {
    static final double SALES_TAX = 0.045;
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

        // Write a program that declares two integer variables, x and y, and assigns the number 5 to x and the number 6 to y.
        // Declare a variable q and assign y/x to it and print q. Now, cast y to a double and assign it to q. Print q again.

//        int x = 5;
//        int y = 6;
//
//        int q = y/x;
//
//        System.out.println("After integer division: " + q);
//
//        q = (double) y;
//
//        System.out.println("After casting y to double: " + q);

        // Write a program that declares a named constant and uses it in a calculation. Print the result.

        final double PI = 3.141592653589793;

        double radius = 5.0;
        double area = PI * Math.pow(radius, 2);

        System.out.println("The area of the circle is: " + area);


        // Write a program where you create three variables that represent products at a cafe. The products could be beverages like coffee, cappuccino, espresso, green tea, etc.
        // Assign prices to each product. Create two more variables called subtotal and totalSale and complete an “order” for three items of the first product, four items of the second product, and two items of the third product.
        // Add them all together to calculate the subtotal. Create a constant called SALES_TAX and add sales tax to the subtotal to obtain the totalSale amount. Be sure to format the results to two decimal places.

        double coffee = 2.5;
        double cappuccino = 3.5;
        double espresso = 4.5;

        double subtotal = (coffee * 3) + (cappuccino * 4) + (espresso * 2);

        double salesTaxAmount = subtotal * SALES_TAX;
        double totalAmount = subtotal *salesTaxAmount;

        DecimalFormat df = new DecimalFormat("0.##");

        System.out.println("subtotal : " + df.format(subtotal));
        System.out.println("Sales Tax : " + df.format(salesTaxAmount));
        System.out.println("Total Sale : " + df.format(totalAmount));


    }
}
