package by.it.mialeshka.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        for (Method method : methods) {
            int modifier = method.getModifiers();
            if(!Modifier.isStatic(modifier)){
                System.out.println(method.getName());
            }
        }

    }
}
