package by.it.stefankin.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> c = Math.class;
        Method[] met = c.getDeclaredMethods();

        for (Method method : met) {
            int modifiers = method.getModifiers();
            StringBuilder out = new StringBuilder();

            if (Modifier.isPublic(modifiers)) {
                out.append("public ");
                if (Modifier.isStatic(modifiers))
                    out.append("static ");
                Class<?> returnType = method.getReturnType();
                out.append(returnType.getSimpleName());
                out.append(" ");
                out.append(method.getName());
                out.append('(');

                Class<?>[] parameterType = method.getParameterTypes();

                for (int g = 0; g < method.getParameterTypes().length; g++) {

                    out.append(parameterType[g].getSimpleName());
                    if (method.getParameterTypes().length > 1 && g != method.getParameterTypes().length - 1) {
                        out.append(",");
                    }

                }
                out.append(')');
                System.out.println(out);

            }
        }

        Field[] fields = c.getFields();
        StringBuilder out = new StringBuilder();
        for (Field field : fields) {
            // int modifiers = method.getModifiers();
            out.append("public double ");
            out.append(field.getName());
            out.append('\n');

        }
        System.out.println(out);
    }

}
