package by.it._akhmelev_.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression){
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length!=2){
            //TODO generate exception
            return null;
        }
        Var left=Var.createVar(parts[0]);
        Var right=Var.createVar(parts[1]);
        if (left==null ||  right==null){
            return null;
        }
        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = patternOperation.matcher(expression);
        if (matcherOperation.find()){
            String operation = matcherOperation.group();
            switch (operation ){
                case "+": return left.add(right);
                case "-": return left.sub(right);
                case "*": return left.mul(right);
                case "/": return left.div(right);
            }
        }
        return null;
    }
}
