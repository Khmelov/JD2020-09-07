package by.it.mialeshka.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {
    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var){
        vars.put(name, var);
        return var;
    }

    static void printMap(){
        for (String key : vars.keySet()){
            System.out.println(key+"="+vars.get(key));
        }
    }

    static void printSortMap(){
        Map<String, Var> sortVars = new TreeMap();
        for (String key: vars.keySet()
             ) {
            sortVars.put(key, vars.get(key));
        }

        for (String key : sortVars.keySet()){
            System.out.println(key+"="+sortVars.get(key));
        }
    }



    public String toString() {
        return "Это класс Var";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Опреация сложения "+ this + "+"+other+" невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Опреация вычитания "+ this + "-"+other+" невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Опреация умножения "+ this + "*"+other+" невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Опреация деления "+ this + "/"+other+" невозможна");
        return null;
    }

    static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        }
        else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        }
        else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        }
        else if(vars.containsKey(strVar)){
            return vars.get(strVar);
        }
        else {
            System.err.println("Неизвестная переменная " + strVar);
            return null;
        }
    }
}
