package by.it.adryneuski.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {

        Class<?> mathClass = Math.class;
        Field[] declaredFields = mathClass.getDeclaredFields();
        Method[] declaredMethods = mathClass.getDeclaredMethods();

        for (int i = 0; i < declaredMethods.length; i++) {
            int modifiers = declaredMethods[i].getModifiers();
            StringBuilder outPut = new StringBuilder();
            if (Modifier.isPublic(modifiers)) {
                outPut.append("public ");
                if (Modifier.isStatic(modifiers)) {
                    outPut.append("static ");
                }
                outPut.append(declaredMethods[i].getReturnType() + " ");
                outPut.append(declaredMethods[i].getName() + "(");
                Class<?>[] parameterTypes = declaredMethods[i].getParameterTypes();
                for (int j = 0; j < parameterTypes.length; j++) {
                    outPut.append(parameterTypes[j].getSimpleName());
                    if (j != parameterTypes.length - 1) {
                        outPut.append(",");
                    }
                }
                outPut.append(")");

                System.out.println(outPut);
                System.out.println(declaredMethods[i]);
            }

        }
        for (int i = 0; i < declaredFields.length; i++) {
            int modifiers = declaredFields[i].getModifiers();
            if(Modifier.isPublic(modifiers)) {
                StringBuilder outPut = new StringBuilder();
                outPut.append(declaredFields[i].getGenericType()+" ");
                outPut.append(declaredFields[i].getName());
                System.out.println(outPut);
            }

        }

    }

    }

