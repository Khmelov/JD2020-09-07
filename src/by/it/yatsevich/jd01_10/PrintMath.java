package by.it.yatsevich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class PrintMath {

    public static void main(String[] args) {
        Class<Math> structureMathClass = Math.class;
        Field[] fields = structureMathClass.getFields();
        Method[] methods = structureMathClass.getMethods();

        for (Field field : fields) {
            StringBuilder out = new StringBuilder();
            String delimetr = "";
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)){
                out.append("public ");
                if (Modifier.isStatic(modifiers)){
                    out.append("static ");
                    Class<?> type = field.getType();
                    out.append(type.getSimpleName());
                    out.append(' ');
                    out.append(field.getName());
                    out.append(delimetr);
                }
            }System.out.println(out);
        }

        for (Method method : methods) {
            StringBuilder out = new StringBuilder();
            String delimetr = "";
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                out.append("public ");
                if (Modifier.isStatic(modifiers)) {
                    out.append("static ");
                    Class<?> returnType = method.getReturnType();
                    out.append(returnType.getSimpleName());
                    out.append(' ');
                    out.append(method.getName());
                    out.append("(");
                    for (Class<?> parametrType : method.getParameterTypes()) {
                        out.append(delimetr).append(parametrType);
                        delimetr = ",";
                    }
                    out.append(")");
                    System.out.println(out);
                }
            }
        }


    }

}
