package by.it.stefankin.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> c = String.class;
        Method[] metody = c.getDeclaredMethods();

        StringBuilder out = new StringBuilder();

        for (Method met : metody) {
            int modifiers = met.getModifiers();

            if (!Modifier.isStatic(modifiers)) {


                   out.append(met.getName());
                System.out.println(out);

            }
        }




    }



}
