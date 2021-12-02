package com.pengo.stack;

import java.util.Map;
import java.util.Stack;

/**
 * @author pengo
 * @description:
 * @date 2021/12/2 11:54 上午
 */
public class StackDemo {
    public static void main(String[] args) {
        testCalculate();
    }

    public static void testCalculate() {
        String exp = "x+2*(y-5)";
        SuffixExpression se = compile(exp);
        Map<String, Integer> env = Map.of("x", 1, "y", 9);
        int result = se.execute(env);
        System.out.println(exp + " = " + result + " " + (result == 1 + 2 * (9 - 5) ? "✓" : "✗"));
    }

    static SuffixExpression compile(String exp) {
        Stack<String> symbol = new Stack<>();
        Stack<String> numbers = new Stack<>();
        char[] chars = exp.toCharArray();
        for (char c : chars) {
            if ((c < 58 && c > 47) || (c > 96 && c < 123)) {
                numbers.push(String.valueOf(c));
            } else {
                symbol.push(String.valueOf(c));
            }
        }
        return new SuffixExpression(symbol, numbers);
    }

    public static void testHex() {
        int number = 12500;
        Stack<String> stack = new Stack<>();
        while (true) {
            int remind = number % 16;
            switch (remind) {
                case 10:
                    stack.push("A");
                    break;
                case 11:
                    stack.push("B");
                    break;
                case 12:
                    stack.push("C");
                    break;
                case 13:
                    stack.push("D");
                    break;
                case 14:
                    stack.push("E");
                    break;
                case 15:
                    stack.push("F");
                    break;
                default:
                    stack.push(String.valueOf(remind));
            }
            number = number / 16;
            if (number == 0) {
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder);  //30D4
    }
}

class SuffixExpression{
    private Stack<String> symbol;
    private Stack<String> numbers;

    public SuffixExpression(Stack<String> symbol, Stack<String> numbers) {
        this.symbol = symbol;
        this.numbers = numbers;
    }

    int execute(Map<String, Integer> env){
        do {
            if (symbol.peek().charAt(0) == 41 || symbol.peek().charAt(0) == 40) {
                symbol.pop();
            }
            String pop = symbol.pop();
            Integer num1;
            Integer num2;
            if (env.containsKey(numbers.peek())) {
                num1 = env.get(numbers.pop());
            } else {
                num1 = Integer.valueOf(numbers.pop());
            }
            if (env.containsKey(numbers.peek())) {
                num2 = env.get(numbers.pop());
            } else {
                num2 = Integer.valueOf(numbers.pop());
            }
            numbers.push(getNum(num1, num2, pop));
        } while (symbol.size() != 0);
        return Integer.parseInt(numbers.pop());
    }

    String getNum(Integer num1, Integer num2, String sym) {
        switch (sym) {
            case "+":
                return String.valueOf(num2 + num1);
            case "-":
                return String.valueOf(num2 - num1);
            case "*":
                return String.valueOf(num2 * num1);
            case "/":
                return String.valueOf(num2 / num1);
        }
        return null;
    }
}