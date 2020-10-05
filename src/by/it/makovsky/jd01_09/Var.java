package by.it.makovsky.jd01_09;

abstract class Var implements Operation, Patterns {

    static Var createVar(String operand) {
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
        return null;
    }

    @Override
    public String toString() {
        return "Это абстрактный класс Var";
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

}
