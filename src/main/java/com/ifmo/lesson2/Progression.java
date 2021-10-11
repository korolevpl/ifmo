package com.ifmo.lesson2;

public class Progression {
    /*
     Создайте программу, выводящую на экран все четырёхзначные числа последовательности
     1000 1003 1006 1009 1012 1015 ….
     */
    public static void main(String[] args) {
        int i;
        int j = 1000;
        int n = 9999;
        for (i=1; j<=n; i++) {
            System.out.println(j);
            j += 3;
        }
    }
}
