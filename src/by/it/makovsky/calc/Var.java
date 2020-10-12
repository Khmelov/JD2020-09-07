package by.it.makovsky.calc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class Var implements Operation, Patterns {

    private static Map<String,Var> vars=new HashMap <>();
    private static Set<Map.Entry<String, Var>> entries = vars.entrySet();

    static Var saveVar(String name,Var var){
        vars.put(name, var);
        return var;
    }
    static void printVar(){
        Iterator<Map.Entry<String, Var>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Var> me=iterator.next();
            String k= me.getKey();
            Var v=me.getValue();
        }
    }

    static Var createVar(String operand) throws CalcException{
        operand=operand.trim().replace("\\s+","");
        if (operand.matches(SCALAR)){
            return new Scalar(operand);
        }
        if (operand.matches(VECTOR)){
            return new Vector(operand);
        }
        if (operand.matches(MATRIX)){
            return new Matrix(operand);
        }
        if (vars.containsKey(operand)){
            return vars.get(operand);
        }

        throw new CalcException("Невозможно создать "+operand);
    }

    protected abstract int getSize();
    @Override
    public String toString() {
        return "Это абстрактный класс Var";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Опреация сложения "+ this + "+"+other+" невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Опреация вычитания "+ this + "-"+other+" невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Опреация умножения "+ this + "*"+other+" невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Опреация деления "+ this + "/"+other+" невозможна");
    }

}
