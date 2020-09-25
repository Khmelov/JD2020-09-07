package by.it.adryneuski.jd01_07;

import java.util.Arrays;

class Vector extends Var
   {
       private double[] value;


       public Vector(double[] value)
       {
           this.value = value;
       }

       public Vector(Vector vector)
       {
           this.value = vector.value;
       }

       public Vector(String strVector)
       {
           double[] value1 = Arrays.stream(strVector.split(" ")).mapToDouble(Double::parseDouble).toArray();

           this.value = value1;
       }


       @Override
       public String toString()
        {
           StringBuilder sb = new StringBuilder("{");
           String delimiter = "";

            for (double element:value)

            {
              sb.append(delimiter).append(element);
              delimiter = ", ";
            }
            sb.append("}");
            return sb.toString();

        }
   }

