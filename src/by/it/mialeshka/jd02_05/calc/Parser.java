package by.it.mialeshka.jd02_05.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Map<String, Integer> mapPrior = new HashMap<>();{
        mapPrior.put("=", 0);
        mapPrior.put("+", 1);
        mapPrior.put("-", 1);
        mapPrior.put("*", 2);
        mapPrior.put("/", 2);
    }
    Var calc(String expression) throws CalcException {
        expression = expression.replace(" ", "");
        if(expression.charAt(0) == '(')
            expression = expression.substring(1, expression.length()-1);

        while (expression.contains("(")){
            Matcher matcherGroup = Pattern.compile(Patterns.GROUPOPERATION).matcher(expression);
            while (matcherGroup.find()){
                Var groupValue = calc(matcherGroup.group());
                expression = expression.replace(matcherGroup.group(), groupValue.toString());
            }
        }

        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()){
            operations.add(matcher.group());
        }

        if (operands.size() == 0){
            throw new CalcException(ErrMesages.res.get(ErrMesages.expressionUnknown));
        }
        Var result;
        while (operations.size() > 0){
            int index = getCurrentOperationPrior(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            result = oneOperation(left, operation, right);
            operands.add(index, result.toString());
        }

        Logs.saveLog(expression+"="+operands.get(0));

        return Var.createVar(operands.get(0));
    }

    static Var oneOperation (String leftStr, String operation, String rightStr) throws CalcException {
        Var right = Var.createVar(rightStr);
        if(operation.equals("=")){
            Logs.saveLog(leftStr + operation + rightStr);
            return Var.saveVar(leftStr, right);        }

        Var left = Var.createVar(leftStr);

        if (left == null || right == null) {
            throw new CalcException(ErrMesages.res.get(ErrMesages.expressionUnknown));
        }
        Var result;

        switch (operation){
            case ("+"):
                result = left.add(right);
                break;
            case ("-"):
                result = left.sub(right);
                break;
            case ("*"):
                result = left.mul(right);
                break;
            case ("/"):
                result = left.div(right);
                break;
            default:
                throw new IllegalStateException(ErrMesages.res.get(ErrMesages.expressionUnexpected)+ operation);
            }
            return result;
    }

    private int getCurrentOperationPrior(List<String> operations) {
        int prior = -1;
        int index = -1;
        for (int i = 0; i < operations.size(); i++) {
            if(mapPrior.get(operations.get(i)) > prior){
               index = i;
               prior = mapPrior.get(operations.get(i));
            }
        }
        return index;
    }
}
