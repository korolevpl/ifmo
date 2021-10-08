package com.ifmo.lesson1;

public class TwoDigitsSum {
    /*
    В переменной n хранится натуральное двузначное число.
    Создайте программу, вычисляющую и выводящую на экран сумму цифр числа n.
     */
    public static void main(String[] args) {
        int n = 23;

        int sum = sum(n);

        System.out.println(sum);
    }

    public static int sum(int n) {
        // TODO implement
        int amount = 0;
        if (n != 0) {
            while (n != 0) {
                amount += n % 10;
                n = n / 10;
            }
            return amount;
        }
        return 0;
    }
}
