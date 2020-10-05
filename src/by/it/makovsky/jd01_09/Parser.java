package by.it.makovsky.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser implements Patterns {
    Var calc(String expr){
        //2.0 *2.0
        String[] operand=expr.split(OPERATIONS);
        Var first=Var.createVar(operand[0]);
        Var second=Var.createVar(operand[1]);
        if(first==null||second==null){
            return null; //TODO create error
        }
        Pattern p=Pattern.compile(OPERATIONS);
        Matcher m=p.matcher(expr);
        if(m.find()){
            String operation=m.group();
            switch (operation){
                case "+": return first.add(second);
                case "-": return first.sub(second);
                case "*": return first.mul(second);
                case "/": return first.div(second);
            }

        }
        return null;
    }
}
