package by.it.tarasevich.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var calc(String expression){

        String[] parts = expression.split(Patterns.OPERATION, 2);
        if (parts.length != 2){

            return null;

        }
        Var left = Var.creadVar(parts[0]);
        Var rigth = Var.creadVar(parts[1]);
        if (left== null || rigth == null){
            return null;
        }
        Pattern patternsOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = patternsOperation.matcher(expression);
        if (matcherOperation.find()){
            String operation = matcherOperation.group();
            switch (operation){

                case "+": left.add(rigth);
                case "-": left.sub(rigth);
                case "*": left.mul(rigth);
                case "/": left.div(rigth);

            }

        }
        return null;
    }
}
