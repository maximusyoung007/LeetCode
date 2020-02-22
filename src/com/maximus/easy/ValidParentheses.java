package com.maximus.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        if(s.equals(""))
            return true;
        Stack stack = new Stack();
        for(int i = 0;i < s.length();i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if(stack.isEmpty())
                    return false;
                else {
                    char c = (char)stack.peek();
                    if(map.get(c) != s.charAt(i))
                        return false;
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}
