package by.it.yatsevich.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Constructor<Bean> constructor = beanClass.getDeclaredConstructor();
        Bean bean = constructor.newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
       // System.out.println(Arrays.toString(methods));
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                System.out.println(method.getName());
                Annotation[] annotations = method.getAnnotations();
//                System.out.println(Arrays.toString(annotations));
                for (Annotation annotation : annotations) {
                    Param param = (Param) annotation;
                    System.out.println("a= "+param.a());
                    System.out.println("b= "+param.b());
                    int a = param.a();
                    int b = param.b();
                    System.out.println(method.invoke(bean, a, b));

                }
            }
        }


    }
}
