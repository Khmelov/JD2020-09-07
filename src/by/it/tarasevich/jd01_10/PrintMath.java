package by.it.tarasevich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> structClassMatch = Math.class;
        Method[] methods = structClassMatch.getDeclaredMethods();
        for (java.lang.reflect.Method method:methods) {
            int modifires = method.getModifiers();
            StringBuilder out = new StringBuilder();
            if (Modifier.isPublic(modifires)){
                out.append("public ");
                if (Modifier.isStatic(modifires)){
                    out.append("static");
                    Class<?> returnType = method.getReturnType();
                    out.append(returnType.getSimpleName());
                    out.append(method.getName());
                    out.append('(');
                    for (Class<?> parametrType : method.getParameterTypes())
                        out.append(parametrType.getSimpleName());
                        out.append(",");


                }
                out.append(')');
                System.out.println(out);
            }
        }

    }
}
