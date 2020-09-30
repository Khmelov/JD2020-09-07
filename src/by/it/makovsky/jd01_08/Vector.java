package by.it.makovsky.jd01_08;

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

    @Override
    public Var add(Var other) {
        if(other instanceof Vector){
            double [] arr= new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                arr[i]=this.value[i]+((Vector)other).value[i];
            }
            return new Vector(arr);
        } else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Vector){
            double [] arr= new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                arr[i]=this.value[i]-((Vector)other).value[i];
            }
            return new Vector(arr);
        } else
            return other.add(this);
    }

    @Override
    public Var mul(Var other) {
        return null;
    }

    @Override
    public Var div(Var other) {
        return null;
    }
}
