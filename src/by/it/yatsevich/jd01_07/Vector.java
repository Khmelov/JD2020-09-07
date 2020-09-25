package by.it.yatsevich.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    private double [] value;

    Vector(double[ ] value){
        this.value = value;
    }

    Vector(Vector vector) {
        this.value= vector.value;
    }

    Vector(String strVector){
        StringBuilder line = new StringBuilder(strVector);
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()){
            line.setCharAt(matcher.start(),' '); }
        String line1 = String.valueOf(line);
        line1 = line1.trim();
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder("{");
       String delimiter = " ";
        for (double element:value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }sb.append("}");
        return sb.toString();
    }
}
