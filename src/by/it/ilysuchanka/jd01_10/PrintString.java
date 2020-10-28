package by.it.ilysuchanka.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<?> structStringClass = String.class;
        Method [] methods = structStringClass.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (Modifier.isStatic(modifiers)){continue;}
            else System.out.println(method.getName());
        }

    }
}
