package by.it.yatsevich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class
PrintString {

    public static void main(String[] args) {
        Class<String> stringClassStructure = String.class;
        Method[] methods = stringClassStructure.getDeclaredMethods();
        StringBuilder out = new StringBuilder();
        String delimeter = "";
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (!Modifier.isStatic(modifiers)) {
                out.append(method.getName());
                out.append(delimeter).append("\n");
            }
        }
        System.out.println(out);
    }
}
