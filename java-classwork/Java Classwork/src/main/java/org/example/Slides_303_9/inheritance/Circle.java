package org.example.Slides_303_9.inheritance;

import java.util.Arrays;

public class Circle extends Shape {


    private double diameter;

    public double calculateArea() {
        area = 456;
        return Math.PI * (diameter / 2) * (diameter / 2);
    }


    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }
}

