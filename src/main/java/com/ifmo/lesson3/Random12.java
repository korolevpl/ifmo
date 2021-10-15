package com.ifmo.lesson3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Random12 {
    /*
    Создайте массив из 12 случайных целых чисел из отрезка [-15;15]. Определите какой
    элемент является в этом массиве максимальным и сообщите индекс его последнего
    вхождения в массив.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        System.out.println(Arrays.toString(randomNumbers));
        int max = max(randomNumbers);
        int maxLastIndex = lastIndexOf(randomNumbers, max);

        System.out.println(maxLastIndex);
    }

    public static int[] randomNumbers() {
        int min = -15;
        int max = 15;
        int[] array = new int[12];
        for (int i=0; i<array.length; i++) {
            Random random = new Random();
            if (i%2 == 0) {
                array[i] = random.nextInt(max - min + 1) + min;
            }
        }
        return array;
    }

    public static int max(int[] randomNumbers) {
        int max = randomNumbers[0];
        for (int i=1; i<randomNumbers.length; i++) {
            if(randomNumbers[i] > max) {
                max = randomNumbers[i];
            }
        }
        return max;
    }

    public static int lastIndexOf(int[] randomNumbers, int max) {
        // int index = Arrays.binarySearch(randomNumbers, max);
        int lastIndex = 0;
        for (int i=0; i<randomNumbers.length; i++) {
            if (randomNumbers[i] == max) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }
}
