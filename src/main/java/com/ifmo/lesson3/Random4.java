package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Random;

public class Random4 {
    /*
    Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его на экран в
    строку. Определить и вывести на экран сообщение о том, является ли массив строго
    возрастающей последовательностью.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();
        System.out.println(Arrays.toString(randomNumbers));
        System.out.println(isIncreasingSequence(randomNumbers));
    }

    public static int[] randomNumbers() {
        int min = 10;
        int max = 99;
        int[] array = new int[4];
        for (int i=0; i<array.length; i++) {
            Random random = new Random();
            array[i] = random.nextInt(max - min) + min;
        }
        return array;
    }

    public static boolean isIncreasingSequence(int[] randomNumbers) {
        if (randomNumbers[0] < randomNumbers[1]) {
            if(randomNumbers[1] < randomNumbers[2]) {
                if (randomNumbers[2] < randomNumbers[3]) {
                    return true;
                }
            }
        }
        return false;
    }
}
