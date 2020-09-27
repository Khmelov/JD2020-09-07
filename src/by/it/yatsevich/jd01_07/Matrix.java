package by.it.yatsevich.jd01_07;

import java.lang.reflect.Array;
import java.util.Arrays;

class Matrix {
    private double [][] value;

    Matrix(double[ ][ ] value){
        this.value= Arrays.copyOf(value,value.length);
    }

    Matrix(Matrix matrix){
        this.value=Arrays.copyOf(matrix.value, matrix.value.length);
    }

    Matrix(String strMatrix){
        String[] string = strMatrix

                .replace('{', ' ')
                .replace('}', ' ')
                .trim()
                .split(",\\s*");
        double[][] array;
        for (int i = 0; i < string.length/2; i++) {
           // array[i] = Double.parseDouble(string[i]);
        }
        //this.value = array;


    }
    @Override
    public String toString() {
        return "Matrix{}";
    }
}
