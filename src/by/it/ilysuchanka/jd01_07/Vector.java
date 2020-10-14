package by.it.ilysuchanka.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    private static double[] value;

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            if (i == value.length - 1) {
                line.append(value[i]).append("}");
                continue;
            }
            line.append(value[i]).append(", ");
        }
        return line.toString();
    }

    Vector(String strVector) {
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(strVector);
        while (matcher.find()) {
            strVector = matcher.replaceAll(" ");
        }
        for (int i = 0; i < strVector.trim().split(",").length; i++) {
            value[i] = Double.parseDouble(strVector.trim().split(",")[i]);
        }
    }

    Vector(Vector vector) {
    }

    Vector(double[] value) {
        Vector.value = value;
    }
}
