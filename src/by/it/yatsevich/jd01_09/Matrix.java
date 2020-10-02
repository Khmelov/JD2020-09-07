package by.it.yatsevich.jd01_09;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {

    public double[][] getValue() {
        return value;
    }

    private double[][] value;

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
    }

    Matrix(String strMatrix) {
        StringBuilder sb = new StringBuilder(strMatrix);
        int row = getRow(sb);
        int cols = (getColls(sb)+1)/ row;
        double[][] matrix = new double[row][cols];
        this.value=matrix;
                getArray(sb, matrix,row);
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
    public Var add(Var other) {
        if (other instanceof Matrix){
            double[][] result=new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result [i][j]= value[i][j] + ((Matrix) other).getValue()[i][j];
                }
            }
            return new Matrix(result);
        }else
        if (other instanceof Vector){
            return super.add(other);
        }
        else if (other instanceof Scalar) {
            double[][] result=new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] =value[i][j]+ ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        else return super.add(other);
    }
    @Override
    public Var sub(Var other) {
        if (other instanceof Matrix){
            double[][] result=new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result [i][j]=value[i][j]-((Matrix) other).getValue()[i][j];
                }
            }
            return new Matrix(result);
        }
        else if (other instanceof Vector){
            return super.sub(other);
        }
        else if (other instanceof Scalar) {
            double[][] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            double result[] = new double[value.length];
            double[] vetc = Arrays.copyOf(((Vector) other).getValue(), ((Vector) other).getValue().length);
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    result[i] = result[i] + value[i][j] * vetc[j];
                }
            }
            return new Vector(result);
        }
        else  if (other instanceof Matrix){
            double[][] matrixLeft = this.value;
            double[][] matrixRight = ((Matrix) other).getValue();
            double[][] result = new double[matrixLeft.length][matrixRight[0].length];
            for (int i = 0; i < matrixLeft.length; i++) {
                for (int j = 0; j < matrixRight[0].length; j++) {
                    for (int k = 0; k < matrixRight.length; k++) {
                        result[i][j] = result[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {

        return super.div(other);
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
            if (i < value.length-1) strBuild.append("}, ");
            else strBuild.append("}");
            delimiter = "";
        }
        strBuild.append("}");
        return strBuild.toString();
    }
}
