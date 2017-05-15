package com.wzt.code;

import java.util.Stack;

/**
 * Created by wzt on 2017/5/3.
 */
public class validParenthese {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static boolean isValid_best(String s) {
        if(s.length()==0) return true;
        char[] stack=new char[10000];
        int index=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='{'||ch=='('||ch=='['){
                stack[index++]=ch;
            }else if(ch=='}'){
                if(index==0||stack[index-1]!='{')
                    return false;
                index--;
            }else if(ch==')'){
                if(index==0||stack[index-1]!='(')
                    return false;
                index--;
            }else if(ch==']'){
                if(index==0||stack[index-1]!='[')
                    return false;
                index--;
            }
        }
        return index==0;
    }

    public static void main(String[] args) throws Exception {
        String test = "[{}]{}";
        System.out.println("is this valid ?");
        System.out.printf("%s\n", isValid(test));
        System.out.printf("%s", isValid_best(test));
    }
}
