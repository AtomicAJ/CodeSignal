package com.codesignal.test;

import java.util.Stack;

public class Paranthesis {

    String reverseParanthesis(String s)
    {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c:chars)
        {
            if(c==')')
            {
                StringBuilder temp = new StringBuilder();
                while(!stack.isEmpty() && !(stack.peek()=='('))
                {
                    temp.append(stack.pop());
                }
                if(!stack.isEmpty())
                {
                    //remove the ( from stack
                    stack.pop();
                    for(char c1:temp.toString().toCharArray())
                    {
                        stack.push(c1);
                    }

                }
            }
            else {
                stack.push(c);
            }
        }
        while(!stack.isEmpty())
        {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

}
