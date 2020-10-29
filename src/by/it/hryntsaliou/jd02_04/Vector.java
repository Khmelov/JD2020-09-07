package by.it.hryntsaliou.jd02_04;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    Vector(String strVector) {
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(strVector);
        while (matcher.find()) {
            strVector = matcher.replaceAll(" ");
        }
        double[] vec = new double[strVector.trim().split(",").length];
        for (int i = 0; i < strVector.trim().split(",").length; i++) {
            vec[i] = Double.parseDouble(strVector.trim().split(",")[i]);
        }
        this.value = vec;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            if (this.value.length != ((Vector) other).getSize()) {
                throw new CalcException("Разные размеры векторов!");
            }
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Vector) other).value[i];
            }
            return new Vector(res);
        } else return super.add(other);
    }

    private int getSize() {
        return value.length;
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            if (this.value.length != ((Vector) other).getSize()) {
                throw new CalcException("Разные размеры векторов!");
            }
            for (int i = 0; i < res.length; i++) {
                res[i] -= ((Vector) other).value[i];
            }
            return new Vector(res);
        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] *= ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            if (this.value.length != ((Vector) other).getSize()) {
                throw new CalcException("Разные размеры векторов!");
            }
            double sum = 0;
            for (int i = 0; i < res.length; i++) {
                sum += res[i] * ((Vector) other).value[i];
            }
            return new Scalar(sum);
        } else return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] /= ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            return super.div(other);
        } else return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String separator = "";
        for (double element : value) {
            sb.append(separator).append(element);
            separator = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
