package org.example;

public class Tester {

    public static void main(String[] args) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // PART 1 - Create a for loop to print each character of the string s on its own line
        // You can use the s.charAt(pos) function
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
    }
}