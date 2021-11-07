package com.ifmo.lesson5;

public class Triangle extends SquareTriangle {
    protected double c;
    protected double r;
    public Triangle(double a, double b, double c, double r) {
        super(a, b);
        this.c = c;
        this.r = r;
    }

    @Override
    public double area() {
        return (a * b * c) / 4 * r;
    }
}
