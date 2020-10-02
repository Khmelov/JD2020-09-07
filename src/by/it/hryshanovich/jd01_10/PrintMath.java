package by.it.hryshanovich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        Class<?> structMathClass = Math.class;
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
                out.append(method.getName());
                out.append('(');
                for (Class<?> parameterType : method.getParameterTypes()) {
                    out.append(parameterType.getSimpleName());
                    out.append(",");
                }
                out.append('(');
                System.out.println(out);
            }
        }

    }
}