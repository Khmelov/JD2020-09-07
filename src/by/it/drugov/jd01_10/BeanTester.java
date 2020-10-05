package by.it.drugov.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("by.it.drugov.jd01_10.Bean");
        Bean beanClass = (Bean) cls.newInstance();


        
    }
}
