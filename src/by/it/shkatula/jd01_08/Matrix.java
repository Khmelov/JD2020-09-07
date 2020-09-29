package by.it.shkatula.jd01_08;

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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] resultMatSca = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resultMatSca.length; i++) {
                for (int j = 0; j < resultMatSca[i].length; j++) {
                    resultMatSca[i][j] = resultMatSca[i][j] + ((Scalar) other).getValue();
                }

            }
            return new Matrix(resultMatSca);
        } else if (other instanceof Matrix) {
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
