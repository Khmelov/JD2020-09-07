package by.it.trukhanovich.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {
     private double [][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }
    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        StringBuilder sb= new StringBuilder(strMatrix);
        Pattern p1= Pattern.compile("\\}\\, \\{");
        Matcher m1= p1.matcher(sb);
        int i=1;
        while (m1.find()){i++;}
        Pattern p2= Pattern.compile("\\d,\\d");
        Matcher m2= p2.matcher(sb);
        int j=1;
        while (m2.find()){j++;}
        double[][] matrix=new double[i][((j)/i)+1];
        this.value= matrix;
        Pattern p3= Pattern.compile("(\\d+\\.\\d+)|(\\d+)");
        Matcher m3= p3.matcher(sb);
        i=0;
        j=0;
        while (m3.find()) {
            matrix[i][j]=Double.parseDouble(m3.group());
            if (j<matrix[i].length-1) j++;
            else j=0;
            if (j==0) i++;}
    }



    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder("{");
        String delimiter= "";
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiter);
                sb.append(value[i][j]);
                delimiter=", ";
                if ((i==value.length-1)&&j==value[i].length-1) delimiter="";
            }
            if (i<value.length-1) sb.append("}, ");
            else sb.append("}");
            delimiter="";
        }
        sb.append("}");
        return sb.toString();

    }
}
