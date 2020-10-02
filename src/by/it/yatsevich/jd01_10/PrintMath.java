package by.it.yatsevich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> structureMathClass = Math.class;
        Method[] methods = structureMathClass.getDeclaredMethods();
        for (Method method: methods) {
            int modifiers = method.getModifiers();
            StringBuilder out = new StringBuilder();
            String delimetr="";
            if (Modifier.isPublic(modifiers)){
                out.append("public ");
                if (Modifier.isStatic(modifiers)){
                    out.append("static ");
                    Class<?> returnType = method.getReturnType();
                    out.append(returnType.getSimpleName());
                    out.append(' ');
                    out.append(method.getName());
                    out.append("(");
                    for (Class<?> parametrType: method.getParameterTypes()) {
                        out.append(delimetr).append(parametrType);
                        delimetr=",";
                    }out.append(")");
                    System.out.println(out);
                }
            }
        }


    }

}
