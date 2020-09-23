package by.it.hryntsaliou.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        Pattern pattern1 = Pattern.compile("[{]");
        Matcher matcher1 = pattern1.matcher(strMatrix);
        int count = 0;
        while (matcher1.find()) {
            count++;
        }
        Pattern pattern = Pattern.compile("[{},]+");
        Matcher matcher = pattern.matcher(strMatrix);
        while (matcher.find()) {
            strMatrix = matcher.replaceAll("");
        }
        String[] numbers = strMatrix.split(" ");
        int k = 0;
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < (numbers.length) / (count - 1); j++) {
                this.value[i][j] = Double.parseDouble(numbers[k]);
                k++;
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder matrix = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            matrix.append("{");
            for (int j = 0; j < value[0].length; j++) {
                if (j != value[0].length - 1)
                    matrix.append(value[i][j] + ", ");
                else
                    matrix.append(value[i][j] + "}");
            }
            if (i != value.length - 1) {
                matrix.append(", ");
            }
        }
        matrix.append("}");
        return matrix.toString();
    }
}
