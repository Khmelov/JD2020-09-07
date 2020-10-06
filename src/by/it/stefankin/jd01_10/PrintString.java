package by.it.stefankin.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<?> strgCls = String.class;
        Method[] metody = strgCls.getDeclaredMethods();

        for (Method met : metody) {
            int modifiers = met.getModifiers();
            if (!Modifier.isStatic(modifiers)) {

               System.out.println(met.getName());

            }
        }




    }



}
