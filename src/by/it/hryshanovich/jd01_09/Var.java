package by.it.hryshanovich.jd01_09;

import by.it._examples_.jd01_07.matrixOk.Matrix;

abstract class Var implements Operation {

    static Var createVar (String operand) throws CalcException{
        operand=operand.trim().replace("\\s+","");
        if (operand.matches(Patterns.SCALAR))
        return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
        return new Vector(operand);
        throw  new CalcException(""+ operand);
    }

    @Override
    public Var add(Var other)  throws CalcException {
       throw new CalcException("Операция сложения "+this+"+"+other+" невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания "+this+"-"+other+" невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения "+this+"*"+other+" невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления "+this+"/"+other+" невозможна");
    }
}
