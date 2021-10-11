package com.ifmo.lesson2;

public class First20 {
    /*
     Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8
     16 32 64 128 ….
     */
    public static void main(String[] args) {
        int i;
        int j = 2;
        int n = 20;
        for (i=0; i<n; i++) {
            System.out.println(j);
            j *= 2;
        }
    }
}