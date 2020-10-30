package by.it.trukhanovich.calc;

class Printer {
    void print (Var var){
        if (var!=null) {
            System.out.println(var);
        }
    }
    String printTolog (Var var) throws CalcException {
        if (var!=null) {
            return var.toString();
        }
        throw new CalcException();
    }

}
