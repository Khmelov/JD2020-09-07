package by.it.shkatula.calculator;

import java.util.HashMap;
import java.util.Map;

public class VarCreator {
    private static Map<String, Var> vars = new HashMap<>();
     Var createVar(String operand) throws CalcException{

        operand = operand.trim().replace("\\s+","");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);

        else if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        }

        else if (operand.matches(Patterns.MATRIX)){
            return new Matrix(operand);}
        else if (vars.containsKey(operand)){
            return vars.get(operand);
        }
        else throw new CalcException("Невозможно создать " + operand);

    }

     Var saveVar(String name, Var var) {

        vars.put(name, var);
        return var;
    }
}
