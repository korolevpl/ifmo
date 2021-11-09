package com.ifmo.accumulator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Accumulator acc1 = new Accumulator(0, new Plus());
        System.out.println(acc1.getValue());
        acc1.calculate(1);
        System.out.println(acc1.getValue());
        acc1.calculate(9);
        System.out.println(acc1.getValue());

        Accumulator2 acc2 = new Accumulator2(new int[]{0, 0}, new Operation[] {new Plus(), new Minus()});
        System.out.println(Arrays.toString(acc2.getValue()));
        acc2.calculate(1);
        System.out.println(Arrays.toString(acc2.getValue()));
    }
}
