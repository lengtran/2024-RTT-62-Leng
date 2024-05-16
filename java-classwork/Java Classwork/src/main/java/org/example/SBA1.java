package org.example;

public class SBA1 {
        public static void main(String[] args) {
            System.out.println(getDigitsSum(967532)); // 32
            System.out.println(getDigitsSum(1234567)); // 28
        }
        public static int getDigitsSum(int largeNumber) {

            int sum = 0;
            while (largeNumber != 0) {
                int lastDigit = largeNumber % 10;
                sum += lastDigit;
                largeNumber /= 10;
            }
            return sum;
        }
    }
