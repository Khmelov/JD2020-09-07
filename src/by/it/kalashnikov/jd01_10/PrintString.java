package by.it.kalashnikov.jd01_10;
import java.lang.reflect.*;
class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        StringBuilder sb=new StringBuilder();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC){
                sb.append(method.getName());
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
