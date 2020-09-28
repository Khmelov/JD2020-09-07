package by.it.mialeshka.jd01_07;

class Scalar extends Var{
    double var;
    @Override

    public String toString() {
        return Double.toString(var);
    }

    public Scalar(double var) {
        this.var = var;
    }
       public Scalar(String str) {
        this.var = Double.parseDouble(str);
    }

    public Scalar(Scalar scalar) {
        this.var = scalar.var;
    }




}
