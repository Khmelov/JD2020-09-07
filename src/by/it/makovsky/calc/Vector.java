package by.it.makovsky.calc;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this(vector.value);
    }

    public Vector(String str) {
        String[] strings = str
                .replace('{', ' ')
                .replace('}', ' ')
                .trim()
                .split(",\\s*");
        double[] array=new double[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i]=Double.parseDouble(strings[i]);
        }
        this.value=array;
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter="";
        for (double v : value) {
            out.append(delimiter).append(v);
            delimiter=", ";
        }
        out.append("}");
        return out.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Vector) other).value[i];
            }
            return new Vector(result);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Scalar) other).getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Vector) other).value[i];
            }
            return new Vector(result);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double res = 0.0;
            for (int i = 0; i < this.value.length; i++) {
                res = res + this.value[i]*((Vector) other).value[i];
            }
            return new Scalar(res);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else return super.div(other);
    }
}
