package com.ifmo.lesson2;

public class ClosestToTen {
    /*
     Создать программу, выводящую на экран ближайшее к 10 из двух чисел, записанных в
     переменные m и n. Например, среди чисел 8,5 и 11,45 ближайшее к десяти 11,45.
     */
    public static void main(String[] args) {
        float m = 8.5f;
        float n = 11.45f;

        // float m = 23.6f;
        // float n = 5.9f;

        // float m = 8.5f;
        // float n = 12.0f;

        float closestToTen = closestToTen(m, n);

        System.out.println(closestToTen);
    }

    public static float closestToTen(float m, float n) {
        final int ten = 10;
        float m2;
        float n2;

        if (ten - m < 0) {
            m2 = m - ten;
        } else {
            m2 = ten - m;
        }

        if (ten - n < 0) {
            n2 = n - ten;
        } else {
            n2 = ten - n;
        }

        if (m2 < n2) {
            return m;
        }
        return n;
    }
}
