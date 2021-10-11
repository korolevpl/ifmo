package com.ifmo.lesson2;

import java.util.Random;

public class BiggestInRandom {
    /*
     Создать программу, выводящую на экран случайно сгенерированное трёхзначное
     натуральное число и его наибольшую цифру.Примеры работы программы:
     В числе 208 наибольшая цифра 8.
     В числе 774 наибольшая цифра 7.
     В числе 613 наибольшая цифра 6.
     */
    public static void main(String[] args) {
        int rnd = threeDigitRandom();

        String largestDigit = largestDigit(rnd);

        System.out.println(largestDigit);
    }

    public static int threeDigitRandom() {
        Random random = new Random();
        return random.nextInt(899) + 100;
    }

    public static String largestDigit(int rnd) {
        int max, digit1, digit2, digit3;

        digit1 = rnd % 10;
        digit2 = (rnd / 10) % 10;
        digit3 = rnd / 100;
        if (digit1 > digit2 && digit1 > digit3) {
            max = digit1;
        } else if (digit3 > digit2) {
            max = digit3;
        } else {
            max = digit2;
        }

        return "В числе " + rnd + " наибольшая цифра " + max + ".";
    }
}
