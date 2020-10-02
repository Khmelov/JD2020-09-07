package by.it.mialeshka.jd01_08;

abstract class Var implements Operation{
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
}
