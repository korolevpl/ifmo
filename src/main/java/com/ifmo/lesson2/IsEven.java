package com.ifmo.lesson2;

public class IsEven {
    /*
    Создать программу, проверяющую и сообщающую на экран, является ли целое число
    записанное в переменную n, чётным либо нечётным.
     */
    public static void main(String[] args) {
        int n = 24;

        System.out.println(isEven(n));
    }

    public static String isEven(int n) {
        // Допустимые строки: "Четное" или "Нечетное"
        String result;
        if (n % 2 == 0) {
            result = "Четное";
        } else {
            result = "Нечетное";
        }
        return result;
    }
}