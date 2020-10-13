package by.it.yatsevich.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[i].length; j++) {
                this.value[i][j] = value[i][j];
            }
        }
    }

    Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[i].length; j++) {
                this.value[i][j] = matrix.value[i][j];
            }
        }
    }

    Matrix(String strMatrix) {
        StringBuilder sb = new StringBuilder(strMatrix);
        int row = getRow(sb);
        int cols = (getColls(sb) + 1) / row;
        double[][] matrix = new double[row][cols];

        this.value = getArray(sb, matrix, row);
    }

    private static double[][] getArray(StringBuilder sb, double[][] matrix, int row) {
        Pattern patternArray = Pattern.compile("(\\d+\\.+\\d+)|(\\d+)");
        Matcher matcherArray = patternArray.matcher(sb);
        double[] temp = new double[matrix[0].length * row];
        int k = 0;
        while (matcherArray.find() && k < temp.length) {
            temp[k] = Double.parseDouble(matcherArray.group());
            k++;
        }
        k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = temp[k];
                k++;
            }
        }
        return matrix;
    }

    private static int getColls(StringBuilder sb) {
        int colsFirst = 0;
        Pattern collPattern = Pattern.compile("(\\d+\\.+\\d+)|(\\d+)");
        Matcher collMatcher = collPattern.matcher(sb);
        while (collMatcher.find()) colsFirst++;
        return colsFirst;
    }

    private static int getRow(StringBuilder sb) {
        int row = -1;
        Pattern rowPattern = Pattern.compile("}");
        Matcher rowMatcher = rowPattern.matcher(sb);
        while (rowMatcher.find()) row++;
        return row;
    }


    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            strBuild.append("{");
            for (int j = 0; j < value[i].length; j++) {
                strBuild.append(delimiter);
                strBuild.append(value[i][j]);
                delimiter = ", ";
                if (j == value[i].length - 1) delimiter = "";
            }
            if (i < value.length - 1) strBuild.append("}, ");
            else strBuild.append("}");
            delimiter = "";
        }
        strBuild.append("}");
        return strBuild.toString();
    }
}
