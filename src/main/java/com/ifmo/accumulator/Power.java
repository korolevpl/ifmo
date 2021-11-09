package com.ifmo.accumulator;

public class Power implements Operation {
    public int calculate(int a, int b) {
        int result = 1;
        for (int i=1; i<=b; i++) {
            result = result * a;
        }
        return result;
    }
}
