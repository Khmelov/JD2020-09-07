package by.it.mialeshka.jd01_09;

abstract class Var implements Operation {

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
        else {
            System.err.println("Неизвестная переменная " + strVar);
            return null;
        }
    }
}
