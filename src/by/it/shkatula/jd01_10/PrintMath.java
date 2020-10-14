package by.it.shkatula.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.security.Signature;
import java.util.jar.Attributes;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> structMathClass = Math.class;
        Method[] methods = structMathClass.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            StringBuilder out = new StringBuilder();
            if (Modifier.isPublic(modifiers)) {
                out.append("public ");
                if (Modifier.isStatic(modifiers)) {
                    out.append("static ");
                    String returnType = method.getReturnType().getSimpleName();
                    if (returnType.equalsIgnoreCase("float") || returnType.equalsIgnoreCase("double")) {

                        out.append(returnType);

                        out.append(' ');
                        out.append(method.getName());
                        if (method.getName().equalsIgnoreCase("abs") || method.getName().equalsIgnoreCase("pow"))
                        out.append('(');
                        for (Class<?> parameterType : method.getParameterTypes()) {
                            out.append(parameterType.getSimpleName());
                            
                            out.append(",");
                        }

                        out.append(')');
                        System.out.println(out);
                    }
                }
            }
        }
    }
}
