package by.it.tarasevich.jd01_10;

import java.lang.reflect.Constructor;

public class BeanTester {
    public static void main(String[] args) throws Exception{
        Class <Bean> beanClass = Bean.class;
        Constructor<Bean> constructor = beanClass.getConstructor();
        Bean bean = constructor.newInstance();

        System.out.println(bean);

    }
}
