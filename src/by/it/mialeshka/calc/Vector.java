package by.it.mialeshka.calc;

import java.util.Arrays;
import java.util.regex.Pattern;

class Vector extends Var {
    double[] var;

    public Vector(double[] var) {
        this.var = var;
    }

    public Vector(String str) {
        StringBuilder strb = new StringBuilder(str);
        strb.deleteCharAt(0);
        strb.deleteCharAt(strb.length()-1);
        Pattern pattern = Pattern.compile(",[ ]*");
        String[] arrStr = pattern.split(strb);
        this.var = new double[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            this.var[i] = Double.parseDouble(arrStr[i]);
        }
    }

    public Vector(Vector vector) {
        this.var = vector.var;
    }

    public String toString(){
        StringBuilder strb = new StringBuilder("{");
        String delimeter = "";
        for (double element: var) {
            strb.append(delimeter).append(element);
            delimeter = ", ";
        }

        strb.append("}");

        return  strb.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(var, var.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getVar();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res = Arrays.copyOf(var, var.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).var[i];
            }
            return new Vector(res);
        }
        else
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(var, var.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getVar();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double[] res = Arrays.copyOf(var, var.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).var[i];
            }
            return new Vector(res);
        }
        else
            return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(var, var.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getVar();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double res = 0.0;
            for (int i = 0; i < this.var.length; i++) {
                res = res + this.var[i]*((Vector) other).var[i];
            }
            return new Scalar(res);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(var, var.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getVar();
            }
            return new Vector(res);
        }
        else return super.div(other);
    }

    public double[] getVar() {
        return var;
    }
}
