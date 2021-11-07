package com.ifmo.lesson5;

public class SquareTriangle extends Shape {
    protected double a;
    protected double b;
    public SquareTriangle(double a, double b) {
        this.a = a;
        this.a = b;
    }
    @Override
    public double area() {
        return 1/2 * a * b;
    }
}
