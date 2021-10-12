package com.ifmo.lesson2;

public class SymmetricClocks {
    /*
    Электронные часы показывают время в формате от 00:00 до 23:59. Подсчитать сколько
    раз за сутки случается так, что слева от двоеточия показывается симметричная комбинация
    для той, что справа от двоеточия (например, 02:20, 11:11 или 15:51)
     */
    public static void main(String[] args)
    {
        System.out.println(symmetricTimes());
    }

    public static int symmetricTimes() {
        int count = 0;
        int hours = 23;
        while (hours >= 0) {
            int part1 = hours / 10;
            int part2 = hours % 10;
            int minutes = 59;
            while (minutes >= 0) {
                int part3 = minutes / 10;
                int part4 = minutes % 10;
                if (part1 == part4 && part2 == part3) {
                    count++;
                }
                minutes--;
            }
            hours--;
        }
        return count;
    }
}
