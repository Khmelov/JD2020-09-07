package by.it.makovsky.jd01_07;

class Vector extends Var{
    private double [] value;
    Vector (double [] value){
        this.value=value;
    }


    @Override
    public String toString() {
        return (value.toString());
    }
}
