package by.it.kalashnikov.jd01_10;

import java.lang.reflect.*;

class PrintMath {
    public static void main(String[] args) {
        Class<?> mathClass = Math.class;
        Method[] declaredMethods = mathClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            StringBuilder sb=new StringBuilder();
            if ((method.getModifiers() & Modifier.PRIVATE) != Modifier.PRIVATE){

                if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC){
                sb.append("public ");}

                if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC){
                    sb.append("static ");
                    Class<?> returnType = method.getReturnType();
                    sb.append(returnType.getSimpleName());
                    sb.append(' ');
                    sb.append(method.getName());
                    sb.append('(');

                    int parameterCount = method.getParameterCount();
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    for (int i = 0; i < parameterTypes.length; i++) {
                        if (parameterCount==1){
                            sb.append(parameterTypes[i].getSimpleName());
                        }else if (parameterCount>=2){
                            sb.append(parameterTypes[i].getSimpleName());
                            sb.append(',');
                            sb.append(parameterTypes[i+1].getSimpleName());
                            break;
                        }
                    }
                    sb.append(')');
                    System.out.println(sb);
                }
            }
        }
        Field[] declaredFields = mathClass.getFields();
        StringBuilder sb1 = new StringBuilder();
        for (Field field : declaredFields) {
            Class<?> returnType = field.getType();
            sb1.append(returnType.getSimpleName());
            sb1.append(' ');
            sb1.append(field.getName());
            sb1.append("\n");
        }

        Field[] fields = mathClass.getDeclaredFields();
        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) != Modifier.PUBLIC) {
                    sb1.append(field.getName());
                    sb1.append("\n");
            }
        }
        System.out.println(sb1);
    }
}
