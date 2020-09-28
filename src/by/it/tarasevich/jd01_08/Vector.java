package by.it.tarasevich.jd01_08;

 class Vector extends Var {

   private double[] value;

  public Vector(double[] value) {
   this.value = value;
  }
  public Vector(Vector vector){
   this.value= vector.value;
  }
  public Vector(String strVector){
    StringBuilder stringBuilder= new StringBuilder(strVector);
    stringBuilder.deleteCharAt(0);
    stringBuilder.deleteCharAt(stringBuilder.length()-1);
      strVector= stringBuilder.toString();
      String [] arrayString= strVector.split(",");


           this.value=new double[arrayString.length];
                 for (int i = 0; i < arrayString.length; i++) {
                 value[i]= Double.parseDouble(arrayString[i]);
   }

  }

     @Override
     public Var add(Var other) {

         return super.add(other);
     }

     @Override
     public Var sub(Var other) {
         return super.sub(other);
     }

     @Override
     public Var mul(Var other) {
         return super.mul(other);
     }

     @Override
     public Var div(Var other) {
         return super.div(other);
     }

     @Override
  public String toString() {
   StringBuilder stringBuilder = new StringBuilder("{");
   String space = "";
   for (double v:value) {
    stringBuilder.append(space).append(v);
    space = ", ";

   }
   stringBuilder.append("}");


   return stringBuilder.toString();
  }
 }
