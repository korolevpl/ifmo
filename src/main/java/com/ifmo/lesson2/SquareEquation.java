package com.ifmo.lesson2;

import java.util.Arrays;

public class SquareEquation {
    /*
     В три переменные a, b и c записаны три вещественных числа. Создать программу, которая
     будет находить и выводить на экран вещественные корни квадратного уравнения ax²+bx+c=0,
     либо сообщать, что корней нет.
     */
    public static void main(String[] args) {
        // double a = 2;
        // double b = -9;
        // double c = 9;

        double a = 3;
        double b = -18;
        double c = 27;

        double[] roots = squareEquationRoots(a, b, c);

        System.out.println(Arrays.toString(roots));
    }

    /*
    Возвращает массив из двух корней или null, если таковых нет.
     */
    //  failureMessage=a = 3.0, b = -18.0, c = 27.0 ==> expected: <[3.0]> but was: <[0.0, 27.0]>]
    public static double[] squareEquationRoots(double a, double b, double c) {
        double[] result = new double[2];
        double discriminant; // -324 - (4ac) = -648
        if (b < 0) {
            discriminant = (-1 * Math.pow(b, 2)) - (4 * a * c);
        } else {
            discriminant = Math.pow(b, 2) - (4 * a * c);
        }
        if (discriminant > 0) {
            result[0] = (-b - Math.sqrt(discriminant)) / (2 * a); // 18 + 25 / 6 = 7
            result[1] = (-b + Math.sqrt(discriminant)) / (2 * a); // 18 - 25 / 6 = 1
        } else if (discriminant == 0) {
            result[0] = (-b + Math.sqrt(discriminant)) / 2 * a;
        }
        return result;
    }
}
