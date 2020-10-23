package by.it.trukhanovich.jd02_04;

import by.it.trukhanovich.calc.CalcException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private Map <String,Integer> priority= new HashMap<>();
    {
    priority.put("(",-1);
    priority.put(")",-1);
    priority.put("=",0);
    priority.put("+",1);
    priority.put("-",1);
    priority.put("*",2);
    priority.put("/",2);
    }

    by.it.trukhanovich.calc.Var calc (String expression) throws by.it.trukhanovich.calc.CalcException {
        expression = expression.replace(" ", "").trim();
        List<String> operands = new ArrayList<>(
                Arrays.asList(expression.split(by.it.trukhanovich.calc.Patterns.OPERANIONS))
        );
        Pattern patternOperation = Pattern.compile(by.it.trukhanovich.calc.Patterns.OPERANIONS);
        Matcher matcherOperation = patternOperation.matcher(expression);
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
            String removeOperation = operations.remove(index);
            String leftOperand = operands.remove(index);
            String rightOperand = operands.remove(index);
//            if (brackets) {operands.remove(index+2);}
            by.it.trukhanovich.calc.Var result = calcOneOperation(leftOperand, removeOperation, rightOperand);
            operands.add(index,result.toString());
            if (brackets) {
                operations.remove(index-1);
                operands.remove(index-1);
            }
        }
        return by.it.trukhanovich.calc.Var.createVar(operands.get(0));
    }


    private by.it.trukhanovich.calc.Var calcOneOperation(String leftOperand, String operation, String rightOperand) throws by.it.trukhanovich.calc.CalcException {
        by.it.trukhanovich.calc.Var right= by.it.trukhanovich.calc.Var.createVar(rightOperand);
        if (operation.contains("=")) {
            return by.it.trukhanovich.calc.Var.saveVar(leftOperand,right);
        }
        by.it.trukhanovich.calc.Var left= by.it.trukhanovich.calc.Var.createVar(leftOperand);

            switch (operation){
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
            }
        throw new CalcException("неизвестная операция: "+leftOperand+operation+rightOperand);
    }

    private int getIndexOperation(List<String> operations) {
        int index=-1;
        int priorityCurrent=-1;
        for (int i = 0; i < operations.size(); i++) {
            Integer priorityTemp = priority.get(operations.get(i));
            if (i!=0&&operations.get(i-1).equals("(")&&operations.get(i+1).equals(")")) {
                return index = i;
            }
            if (priorityTemp>priorityCurrent) {
                priorityCurrent=priorityTemp;
                index=i;
            }

        }
        return index;
    }
}
