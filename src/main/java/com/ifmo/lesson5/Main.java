package com.ifmo.lesson5;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(2);
        Rectangle rectangle = new Rectangle(3, 5);
        printArea(square, rectangle);
    }

    private static void printArea(Shape...shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape.area());
        }
    }
}
