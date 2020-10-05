package by.it.stefankin.jd01_07;

public class Scalar extends Var {

    Double val;

     Scalar (double value){
         val=value;
     }
     Scalar (Scalar scalar){
         this.val=scalar.val;
     }
     Scalar (String strScalar){
         val=Double.parseDouble(strScalar);
     }

     public String toString() {
         return val.toString();

     }

}
