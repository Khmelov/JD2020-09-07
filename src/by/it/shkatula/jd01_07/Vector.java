package by.it.shkatula.jd01_07;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = setVector(vector.value);
    }

    Vector(String strVector) {
        this.value = parseString(strVector);

    }

    private double[] setVector(double[] vec) {
        double[] resultVector = new double[vec.length];
        for (int i = 0; i < resultVector.length; i++) {
            resultVector[i] = vec[i];
        }

        return resultVector;
    }


    //  {1.0, 2.0, 4.0}
    private double[] parseString(String line) {

        line = line.replaceAll("\\{", "");
        line = line.replaceAll("}", "");
        String[] qwe = line.split(",");
        double[] result = new double[qwe.length];
        for (int i = 0; i < qwe.length; i++) {
            result[i] = Double.parseDouble(qwe[i].trim());
        }
        return result;
    }

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimeter = "";
        for (double element : value) {
            sb.append(delimeter).append(element);
            delimeter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
