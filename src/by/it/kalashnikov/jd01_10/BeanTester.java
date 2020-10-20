package by.it.kalashnikov.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> clBean = Bean.class;
        Constructor<Bean> constructor = clBean.getDeclaredConstructor();
        Bean b = constructor.newInstance();
        double res;
        for (Method method : clBean.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Param.class)) {
                Param declaredAnnotations = method.getAnnotation(Param.class);
                res = (double) method.invoke(b, declaredAnnotations.a(), declaredAnnotations.b());
                System.out.println(method.getName() + " " + res);
            }
        }
    }
}
