package by.it._akhmelev_.jd01_08;

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
}
