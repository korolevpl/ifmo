package com.ifmo.lesson3;

import java.util.Arrays;

public class UnevenArray<unevenArray> {
    /*
    Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку, а затем
    этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 … 7 5 3
    1)
     */
    public static void main(String[] args) {
        int[] unevenArray = unevenArray();

        System.out.println(Arrays.toString(unevenArray));

        int[] reverseArray = unevenArray;
        for (int i=0, j = reverseArray.length -1; i<=j; i++, j--) {
            int tmp = reverseArray[i];
            reverseArray[i] = reverseArray[j];
            reverseArray[j] = tmp;
        }
        System.out.println(Arrays.toString(reverseArray));
    }

    public static int[] unevenArray() {
        int[] array = new int[50];
        int j = 0;
        for (int i=1; i<=99; i++) {
            if (i%2 != 0) {
                array[j] = i;
                j++;
            }
        }
        return array;
    }
}
