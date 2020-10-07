package by.it._akhmelev_.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) {
        String[] parts = expression.split(Patterns.OPERATION, 2);

        if (parts.length == 1) return Var.createVar(expression);
        if (parts.length > 2) return null;

        Var right = Var.createVar(parts[1]);
        if (expression.contains("=")) return Var.save(parts[0], right);

        Var left = Var.createVar(parts[0]);
        if (left == null | right == null) return null;

        Matcher matcherOperation = Pattern
                .compile(Patterns.OPERATION)
                .matcher(expression);
        if (matcherOperation.find()) {
            switch (matcherOperation.group()) {
                case "+":
                    return left.add(right);
                case "-":
                    return left.sub(right);
                case "*":
                    return left.mul(right);
                case "/":
                    return left.div(right);
                default:
                    return null;
            }
        }
        return null;
    }
}
