package com.ifmo.lesson2;

public class First55 {
    /*
    Создайте программу, выводящую на экран первые 55 элементов последовательности 1 3 5 7 9 11 13 15 17 ….
     */
    public static void main(String[] args) {
        int i;
        int j = 1;
        int n = 55;
        for (i=0; i<n; i++) {
            System.out.println(j);
            j += 2;
        }
    }
}
