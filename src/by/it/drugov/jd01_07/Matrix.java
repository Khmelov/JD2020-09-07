package by.it.drugov.jd01_07;

import java.util.Arrays;

class Matrix extends Var {
    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            line.append("{");
            for (int j = 0; j < value[0].length; j++) {
                line.append(value[i][j]);
                if (j == value[0].length - 1) {
                    line.append("}");
                    continue;
                }
                line.append(",");
            }
            if (i == value.length - 1) {
                continue;
            }
            line.append(",");
        }
        line.append("}");
        return line.toString();
    }

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
    this.value = matrix.value;
    }

    Matrix(String strMatrix) {

    }
}
