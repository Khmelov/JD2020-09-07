package by.it.shkatula.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) {

        String[] operand = expression.split(Patterns.OPERATION);
        Var first = Var.createVar(operand[0]);
        Var second = Var.createVar(operand[1]);
        if (first==null || second==null) {
            return null;
                    }
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            switch (operation) {
                case "+": return first.add(second);
                case "-": return first.sub(second);
                case "*": return first.mul(second);
                case "/": return first.div(second);

            }

        }
        return null;
    }
}
