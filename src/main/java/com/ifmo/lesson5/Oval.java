package com.ifmo.lesson5;

public class Oval extends Circle {
    protected double a;
    protected double b;
    protected double p;

    public Oval (double a, double b) {
        super(Circle.p);
        this.a = a;
        this.b = b;
    }
    @Override
    public double area () {
        return p * a * b;
    }
}
