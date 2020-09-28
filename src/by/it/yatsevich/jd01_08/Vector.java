package by.it.yatsevich.jd01_08;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    @Override
    public Var add(Var other) {
        if (other instanceof Vector) {
            double[] sum = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                sum[i]=this.value[i]+((Vector)other).value[i];
            }
            return new Vector(sum);
        }else return other.add(this);
    }


    @Override
    public Var sub(Var other) {
        if (other instanceof Vector) {
            double[] sub = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                sub[i]=this.value[i]-((Vector)other).value[i];
            }
            return new Vector(sub);
        }else return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector) {
            double mul =0;
            for (int i = 0; i < value.length; i++) {
                mul = (this.value[i] * ((Vector) other).value[i])+mul;
            }return new Scalar(mul);
        }else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Vector) {
            System.out.println("Операция невозможна");
        }return super.div(other);
    }

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
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
