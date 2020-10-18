package by.it.tarasevich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<?> structStringClass = String.class;
        Method [] methods = structStringClass.getDeclaredMethods();
        for (Method method: methods){
            int modifires = method.getModifiers();
            if (Modifier.isStatic(modifires)){continue;}
            else System.out.println(method.getName());
        }
    }
}
