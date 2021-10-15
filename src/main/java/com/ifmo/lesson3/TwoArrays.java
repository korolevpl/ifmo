package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Random;

public class TwoArrays {
    /*
     Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый, выведите
     массивы на экран в двух отдельных строках. Посчитайте среднее арифметическое элементов
     каждого массива и сообщите, для какого из массивов это значение оказалось больше (либо
     сообщите, что их средние арифметические равны).
     */
    public static void main(String[] args) {
        int[] randomNumbers1 = randomNumbers();
        int[] randomNumbers2 = randomNumbers();

        System.out.println(Arrays.toString(randomNumbers1));
        System.out.println(Arrays.toString(randomNumbers2));

        int average1 = average(randomNumbers1);
        int average2 = average(randomNumbers2);

        if (average1 > average2) {
            System.out.println("average1 > average2");
        } else if (average1 < average2) {
            System.out.println("average1 < average2");
        } else {
            System.out.println("average1 = average2");
        }
    }

    public static int[] randomNumbers() {
        int[] array = new int[5];
        for (int i=0; i<array.length; i++) {
            Random random = new Random();
            array[i] = random.nextInt(5) + 1;
        }
        return array;
    }

    public static int average(int[] randomNumbers) {
        // (element1 + element2 + ... + element5) / array.length

        int amount = 0;
        for(int i=0; i<randomNumbers.length; i++) {
            amount += randomNumbers[i];
        }
        int average = amount / randomNumbers.length;

        return average;
    }
}
