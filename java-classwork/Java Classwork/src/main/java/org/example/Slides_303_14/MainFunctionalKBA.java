package org.example.Slides_303_14;

public class MainFunctionalKBA {

    public static void main(String[] args) {
        MyFunctionalInterfaceKBA fi = n -> {
            return n * n;
        };

        MyFunctionalInterfaceKBA fil = new MyFunctionalInterfaceKBA() {
            @Override
            public Integer sqr(int a) {
                return a * a;
            }
        };

        System.out.println(fi.sqr(5));
    }
}
