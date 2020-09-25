package by.it.yatsevich.jd01_08;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {

        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    Vector(String strVector) {
     String [] string = strVector

             .replace('{',' ')
             .replace('}',' ')
             .trim()
             .split(",\\s*");
     double[] array = new double[string.length];
        for (int i = 0; i <array.length ; i++) {
            array[i]=Double.parseDouble(string[i]);
        }
        this.value=array;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = " ";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
