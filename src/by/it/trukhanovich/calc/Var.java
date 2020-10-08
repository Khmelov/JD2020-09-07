package by.it.trukhanovich.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String,Var> vars =new HashMap<>();

    static Var saveVar (String name, Var var){
        vars.put(name, var);
        return var;
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Операция %s + %s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция %s - %s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция %s * %s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция %s / %s невозможна\n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "Это класс Var{}";
    }

    static Var createVar (String strVar){
        if (strVar.matches(Patterns.SKALAR)){
            return new Scalar(strVar);
        }
       else if (strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }
        else if (strVar.matches(Patterns.MATRIX)){
            return new Matrix(strVar);
        }
        else if(vars.containsKey(strVar)){
            return vars.get(strVar);
        }
        else {
            System.err.println("Незвестная переменная "+strVar);
        return null;
        }
    }
}
