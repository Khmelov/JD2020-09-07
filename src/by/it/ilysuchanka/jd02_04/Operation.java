package by.it.stefankin.jd02_04;

public interface Operation {
       Var add(Var other) throws CalcException;
       Var sub(Var other) throws CalcException;
       Var mul(Var other) throws CalcException;
       Var div(Var other) throws CalcException;


}
