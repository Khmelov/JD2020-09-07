package by.it.drugov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<?> stringClass = String.class;
        Method[] declaredMethods = stringClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            int modifiers = declaredMethods[i].getModifiers();
            if(!Modifier.isStatic(modifiers)) {
                System.out.println(declaredMethods[i].getName());
            }

        }

    }
}
