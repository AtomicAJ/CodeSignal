package com.codesignal.test;

import java.util.Stack;

public class LevelSeven {

    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    temp.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // Pop the '('
                    for (char ch : temp.toString().toCharArray()) {
                        stack.push(ch); // Push reversed characters back to stack
                    }
                } else {
                    result.append(temp.reverse()); // Append reversed characters to the result
                }
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()); // Append remaining characters to the result
        }

        return result.toString();
    }
}
