package by.it.tarasevich.jd01_09;

abstract class Var implements Operations {
    @Override
    public Var add(Var other) {
        System.out.printf("Операция %s + %s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция %s - %s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция %s * %s невозможна\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция %s / %s невозможна\n", this, other);
        return null;
    }

    @Override
    public String toString() {

        return "Это класс Var";


    }

    static Var creadVar(String strVar) {

        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else {
            System.out.println("Неизвестная переменная " + strVar);
            return null;
        }
    }
}
