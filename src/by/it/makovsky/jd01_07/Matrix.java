package by.it.makovsky.jd01_07;

import java.util.Arrays;

class Matrix extends Var {
    private double [][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }
    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    @Override
    public String toString() {
        return "Matrix stub";
    }
}
