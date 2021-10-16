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

        // Можно также использовать System.arraycopy() или метод clone()

        int[] resultArray = Arrays.copyOf(unevenArray,unevenArray.length * 2);
        /*
        for(int i=0; i < unevenArray.length; i++) {
            resultArray[i] = unevenArray[i];
        }
        */
        int[] reverseArray = unevenArray;
        for (int i=0, j = reverseArray.length -1; i<=j; i++, j--) {
            int tmp = reverseArray[i];
            reverseArray[i] = reverseArray[j];
            reverseArray[j] = tmp;
        }
        /*
        for (int i=0; i<reverseArray.length; i++) {
            Arrays.fill(resultArray, 50, resultArray.length, reverseArray[i]);
        }
        */
        for(int i=unevenArray.length, j=0; i < resultArray.length; i++, j++) {
            resultArray[i] = reverseArray[j];
        }
        System.out.println(Arrays.toString(resultArray));
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
