package by.it._akhmelev_.calculator;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation{

    private static Map<String,Var> vars=new HashMap<>();


    static Var save(String name, Var value) {
        vars.put(name,value);
        return value;
    }

    @Override
    public Var add(Var other)  throws CalcException{
        throw new CalcException(String.format("Операция %s + %s невозможна\n",this,other));
    }

    @Override
    public Var sub(Var other)   throws CalcException{
        throw new CalcException(String.format("Операция %s - %s невозможна\n",this,other));
    }

    @Override
    public Var mul(Var other)   throws CalcException{
        throw new CalcException(String.format("Операция %s * %s невозможна\n",this,other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s / %s невозможна\n",this,other));
    }

    @Override
    public String toString() {
        return "abstract Var ";
    }

    static Var createVar(String strVar) throws CalcException {

        if (strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        }
        else if (strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }
        else if (strVar.matches(Patterns.MATRIX)){
            return new Matrix(strVar);
        }
        else {
            Var var = vars.get(strVar);
            if (var!=null)
                return var;

        }

        throw new CalcException(String.format("Неизвестная переменная "+strVar));
    }
}
