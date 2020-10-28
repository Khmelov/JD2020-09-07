package by.it.hryntsaliou.jd02_04;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private final Map<String, Integer> priority = new HashMap<>();

    {
        priority.put("=", 0);
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("*", 2);
        priority.put("/", 2);
    }

    Var calc(String expression) throws CalcException {
        expression = expression.replace(" ", "").trim();
        List<String> operands = new ArrayList<>(
                Arrays.asList(expression.split(Patterns.OPERATION))
        );
        Matcher matcherOperation = Pattern
                .compile(Patterns.OPERATION)
                .matcher(expression);
        List<String> operations = new ArrayList<>();
        while (matcherOperation.find()) {
            operations.add(matcherOperation.group());
        }
        while (operations.size() > 0) {
            int index = getIndexOperation(operations);
            String op = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var result = calcOneOperation(left, op, right);
            operands.add(index, result.toString());
        }

        return Var.createVar(operands.get(0));
    }

    private Var calcOneOperation(String leftOperand, String operation, String rightOperand) throws CalcException {
        Var right = Var.createVar(rightOperand);
        if (operation.contains("=")) {
            return Var.save(leftOperand, right);
        }
        Var left = Var.createVar(leftOperand);
        switch (operation) {
            case "+":
                return left.add(right);
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
        }
        throw new CalcException("неизвестная операция: " + leftOperand + operation + rightOperand);
    }

    private int getIndexOperation(final List<String> operations) {
        int index = -1;
        int priorityCurrent = -1;
        for (int i = 0; i < operations.size(); i++) {
            Integer priorityTmp = priority.get(operations.get(i));
            if (priorityTmp > priorityCurrent) {
                index = i;
                priorityCurrent = priorityTmp;
            }
        }
        return index;
    }
}
