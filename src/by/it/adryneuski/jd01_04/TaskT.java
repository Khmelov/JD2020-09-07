package by.it.adryneuski.jd01_04;


public class TaskT {
    public static void main(String[] args) {

       String names = "Alena Alice albina Anastas Alla arina";
        System.out.println(names);

        names = names.trim();
        String a[] = names.split(" ");


        for (int j = 0; j < a.length-1 ; j++) {
            for (int i = j+1; i < a.length ; i++) {
                if (a[i].compareToIgnoreCase(a[j])<0) {
                    String tmp = a[j];
                    a[j]=a[i];
                    a[i]=tmp;


                }

            }

        }

        for (String element: a)
        {
            if (!element.isEmpty())
            {
                System.out.print(element + " ");
            }

        }


      }
    }
