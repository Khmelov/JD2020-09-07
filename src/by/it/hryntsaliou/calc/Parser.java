package by.it.hryntsaliou.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) {
        String[] parts = expression.split(Patterns.OPERATION);
        if (parts.length!=2){
            //TODO generate exception
            return null;
        }
        Var left = Var.createVar(parts[0]);
        Var right = Var.createVar(parts[1]);
        if (left == null || right == null) {
            return null;
        }
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()){
            String operation = matcher.group();
            switch (operation ){
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
            }
        }
        return null;
    }
}
