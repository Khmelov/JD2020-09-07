package by.it.mialeshka.jd01_12;

import java.util.Scanner;
import java.util.Stack;

public class TaskC3 {
    static boolean isCorrect(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if(symbol == '{' || symbol == '(' || symbol == '[')
                stack.push(symbol);
            if(symbol == ']'){
                if (stack.empty() || stack.pop() != '[')
                    return false;
            }
            if(symbol == ')'){
                if (stack.empty() || stack.pop() != '(')
                    return false;
            }
            if(symbol == '}'){
                if (stack.empty() || stack.pop() != '{')
                    return false;
            }
        }
        if (!stack.empty())
            return false;
        return true;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(isCorrect(str));
    }
}
