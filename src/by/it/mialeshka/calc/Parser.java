package by.it.mialeshka.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException {
        String[] parts = expression.split(Patterns.OPERATION, 2);

        if (parts.length != 2){
            throw new CalcException("Некорректное выражение");
        }
        Var right = Var.createVar(parts[1]);
        if(expression.contains("=")){
            Logs.saveLog(expression);
            return Var.saveVar(parts[0], right);
        }
        Var left = Var.createVar(parts[0]);
        if (left == null || right == null) {
            throw new CalcException("Некорректное выражение");
        }
        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = patternOperation.matcher(expression);
        if (matcherOperation.find()){
            String strOperation = matcherOperation.group();
            Var result;
            switch (strOperation){
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
                    throw new IllegalStateException("Unexpected value: " + strOperation);
            }
            Logs.saveLog(expression+"="+result);
            return result;
        }
        throw new CalcException("Некорректное выражение");
    }
}
