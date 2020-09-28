package by.it._akhmelev_.jd01_09;

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
        double[] array = new double[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        this.value = array;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double v : value) {
            out.append(delimiter).append(v);
            delimiter = ", ";
        }
        out.append("}");
        return out.toString();
    }
}
