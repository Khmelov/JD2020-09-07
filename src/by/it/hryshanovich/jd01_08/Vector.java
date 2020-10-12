package by.it.hryshanovich.jd01_08;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double [] value) {
        this.value = value;
    }
    Vector (Vector vector){
        this.value=vector.value;
    }
    Vector (String str){
        String [] strings = str
                .replace('{',' ')
                .replace('}',' ')
                .trim()
                .split(",\\s*");
        double[] array=new double[strings.length];
        for (int i =0; i<array.length; i++){
            array [i]= Double.parseDouble(strings [i]);
        }
        this.value=array;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimiter = "";
        for (double element : value){
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append("}");
        return sb.toString ();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+ ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i< res.length; i++){
                res[i] = res[i]+ ((Vector)other).value[i];
            }
            return  new Vector(res);
        }
        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]- ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i< res.length; i++){
                res[i] = res[i]- ((Vector)other).value[i];
            }
            return  new Vector(res);
        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]= res[i]*((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double [] res = Arrays.copyOf(value,value.length);
            double resJ = 0;
            for (int i = 0; i < res.length; i++) {
                resJ=resJ+ res[i]*((Vector)other).value[i];
            }
            return new Scalar(resJ);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]/ ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i< res.length; i++){
                res[i] = res[i]/ ((Vector)other).value[i];
            }
        }
        return super.div(other);
    }
}
