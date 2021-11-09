package com.ifmo.accumulator;

public class Accumulator2 {

    private int[] values;
    private Operation[] ops;

    public Accumulator2(int[] startValue, Operation[] ops) {
        this.values = startValue;
        this.ops = ops;
    }

    public int[] getValue() {
        return values;
    }

    public void calculate(int a) {
        for (int i=0; i<values.length; i++) {
            values[i] = ops[i].calculate(values[i], a);
        }
    }
}
