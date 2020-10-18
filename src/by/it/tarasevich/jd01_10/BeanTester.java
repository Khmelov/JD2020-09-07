package by.it.tarasevich.jd01_10;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Constructor<Bean> beanClassConstructor = beanClass.getConstructor();
        Bean bean = beanClassConstructor.newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param param = method.getAnnotation(Param.class);
                double v = (double) method.invoke(bean, param.a(), param.b());
                System.out.println(method.getName() + " " + v);
            }

        }
    }
}
