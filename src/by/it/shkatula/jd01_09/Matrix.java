package by.it.shkatula.jd01_09;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value.clone();
    }

    Matrix(String strMatrix) {
        this.value = parseString(strMatrix);
    }

    private double[][] setMatrix(double[][] mat) {
        double[][] resultVector = new double[mat.length][mat.length];
        for (int i = 0; i < resultVector.length; i++) {
            for (int j = 0; j < resultVector.length; j++) {
                resultVector[i][j] = mat[i][j];
            }
        }
        return resultVector;
    }

    //   { { 1.0, 2.0 }, { 3.0, 4.0 } }
    private double[][] parseString(String line) {

        line = line.substring(1, line.length() - 1);
        String[] qwe = line.split("}, ?\\{");
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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] resultMatSca = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultMatSca.length; i++) {
                for (int j = 0; j < resultMatSca[i].length; j++) {
                    resultMatSca[i][j] = value[i][j] + ((Scalar) other).getValue();
                }

            }
            return new Matrix(resultMatSca);
        }
        else if (other instanceof Matrix) {
            double[][] resultMatMat = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultMatMat.length; i++) {
                for (int j = 0; j < resultMatMat[i].length; j++) {
                    resultMatMat[i][j] = resultMatMat[i][j] + ((Matrix)other).value[i][j];
                }

            }
            return new Matrix(resultMatMat);
        } else
            return super.add(other);
    }
    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] resultMatSca = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultMatSca.length; i++) {
                for (int j = 0; j < resultMatSca[i].length; j++) {
                    resultMatSca[i][j] = value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(resultMatSca);
        }
        else if (other instanceof Matrix) {
            double[][] resultMatMat = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultMatMat.length; i++) {
                for (int j = 0; j < resultMatMat[i].length; j++) {
                    resultMatMat[i][j] = value[i][j] - ((Matrix)other).value[i][j];
                }
            }
            return new Matrix(resultMatMat);
        } else
            return super.sub(other);
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
    public String toString() {
        String result = "{";
        String delimeter = "";
        for (double[] element : value) {
            Vector vector = new Vector(element);
            result = result + delimeter;
            result = result + vector.toString();
            delimeter = ", ";

        }
        result = result + "}";
        return result;
    }


}
