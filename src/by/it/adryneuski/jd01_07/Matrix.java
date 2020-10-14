package by.it.adryneuski.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var
{
    private double [][] var;
//  { { 1.0, 2.0 }, { 3.0, 4.0 } }

    public Matrix(double[ ][ ] value)
    {
        this.var = value;
    }

    public Matrix(Matrix matrix)
    {
        this.var = matrix.var;
    }

    public Matrix(String strMatrix)
    {
        StringBuilder st = new StringBuilder(strMatrix);
        st.deleteCharAt(0);
        st.deleteCharAt(st.length()-1);

        int row = getRow(st);
        int cols = getColls(st);
        double[][] matrix = new double[row][cols];

        this.var = getArray(st, matrix, row);

    }

    private static double[][] getArray(StringBuilder st, double[][] matrix, int row) {
        Pattern patternArray = Pattern.compile("(\\d+\\.+\\d+)|(\\d+)");
        Matcher matcherArray = patternArray.matcher(st);

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


    private static int getRow(StringBuilder st) {
        int row=0;
        Pattern rowPattern = Pattern.compile("}");
        Matcher rowMatcher = rowPattern.matcher(st);
        while (rowMatcher.find()) row++;
        return row;
    }

    private static int getColls(StringBuilder st) {
        int cols = 1;
        Pattern collPattern = Pattern.compile(",");
        Matcher collMatcher = collPattern.matcher(st);
        while (collMatcher.find()) cols++;
        return cols;
    }

    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < var.length; i++) {
            strBuild.append("{");
            for (int j = 0; j < var[i].length; j++) {
                strBuild.append(delimiter);
                strBuild.append(var[i][j]);
                delimiter = ", ";
                if (j == var[i].length - 1) delimiter = "";
            }
            if (i < var.length-1) strBuild.append("}, ");
            else strBuild.append("}");
            delimiter = "";
        }
        strBuild.append("}");
        return strBuild.toString();
    }
}