package by.it.drugov.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) {
        String[] operands = expression.split(Patterns.OPERATION);
        Var leftOperand = Var.createVar(operands[0]);
        Var rightOperand = Var.createVar(operands[1]);
        if (leftOperand == null || rightOperand == null)
            return null; //TODO
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()) {
            String operation = matcher.group();
            switch (operation) {
                case "+":
                    return leftOperand.add(rightOperand);
                case "-":
                    return leftOperand.sub(rightOperand);
                case "*":
                    return leftOperand.mul(rightOperand);
                case "/":
                    return leftOperand.div(rightOperand);
            }
        }
        return null;
    }
}
