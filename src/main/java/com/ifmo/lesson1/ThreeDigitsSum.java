package com.ifmo.lesson1;

public class ThreeDigitsSum {
    /*
    В переменной n хранится натуральное трёхзначное число.
    Создайте программу, вычисляющую и выводящую на экран сумму цифр числа n.
     */
    public static void main(String[] args) {
        int n = 123;

        int sum = sum(n);

        System.out.println(sum);
    }

    public static int sum(int n) {
        if (n > 0) {
            int digit, amount = 0;
            int number = n;
            for (int i = 1; n/i > 0; i *= 10) {
                digit = number % 10;
                amount += digit;
                number = number / 10;
            }
            return amount;
        }
        return 0;
    }
}
