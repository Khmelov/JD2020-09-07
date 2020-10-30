package by.it.kalashnikov.calculator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private final Map<String, Integer> pr = new HashMap<>();

    {
        pr.put("(", -1);
        pr.put(")", -1);
        pr.put("=", 0);
        pr.put("+", 1);
        pr.put("-", 1);
        pr.put("*", 2);
        pr.put("/", 2);
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
            boolean skobki = false;
            if (index != 0 && operations.get(index - 1).equals("(") && operations.get(index + 1).equals(")")) {
                int skobkiInEnd = 0;
                for (int i = operations.size() - 1; i >= 0; i--) {
                    if (operations.get(i).equals(")")) skobkiInEnd++;
                    else break;
                }
                operations.remove(index + 1);
                if (index < operations.size() - skobkiInEnd) operands.remove(index + 2);
                skobki = true;
            }
            String op = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var result = calcOneOperation(left, op, right);
            operands.add(index, result.toString());
            if (skobki) {
                operations.remove(index - 1);
                operands.remove(index - 1);
            }
        }
        return Var.createVar(operands.get(0));

    }

    private Var calcOneOperation(String strLeft, String op, String strRight) throws CalcException {

        Var right = Var.createVar(strRight);
        if (op.contains("="))
            return Var.save(strLeft, right);

        Var left = Var.createVar(strLeft);

        switch (op) {
            case "+":
                return left.add(right);
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
        }
        throw new CalcException("Неизвестная операция " + left + op + right);
    }

    private int getIndexOperation(final List<String> operations) {
        int index = -1;
        int prCurrent = -1;
        for (int i = 0; i < operations.size(); i++) {
            Integer prTmp = pr.get(operations.get(i));
            if (i != 0 && operations.get(i - 1).equals("(") && operations.get(i + 1).equals(")")) {
                return index = i;
            }
            if (prTmp > prCurrent) {
                prCurrent = prTmp;
                index = i;
            }
        }
        return index;
    }
}
