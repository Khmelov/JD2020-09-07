package by.it.trukhanovich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> structMathClass = Math.class;
        Method[] methods = structMathClass.getDeclaredMethods();
        for (Method method : methods) {
//            System.out.println(method);
            int modifiers = method.getModifiers();
            StringBuilder out = new StringBuilder();
            if (Modifier.isPublic(modifiers)) {
                out.append("public ");
                if (Modifier.isStatic(modifiers)) {
                    out.append("static ");
                }
                out.append(method.getReturnType()).append(" ");
                out.append(method.getName()).append("(");
                Class<?> returnType = method.getReturnType();
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];
                    out.append(parameterType.getSimpleName());
                    if (i < parameterTypes.length - 1) out.append(",");
                }
                out.append(")");
                System.out.println(out);
            }
        }
        Field[] fields = structMathClass.getFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            StringBuilder out = new StringBuilder();
            if (Modifier.isPublic(modifiers)) {
                out.append(field.getType()).append(" ");
                out.append(field.getName());
            }
            System.out.println(out);
        }
    }
}
