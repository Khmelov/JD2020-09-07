package by.it.mialeshka.calc;

public class VarCreator {
    static Var createVar(String strVar) throws CalcException{
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        }
        else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        }
        else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        }
        else if(Var.getVars(strVar) != null){
            return Var.getVars(strVar);
        }
        else {
            throw new CalcException(String.format(ErrMesages.res.get(ErrMesages.varUnknown), strVar));
        }
    }
}
