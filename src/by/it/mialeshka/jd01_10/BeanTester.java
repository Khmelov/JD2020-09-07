package by.it.mialeshka.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class BeanTester {
    private Annotation declaredAnnotation;
    private Annotation declaredAnnotation1;

    public static void main(String[] args) throws Exception{
        double result;
        Class cl = Class.forName("by.it.mialeshka.jd01_10.Bean");
        Method[] declaredMethod = cl.getDeclaredMethods();
        for (Method method : declaredMethod) {
            if(method.isAnnotationPresent(Param.class)){
                Param declaredAnnotations = method.getAnnotation(Param.class);
                if(Modifier.isStatic(method.getModifiers())){
                    result = (double)method.invoke(null, declaredAnnotations.a(), declaredAnnotations.b());
                }
                else {

                    result = (double)method.invoke(cl.newInstance(), declaredAnnotations.a(), declaredAnnotations.b());
                }
                System.out.println(method.getName()+ " " + result);
            }
        }

    }
}
