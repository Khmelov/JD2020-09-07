package by.it.shkatula.jd01_07;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value.clone();
    }

    Matrix(String strMatrix) {
        this.value = parseString(strMatrix);
    }

    //   { { 1.0, 2.0 }, { 3.0, 4.0 } }
    private double[][] parseString(String line) {

        line = line.substring(1, line.length() - 1);
        String[] qwe = line.split("},\\{");
        for (int i = 0; i < qwe.length; i++) {
            qwe[i] = qwe[i].replaceAll("\\{", "");
            qwe[i] = qwe[i].replaceAll("}", "");
        }

        double[][] result = new double[qwe.length][];
        for (int i = 0; i < qwe.length; i++) {
            result[i] = new Vector(qwe[i]).getValue();
        }
        return result;
    }


    @Override
    public String toString() {
        String result = "{";
        String delimeter = "";
        for (double[] element : value) {
            Vector vector = new Vector(element);
            result = result + delimeter;
            result = result + vector.toString();
            delimeter = ",";

        }
        result = result + "}";
        return result;
    }


}


