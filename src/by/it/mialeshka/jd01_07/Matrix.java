package by.it.mialeshka.jd01_07;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Matrix extends Var {
    double[][] var;

    public Matrix(double[][] var) {
        this.var = var;
    }

    public Matrix(Matrix matrix) {
        this.var = matrix.var;
    }

    public Matrix(String str) {
        StringBuilder strb = new StringBuilder(str);
        strb.delete(0, 2);
        strb.delete(strb.length()-2, strb.length());
        Pattern pattern = Pattern.compile("},\\{");
        String[] arrStr = pattern.split(strb);
        List<String[]> arrStr2 = new ArrayList<String[]>();
        for (int i = 0; i < arrStr.length; i++) {
            Pattern pattern1 = Pattern.compile(",");
            StringBuilder strb1 = new StringBuilder(arrStr[i]);
            arrStr2.add(pattern1.split(strb1));
        }

        this.var = new double[arrStr2.size()][arrStr2.get(0).length];

        for (int i = 0; i < arrStr2.size(); i++) {
            for (int j = 0; j < arrStr2.get(0).length; j++) {
                this.var[i][j] = Double.parseDouble(arrStr2.get(i)[j]);
            }
        }
    }

    public String toString(){
        StringBuilder strb = new StringBuilder("{");

        String delimeterStr = "";
        for (int i = 0; i < var.length; i++) {
            strb.append(delimeterStr).append("{");
            String delimeter = "";
            for (int j = 0; j < var[0].length; j++) {
                strb.append(delimeter).append(var[i][j]);
                delimeter = ", ";
            }
            strb.append("}");
            delimeterStr = ", ";
        }
        strb.append("}");
        return strb.toString();
    }
}
