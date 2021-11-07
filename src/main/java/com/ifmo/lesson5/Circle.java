package com.ifmo.lesson5;

public class Circle extends Shape {
    protected double r;
    protected final static double p = 3.14;
    public Circle (double r) {
        this.r = r;
    }
    @Override
    public double area() {
        return p * (r * r);
    }
    
}
