package by.it.stefankin.jd01_07;

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
