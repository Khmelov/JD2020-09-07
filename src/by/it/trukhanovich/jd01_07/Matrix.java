package by.it.trukhanovich.jd01_07;

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
        StringBuilder sb= new StringBuilder("{");
        String delimiter= "";
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[i].length; j++) {

                sb.append(delimiter);
                sb.append(value[i][j]);
                delimiter=",";
                if ((i==value.length-1)&&j==value[i].length-1) delimiter="";
            }

            if (i<value.length-1) sb.append("},");
            else sb.append("}");
            delimiter="";
        }
        sb.append("}");
        return sb.toString();

    }
}
