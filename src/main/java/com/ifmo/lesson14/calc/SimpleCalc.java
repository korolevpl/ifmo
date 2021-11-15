package com.ifmo.lesson14.calc;

import java.util.HashMap;
import java.util.Scanner;

/*
 * Добавьте поддержку переменных.
 * Синтаксис следующий.
 * Объявление переменной через символ '=':
 * x = 8
 *
 * Имя переменной не может быть числом.
 *
 * Использование в выражении вместо одного или двух аргументов:
 * x + 2
 * Результат: 10.
 *
 * Калькулятор должен выбрасывать соответствующие исключения с
 * подробными описаниями ошибок и как их исправить. Например,
 * если имя переменной не найдено или использовался неверный синтаксис.
 */
public class SimpleCalc {
    // создать перменную, которая является картой с оператором new.
    static HashMap<String, Integer> variables = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter expression: ");

            String line = scanner.nextLine();

            if ("exit".equals(line))
                break;

            try {
                System.out.println("Answer is: " + calculate(line));
            }
            catch (CalcException e) {
                System.err.println("Error occurred: ");

                e.printStackTrace();
            }
        }
    }
    static boolean isNumber(String str) {
        if(str.length() == 0) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
        /*
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char value = chars[i];
            if(i != 0 && value == '-') {
                return false;
            } else if (!Character.isDigit(value) && value != '-') {
                return false;
            } else if (chars.length == 1 && value == '-') {
                return false;
            }
        }
        return true;
        */

    static int calculate(String line) throws CalcException {

        if (!line.contains("+") && !line.contains("-") && !line.contains("="))
            throw new CalcException("Expression must contain '+' or '-': " + line);

        String[] operands = line.split(" ");

        if (operands.length != 3)
            throw new CalcException("Expression must have only 3 operands separated with space (e.g. 2 + 4): " + line);

        OPERATOR operator = OPERATOR.parse(operands[1]); // operator = ASSIGNMENT

        int op1 = 0;
        int op2 = 0;
        if (isNumber(operands[0])) { // NUMBER
            op1 = parseOperand(operands[0]);
            op2 = parseOperand(operands[2]);
        } else { // NOT NUMBER
            if (operator == OPERATOR.ASSIGNMENT) {
                variables.put(operands[0], parseOperand(operands[2]));
                return parseOperand(operands[2]);
            } else {
                if (variables.containsKey(operands[0])) {
                    op1 = variables.get(operands[0]);
                    op2 = parseOperand(operands[2]);
                } else {
                    throw new CalcException("Variable is not found: " + line);
                }
            }
        }
        return operator.apply(op1, op2);
    }
//        throw new CalcException("Invalid expression: " + line);
//        int op1 = parseOperand(operands[0]);
//        int op2 = parseOperand(operands[2]);


    private static int parseOperand(String string) throws CalcException {
        // если символ, тогда достать значение по ключу из мапы.
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException e) {
            throw new CalcException("Wrong operand, must be only integer number: " + string, e);
        }
    }

    private enum OPERATOR {
        PLUS, MINUS, ASSIGNMENT;

        int apply(int arg1, int arg2) throws CalcException {
            switch (this) {

                case PLUS:
                    return arg1 + arg2;

                case MINUS:
                    return arg1 - arg2;
            }

            throw new CalcException("Unsupported operator: " + this);
        }

        static OPERATOR parse(String str) throws CalcException {
            switch (str) {
                case "+":
                    return PLUS;

                case "-":
                    return MINUS;

                case "=":
                    return ASSIGNMENT;
            }

            throw new CalcException("Incorrect operator: " + str);
        }
    }
}
