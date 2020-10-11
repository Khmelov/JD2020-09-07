package by.it.adryneuski.jd01_10;

public class Bean {

    @Param(a=3,b=4)
        static double sum(int a, int b)
     {
        return a+b;
     }

    @Param(a=3,b=4)
        double max(int a, int b)
                      {
                    if(a>b) {return a;}
                       else return b;

                      }

    @Param(a=3,b=4)
        double min(int a, int b)
    {
        if(a>b) {return b;}
        else return a;
    }

        static double avg(int a, int b)
                  {
                     return (a+b)/2.0;
                  }


}
