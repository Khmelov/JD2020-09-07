package by.it.tarasevich.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
        private  double [][] value;

        public Matrix(double[][] value){
            this.value = value;
        }
        public Matrix(Matrix matrix){
            this.value = matrix.value;
        }

    public Matrix(String strMatrix){
            StringBuilder stringBuilder = new StringBuilder(strMatrix);
            int row = findRow(stringBuilder);
            int collum = findCollum(stringBuilder);
            double[][] matrix = new double[row][(((collum)/row)+1)];
            this.value = matrix;
            getArrayStrDoubl(stringBuilder,matrix);
    }
    private void getArrayStrDoubl(StringBuilder stringBuilder, double[][] matrix){
            Pattern pattern = Pattern.compile("(\\d+\\.\\+)|(\\d+)");
            Matcher matcher = pattern.matcher(stringBuilder);
            int row = 0;
            int collum = 0;
            while (matcher.find()){
                matrix[row][collum]= Double.parseDouble(matcher.group());
                if (collum < matrix[row].length-1)
                collum++;
                else collum = 0;
                    if (collum==0)
                        row++;
            }

    }


    private  int findCollum(StringBuilder stringBuilder){
        Pattern p2 = Pattern.compile("\\d,");
        Matcher m2 = p2.matcher(stringBuilder);
        int j = 0;
        while (m2.find()){j++;}
        return j;
    }
    private int findRow(StringBuilder stringBuilder){
        Pattern p1 = Pattern.compile(" (\\}\\, \\{)|(\\}\\,\\})");
        Matcher m1 = p1.matcher(stringBuilder);
        int i = 0;
        while (m1.find()){i++;}
            return i;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(("{"));
        String delemetr ="";
        for (int i = 0; i <value.length ; i++) {
            stringBuilder.append("{");
            for (int j = 0; j <value[i].length ; j++) {
                stringBuilder.append(delemetr);
                stringBuilder.append(value[i][j]);
                delemetr = ", ";
                if (i== value.length-1 &&
                 j==value[i].length-1)
                delemetr = "";


            }
            if (i<value.length-1) stringBuilder.append("}, ");
                else stringBuilder.append("}");
                delemetr="";
        }
            stringBuilder.append("}");
            return stringBuilder.toString();
    }
}
