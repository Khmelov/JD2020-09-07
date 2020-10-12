package by.it.mialeshka.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        Field[] fields = mathClass.getDeclaredFields();

        for (Field field : fields) {
            int fieldM = field.getModifiers();

            if(Modifier.isPublic(fieldM)){
                StringBuilder strFieldM = new StringBuilder("public");
                if(Modifier.isStatic(fieldM)) strFieldM.append(" static");
                if (Modifier.isAbstract(fieldM)) strFieldM.append(" abstract");
                if(Modifier.isFinal(fieldM)) strFieldM.append(" final");

                System.out.printf("%s %s %s\n", strFieldM, field.getType(),field.getName());
            }
        }

        for (Method method : methods) {
            int modifier = method.getModifiers();
            if ((modifier & Modifier.PUBLIC) == Modifier.PUBLIC){
                Class<?>[] parameterTypes = method.getParameterTypes();
                StringBuilder atrParType = new StringBuilder();
                String d = "";
                for (Class<?> parameterType : parameterTypes) {
                    atrParType.append(d).append(parameterType.getSimpleName());
                    d = ",";
                }
                StringBuilder strModifier = new StringBuilder("public");
                if(Modifier.isStatic(modifier)) strModifier.append(" static");
                if (Modifier.isAbstract(modifier)) strModifier.append(" abstract");
                if(Modifier.isFinal(modifier)) strModifier.append(" final");

                System.out.printf("%s %s %s(%s)\n", strModifier.toString(), method.getReturnType(), method.getName(), atrParType.toString());
            }
        }
    }
}
