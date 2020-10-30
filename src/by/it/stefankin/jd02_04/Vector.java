package by.it.stefankin.jd02_04;

import java.util.Arrays;

public class Vector  extends Var {

    private double[] value;

    double[] getValue() {
        return value;
    }



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
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] arr = Arrays.copyOf(value,value.length);
            for (int i=0;i<arr.length;i++) {
                arr[i]=arr[i]+((Scalar) other).getVal();
            }
            return new Vector(arr);
        }   else if (other instanceof Vector) {
            double[] arr = Arrays.copyOf(value, value.length);

            if (((Vector)other).value.length != arr.length)
                throw new CalcException("Операция сложения невозможна");

            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] + ((Vector) other).value[i];
            }
            return new Vector(arr);
            }

             return super.add(other);

    }

    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Vector) {
            double[] arr = Arrays.copyOf(value, value.length);
            if (((Vector)other).value.length != arr.length)
                throw new CalcException("Операция вычитания невозможна");
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
             return super.sub(other);


    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Vector) {
            double rez=0;
            double[] arr = Arrays.copyOf(value, value.length);
            if (((Vector)other).value.length != arr.length)
                throw new CalcException("Операция умножения невозможна");
            for (int i = 0; i < value.length; i++) {
            arr[i] = value[i] *((Vector) other).value[i];
            }
             return  new Vector(arr);
        }
            else if (other instanceof Scalar) {
            double[] arr = Arrays.copyOf(value, value.length);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i]* ((Scalar) other).getVal();
            }
            return new Vector(arr);
        }

        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] arr = Arrays.copyOf(value, value.length);
            if (((Scalar) other).val == 0)
                throw new CalcException("Операция деления на ноль!");

            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] / ((Scalar) other).getVal();
            }
            return new Vector(arr);
        } else

            if (other instanceof Vector)
            {return super.div(other);}

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
