package by.it.yatsevich.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) {
        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length!=2) {
            //TODO-generate exception
            return null;
        }
        Var left=Var.creatVar(parts[0]);
        Var right=Var.creatVar(parts[1]);
        if (left==null || right==null){
            //TODO-generate exception
            return null;
        }
        Pattern patternOperaton = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperaton = patternOperaton.matcher(expression);
        if (matcherOperaton.find()){
            String operaton = matcherOperaton.group();
            switch (operaton){
                case "+":return left.add(right);
                case "-":return left.sub(right);
                case "*":return left.mul(right);
                case "/":return left.div(right);
            }
        }
        //TODO-generate exception
        return null;
    }
}
