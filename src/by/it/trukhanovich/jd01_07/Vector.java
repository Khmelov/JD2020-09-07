package by.it.trukhanovich.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

  private double [] value;

  public Vector(double[] value) {
   this.value = value;
  }

 public Vector (Vector vector) {
  this.value = vector.value;
 }
 public Vector (String strVector) {
        StringBuilder sb= new StringBuilder(strVector);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
     strVector=sb.toString();
     String []arrayString=strVector.split(",");

  this.value= new double[arrayString.length];
    for (int i = 0; i < arrayString.length; i++) {
  value[i]=Double.parseDouble(arrayString[i]);
  }
 }

 @Override
 public String toString() {
   StringBuilder sb= new StringBuilder("{");
   String delimiter= "";
  for (double v : value) {
   sb.append(delimiter).append(v);
   delimiter=", ";
   }
  sb.append("}");
  return sb.toString();
 }
}
