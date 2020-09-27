package by.it.kalashnikov.jd01_08;


import java.util.Arrays;

class Vector extends Var {

    private double[] value;



    Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }

    Vector (Vector vector){
        this(vector.value);
    }


    Vector (String strVector){
        String [] strings = strVector
        .replace('{',' ').
        replace('}',' ').
        trim().
        split(",\\s*");
        double [] array = new double[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        this.value=array;
    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double [] sum = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i]= sum[i]+((Scalar)other).getValue();
            }
            return new Vector(sum);
        }
        else if (other instanceof Vector){
            double [] sum = Arrays.copyOf(value,value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i]= sum[i]+((Vector)other).value[i];
            }
            return new Vector(sum);
        }
        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {return super.mul(other);}

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value){
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
