package by.it.hryntsaliou.calc;

abstract class Var implements Operation {
    @Override
    public Var add(Var other) {
        System.out.printf("Операция %s + %s невозможна\n",this,other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция %s - %s невозможна\n",this,other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция %s * %s невозможна\n",this,other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция %s / %s невозможна\n",this,other);
        return null;
    }

    @Override
    public String toString() {
        return "Var{}";
    }

    static Var createVar(String strVar) {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        }
        if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        }
        if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        }
        else {
            System.err.println("Незвестная переменная "+strVar);
            return null;
        }
    }
}
