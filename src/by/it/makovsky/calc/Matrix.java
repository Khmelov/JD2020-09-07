package by.it.makovsky.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        double[][] tempArr = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                tempArr[i][j] = value[i][j];
            }
        }
        this.value = tempArr;
    }

    Matrix(Matrix matrix) {
        double[][] tempArr = new double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < tempArr.length; i++) {
            for (int j = 0; j < tempArr.length; j++) {
                tempArr[i][j] = matrix.value[i][j];
            }
        }
        this.value = tempArr;

    }

    public Matrix(String strMatrix) {
        StringBuilder sb= new StringBuilder(strMatrix);
        int row = findRow(sb);
        int collum = findCollum(sb);
        double[][] matrix=new double[row][(((collum)/row)+1)];
        this.value= matrix;
        getArrayStringToDouble(sb,matrix);
    }



    private void getArrayStringToDouble(StringBuilder sb, double[][] matrix)
    {
        Pattern p3= Pattern.compile("(\\d+\\.\\d+)|(\\d+)");
        Matcher m3= p3.matcher(sb);
        int row=0;
        int collum=0;
        while (m3.find()) {
            matrix[row][collum]=Double.parseDouble(m3.group());
            if (collum<matrix[row].length-1) collum++;
            else collum=0;
            if (collum==0) row++;}
    }
    private int findCollum(StringBuilder sb) {
        Pattern p2= Pattern.compile("\\d,");
        Matcher m2= p2.matcher(sb);
        int j=0;
        while (m2.find()){j++;}
        return j;
    }

    private int findRow(StringBuilder sb) {
        Pattern p1= Pattern.compile("(\\}\\, \\{)|(\\}\\,\\{)");
        Matcher m1= p1.matcher(sb);
        int i=1;
        while (m1.find()){i++;}
        return i;
    }

    @Override
    protected int getSize() {
        return value[0].length;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("{");
        for (int i = 0; i < this.value.length; i++) {
            line.append("{");
            for (int j = 0; j < this.value[0].length; j++) {
                line.append(this.value[i][j]);
                if (j == this.value[0].length - 1) {
                    line.append("}");
                    continue;
                }
                line.append(", ");
            }
            if (i == this.value.length - 1) {
                continue;
            }
            line.append(", ");
        }
        line.append("}");
        return line.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Matrix) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] += ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        } else if (other instanceof Scalar) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else {
            return super.add(other);
        }
    }


    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Matrix) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] -= ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        } else if (other instanceof Scalar) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] -= ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Matrix) {
            double[][] result = new double[value.length][value[0].length];
            double[][] temp = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    for (int k = 0; k < result.length; k++) {
                        temp[i][j] += result[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(temp);
        } else if (other instanceof Vector) {
            double[][] result = new double[value.length][value[0].length];
            double[] temp = new double[value.length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    temp[i] += result[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(temp);
        } else if (other instanceof Scalar) {
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result.length; j++) {
                    result[i][j] *= ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        } else {
            return super.mul(other);
        }
    }
    public double[][] getValue() {
        return value;
    }
}
