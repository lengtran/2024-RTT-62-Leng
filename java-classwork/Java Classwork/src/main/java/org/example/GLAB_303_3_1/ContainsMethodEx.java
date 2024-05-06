package org.example.GLAB_303_3_1;

public class ContainsMethodEx {

    public static void main(String[] args) {
        String str1 = "Ewww Wine";
        Boolean result;
// check if str1 contains "Java"
        result = str1.contains("Wine");
        System.out.println(result); // true
// check if str1 contains "Python"
        result = str1.contains("Python");
        System.out.println(result); // false
// check if str1 contains ""
        result = str1.contains("");
        System.out.println(result); // true
    }
}