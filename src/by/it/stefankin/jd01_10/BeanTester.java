package by.it.stefankin.jd01_10;


import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class<Bean> cls = Bean.class;
        Method[] methods=cls.getMethods();

        Object o=cls.newInstance();

        for (Method met:methods) {
            if (met.isAnnotationPresent(Param.class)){
                String metName = met.getName();
                System.out.println(metName);
                System.out.println(met.invoke(o,(2),(3)));
              }

        }



    }


}
