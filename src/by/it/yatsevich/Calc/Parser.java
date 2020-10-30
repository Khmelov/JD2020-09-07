package by.it.yatsevich.Calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private final Map<String, Integer> mapPriority = new HashMap<>();

    {
        mapPriority.put("(",-1);
        mapPriority.put(")",-1);
        mapPriority.put("=", 0);
        mapPriority.put("+", 1);
        mapPriority.put("-", 1);
        mapPriority.put("*", 2);
        mapPriority.put("/", 2);
    }

    Var calc(String expression) throws CalcException {
        expression = expression.replace(" ", "").trim();
        List<String> operands = new ArrayList<>(
                Arrays.asList(expression.split(Patterns.OPERATION))
        );
        Matcher matcherOperaton = Pattern
                .compile(Patterns.OPERATION)
                .matcher(expression);
        List<String> operations = new ArrayList<>();
        while (matcherOperaton.find()) {
            operations.add(matcherOperaton.group());
        }
        while (operations.size() > 0) {
            int index = getIndexOperaton(operations);
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
            Var result = calcOneOperaton(left, op, right);
            operands.add(index, result.toString());
            if (brackets) {
                operations.remove(index-1);
                operands.remove(index-1);
            }
        }
        return Var.createVar(operands.get(0));
    }

    private Var calcOneOperaton(String strLeft, String operation, String strRight) throws CalcException {
        Var right = Var.createVar(strRight);
        if (operation.contains("="))
            return Var.saveVar(strLeft, right);
        Var left = Var.createVar(strLeft);
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
        throw new CalcException("Unknown operation " + left+operation+right);
    }

    private int getIndexOperaton(final List<String> operations){
        int index = -1;
        int mapPriorityCurrent= -1;
        for (int i = 0; i < operations.size(); i++) {
            Integer mapPriorityTmp = mapPriority.get(operations.get(i));
            if (mapPriorityTmp>mapPriorityCurrent){
                index=i;
                mapPriorityCurrent = mapPriorityTmp;
            }
        }return index;
    }
}
