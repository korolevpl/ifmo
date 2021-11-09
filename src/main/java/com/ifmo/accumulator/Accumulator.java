package com.ifmo.accumulator;

public class Accumulator {

    private int value;
    private Operation op;

    public Accumulator (int startValue, Operation op) {
        this.value = startValue;
        this.op = op;
    }

    public int getValue() {
        return value;
    }

    public void calculate(int a) {
        value = op.calculate(value, a);
    }
}
