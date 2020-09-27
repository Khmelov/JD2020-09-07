package by.it.hryntsaliou.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        double[][] numbers = new double[value.length][value[0].length];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                numbers[i][j] = value[i][j];
            }
        }
        this.value = numbers;
    }

    Matrix(Matrix matrix) {
        double[][] numbers = new double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[0].length; j++) {
                numbers[i][j] = matrix.value[i][j];
            }
        }
        this.value = numbers;
    }

    Matrix(String strMatrix) {
        Pattern pattern1 = Pattern.compile("[{]");
        Matcher matcher1 = pattern1.matcher(strMatrix);
        int countRows = 0;
        while (matcher1.find()) {
            countRows++;
        }
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(strMatrix);
        while (matcher.find()) {
            strMatrix = matcher.replaceAll("");
        }
        String[] numbers = strMatrix.split(",");
        double[][] nums = new double[countRows - 1][numbers.length / (countRows - 1)];
        int k = 0;
        for (int i = 0; i < countRows - 1; i++) {
            for (int j = 0; j < numbers.length / (countRows - 1); j++) {
                nums[i][j] = Double.parseDouble(numbers[k]);
                k++;
            }
        }
        this.value = nums;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Matrix) {
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] += ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Scalar) {
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] += ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Matrix) {
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] -= ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Scalar) {
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] -= ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Matrix) {
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            double[][] mulRes = new double[value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        mulRes[i][j] += value[i][k]*((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(mulRes);
        }
        else if (other instanceof Scalar) {
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] *= ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else {
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] = value[i][j];
                }
            }
            double[] mulRes = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value.length; j++) {
                    mulRes[i] += res[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(mulRes);
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
