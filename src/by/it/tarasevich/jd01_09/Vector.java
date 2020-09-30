package by.it.tarasevich.jd01_09;

import java.util.Arrays;

class Vector extends Var {

    final private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String str) {
      String[] string = str.replace('{',' ')
                            .replace('}',' ')
                            .trim()
                            .split(",\\s*");
      double[] array = new double[string.length];
        for (int i = 0; i <array.length ; i++) {
            array[i] = Double.parseDouble(string[i]);
        }
        this.value = array;
    }



    @Override
    public Var add(Var other) {

        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length ; i++) {
                res[i] += ((Vector)other).value[i];
            }
            return new Vector(res);
        }

        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length ; i++) {
                res[i] -= ((Vector)other).value[i];
            }
            return new Vector(res);
        }

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length ; i++) {
                res[i] *= ((Vector)other).value[i];
            }
            return new Vector(res);
        }

        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length ; i++) {
                res[i] /= ((Vector)other).value[i];
            }
            return new Vector(res);
        }

        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        String space = "";
        for (double v : value) {
            stringBuilder.append(space).append(v);
            space = ", ";

        }
        stringBuilder.append("}");


        return stringBuilder.toString();
    }
}
