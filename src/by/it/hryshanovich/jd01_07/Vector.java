package by.it.hryshanovich.jd01_07;

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
}
