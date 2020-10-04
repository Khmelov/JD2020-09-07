package by.it.shkatula.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathStructure = Math.class;
        Method[] methods = mathStructure.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC)
 //                   if ((method.getModifiers() & Modifier) == Modifier.STATIC)
                    System.out.println(method);
        }
    }
}
