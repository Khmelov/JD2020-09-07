package by.it.stefankin.jd01_08;

import java.util.Arrays;

public class Vector  extends Var {

    private double[] value;

    public Vector (double[] value) {


       double[] arr =new double[value.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=value[i];
        }
        this.value=arr;
    }

    public Vector (Vector vector){
        this.value=vector.value;

    }
    public Vector (String strVector) {
        String[] stv=strVector
                .replace('{',' ')
                .replace('}',' ')
                .trim()
                .split(",\\s*");
        double[] arr =new double[stv.length];
           for (int i=0; i<stv.length; i++) {
            arr[i] = Double.parseDouble(stv[i]);
        }
           this.value=arr;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] arr = Arrays.copyOf(value,value.length);
            for (int i=0;i<arr.length;i++) {
                arr[i]=arr[i]+((Scalar) other).getVal();
            }
            return new Vector(arr);
        }
        else if (other instanceof Vector) {
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] + ((Vector) other).value[i];
            }
            return new Vector(arr);
        }
        else
            return super.add(other);

    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Vector) {
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] - ((Vector) other).value[i];
            }
            return new Vector(arr);
        }

        else if (other instanceof Scalar) {
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] - ((Scalar) other).getVal();
            }
            return new Vector(arr);
        }

         else
            return super.add(other);

    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector) {
            double rez=0;
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
            arr[i] = value[i] *((Vector) other).value[i];
            }
            for (int j = 0; j < arr.length; j++) {
                rez=rez+arr[j];
            }

            return  new Scalar(rez);
        }
            else if (other instanceof Scalar) {
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i]* ((Scalar) other).getVal();
            }
            return new Vector(arr);
        }

        else
            return super.add(other);
        }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i]/((Scalar) other).getVal();
            }
            return new Vector(arr);
        }

        else
        return super.div(other);
    }

    public String toString() {
        StringBuilder out= new StringBuilder("{");
        String delim ="";
        for (double val:value) {
            out.append(delim).append(val);
            delim=", ";

        }
             out.append("}");
             return  out.toString();
    }



}
