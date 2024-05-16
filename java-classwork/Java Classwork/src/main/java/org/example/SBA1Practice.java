package org.example;

public class SBA1Practice {

    public static void main(String[] args) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // PART 1 - Create a for loop to print each character of the string s on its own line
        // You can use the s.charAt(pos) function
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }


        //PART 2 - Given the following string convert them to integer values   Integer.valueOf()
        String ten = "10";
        String hundred = "100";

        int tenInt = Integer.valueOf(ten);
        int hundredInt = Integer.valueOf(hundred);

        System.out.println("The integer value of '10' is: " + tenInt);
        System.out.println("The integer value of '100' is: " + hundredInt);


        //PART 3 - Given an integer array find the sum of all the integers in the array
        int[] array = {2, 4, 5, 6, 7, 8, 10};
        int sum1 = 0;

        for (int i = 0; i < array.length; i++) {
            sum1 += array[i];
        }

        System.out.println("The sum of all integers in the array is: " + sum1);


        //PART 4 - Given the array of string convert them to numbers and print the sun
        String[] nums= { "2", "4", "5", "6", "7", "8", "10" };
        int sum2 = 0;

        for (String num : nums) {
            sum2 += Integer.parseInt(num);
        }

        System.out.println("The sum is: " + sum2);

    }
}