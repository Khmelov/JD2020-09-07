package by.it.mialeshka.jd01_07;

import java.util.regex.Pattern;

class Vector extends Var{
    double[] var;

    public Vector(double[] var) {
        this.var = var;
    }

    public Vector(String str) {
        StringBuilder strb = new StringBuilder(str);
        strb.deleteCharAt(0);
        strb.deleteCharAt(strb.length()-1);
        Pattern pattern = Pattern.compile(",");
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
}
