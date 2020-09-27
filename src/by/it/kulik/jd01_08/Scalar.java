package by.it.kulik.jd01_08;

class Scalar extends Var {
    private double value;

    Scalar(double value) {
        this.value = value;
    }
    Scalar(String strScalar){
        this.value=Double.parseDouble(strScalar);
    }
    Scalar(Scalar Scalar){
        this.value=Scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}
