package by.it.kulik.jd01_08;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;
    Vector(double[] value) {
        this.value = value;
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
    Vector(Vector vector) {
        this(vector.value);
    }

    @Override
    public Var add(Var other) {
        if  (other instanceof Scalar){
            double[] res= Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Scalar)other).getValue();
            }
            return  new Vector(res);
        }else
            return super.add(this);
    }

    Vector(String str) {
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

        }




