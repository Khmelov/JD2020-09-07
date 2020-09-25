package by.it.adryneuski.jd01_04;

public class Helper {

     static double findMin(double[] arr)
        {

            double min = arr[0];

            for (int i = 1; i < arr.length; i++)

                if (arr[i] < min) {
                    min = arr[i];
                }
            return min;
        }
    static double findMax(double[] arr)
    {

        double max = arr[0];

        for (int i = 1; i < arr.length; i++)

            if (arr[i] > max) {
                max = arr[i];
            }
        return max;
    }
    static void sort(double[ ] arr)
      {
          boolean swap;
          int last = arr.length-1;

          do
              {
                swap=false;
                  for (int i = 0; i < last; i++)
                   {
                     if (arr[i]>arr[i+1])
                   {
                     double buff = arr[i];
                     arr[i]=arr[i+1];
                     arr[i+1]=buff;
                     swap=true;
                   }
                  }
                last--;
          }
               while (swap);


      }
    static double[ ] mul(double[ ][ ] x, double[ ] y)
        {
          double[] z = new double[x.length];

          for (int i = 0; i < (x.length) ; i++)

              for (int j = 0; j < (y.length) ; j++)

              {  z[i] = z[i]+x[i][j]*y[j];}
                return  z;
          }
    static double[][] mul(double[][] x, double[][] y)
    {
        double[][] z = new double[x.length][y[0].length];

        for (int i = 0; i < (x.length); i++)

            for (int j = 0; j < (y[0].length); j++)

                for (int k = 0; k < y.length; k++)

                    z[i][j] = z[i][j] + x[i][k] * y[k][j];

        return z;
    }


}



