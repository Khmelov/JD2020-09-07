package by.it.makovsky.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements Patterns {
    private final Map<String, Integer> pr = new HashMap<>();

    {
        pr.put("(",-1);
        pr.put(")",-1);
        pr.put("=", 0);
        pr.put("+", 1);
        pr.put("-", 1);
        pr.put("*", 2);
        pr.put("/", 2);
    }

    Var calc(String expression) throws CalcException {
        expression = expression.replace(" ", "").trim();
        List<String> operands = new ArrayList<>(
                Arrays.asList(expression.split(Patterns.OPERATIONS))
        );
        Matcher matcherOperation = Pattern
                .compile(Patterns.OPERATIONS)
                .matcher(expression);
        List<String> operations = new ArrayList<>();
        while (matcherOperation.find()) {
            operations.add(matcherOperation.group());
        }
        while (operations.size() > 0) {
            int index = getIndexOperation(operations);
            boolean brackets=false;
            if (index!=0&&operations.get(index-1).equals("(")&&operations.get(index+1).equals(")")){
                int numberBracketsInEnd=0;
                for (int i = operations.size() - 1; i >= 0; i--) {
                    if (operations.get(i).equals(")")) numberBracketsInEnd++;
                    else break;
                }
                operations.remove(index+1);
                if (index<operations.size()-numberBracketsInEnd)operands.remove(index+2);
                brackets=true;
            }

            String op = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var result = calcOneOperation(left, op, right);
            operands.add(index, result.toString());

            if (brackets) {
                operations.remove(index-1);
                operands.remove(index-1);
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

    private int getIndexOperation(List<String> operations) {
        int index = -1;
        int prCurrent = -1;
        for (int i = 0; i < operations.size(); i++) {
            Integer prTmp = pr.get(operations.get(i));
            if (i!=0&&operations.get(i-1).equals("(")&&operations.get(i+1).equals(")")) {
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
