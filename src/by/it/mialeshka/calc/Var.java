package by.it.mialeshka.calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {
    private static final Map<String, Var> vars = new HashMap<>();

    public static Var getVars(String key) {
        if (vars.containsKey(key))
            return vars.get(key);
        return null;
    }

    private static String dir(){
        return System.getProperty("user.dir") + File.separator + "src" + File.separator
                + Var.class.getName().replace(Var.class.getSimpleName(), "").replace(".", File.separator);
    }

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
        Map<String, Var> sortVars = new TreeMap<>();
        for (String key: vars.keySet()
             ) {
            sortVars.put(key, vars.get(key));
        }

        for (String key : sortVars.keySet()){
            System.out.println(key+"="+sortVars.get(key));
        }
    }



    public String toString() {
        return ErrMesages.res.get(ErrMesages.var);
    }

    @Override
    public Var add(Var other)  throws CalcException{
        throw new CalcException(String.format(ErrMesages.res.get(ErrMesages.varAdd), this, other));
    }

    @Override
    public Var sub(Var other)  throws CalcException{
        throw  new CalcException(String.format(ErrMesages.res.get(ErrMesages.varSub), this, other));
    }

    @Override
    public Var mul(Var other)  throws CalcException{
        throw new CalcException(String.format(ErrMesages.res.get(ErrMesages.varMul), this, other));
    }

    @Override
    public Var div(Var other)  throws CalcException{
        throw new CalcException(String.format(ErrMesages.res.get(ErrMesages.varDiv), this, other));
    }
    }
