package by.it.stefankin.jd02_04;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.stefankin.jd02_04.Var.*;

public class Parser {

    private  final static Map<String,Integer> priority =new HashMap<String, Integer>(){
        {
            this.put("=",0);
          this.put("+",1);
          this.put("-",1);
         this.put("*",2);
         this.put("/",2);
         this.put("(",-1);
         this.put(")",-1);

        }
    };

    Var calc (String expression) throws CalcException {
       //A=-2+3*-4/-2  A=4
        expression=expression.replace(" ","");
        if(expression.length()==0) {
            throw new CalcException("no expr-n");
        }

        List<String> opernds = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while(matcher.find()){
            operations.add(matcher.group());
        }
      // operands   A -2 3 -4 -2
     // operations  = + * /

        while (operations.size()>0) {
            int index = getIndexCurrentOperation(operations);

            boolean brackets=false;
            if (index!=0&&operations.get(index-1).equals("(")&&operations.get(index+1).equals(")")){
                int numberBracketsInEnd=0;
                for (int i = operations.size() - 1; i >= 0; i--) {
                    if (operations.get(i).equals(")")) numberBracketsInEnd++;
                    else break;
                }
                operations.remove(index+1);
                if (index<operations.size()-numberBracketsInEnd)opernds.remove(index+2);
                brackets=true;
            }
            String removeOperation = operations.remove(index);
            String leftOperand = opernds.remove(index);
            String rightOperand = opernds.remove(index);

            Var result = oneOperation(leftOperand, removeOperation, rightOperand);
            opernds.add(index,result.toString());
            if (brackets) {
                operations.remove(index-1);
                opernds.remove(index-1);
            }
        }
        return Var.createVar(opernds.get(0));
    }




    private Var oneOperation(String strLeft, String operation, String strRight) throws CalcException {
        Var right = createVar(strRight);
        if (operation.equals("=")) {
            Var.save(strLeft, right);
            return right;
        }


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

           throw new CalcException("some s");

        }



    private int getIndexCurrentOperation(List<String> operations) {
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
