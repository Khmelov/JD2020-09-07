package by.it.hryntsaliou.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMathClass = Math.class;
        Method[] methods = structMathClass.getDeclaredMethods();
        for (Method method : methods) {
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
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];
                    if (i < method.getParameterTypes().length - 1) {
                        out.append(parameterType.getSimpleName());
                        out.append(",");
                    } else out.append(parameterType.getSimpleName());
                }
                out.append(')');
                System.out.println(out);
            }
        }

        Field[] fields = structMathClass.getFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            StringBuilder out = new StringBuilder();
            if (Modifier.isPublic(modifiers)) {
                out.append("public ");
                if (Modifier.isStatic(modifiers))
                    out.append("static ");
                Class<?> returnType = field.getType();
                out.append(returnType.getSimpleName());
                out.append(" ");
                out.append(field.getName());
                System.out.println(out);
            }
        }
    }
}
