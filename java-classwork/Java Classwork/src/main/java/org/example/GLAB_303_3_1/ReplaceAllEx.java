package org.example.GLAB_303_3_1;

public class ReplaceAllEx {

    public static void main(String[] args) {
        String str1 = "Java123is456fun";
// regex for sequence of digits
        String regex = "\\d+";
// replace all occurrences of numeric
// digits by a space
        System.out.println(str1.replaceAll(regex, " "));
    }
}