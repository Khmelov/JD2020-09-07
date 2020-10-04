package by.it.tarasevich.jd01_08;


import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String str) {
        String[] string = str.replace('{', ' ')
                .replace('}', ' ')
                .trim()
                .split(",\\s*");
        double[] array = new double[string.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(string[i]);
        }
        this.value = array;
    }


    @Override
    public Var add(Var other) {

        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] *= ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            double sum = 0;
            for (int i = 0; i < res.length; i++) {
                sum=sum +  res[i] * ((Vector) other).value[i];
            }
            return new Scalar(sum);
        }

       else return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] res = new double[value.length];
            for (int i = 0; i < res.length; i++) {
                res[i] =value[i]/ ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){return super.div(other);}
        else if (other instanceof Matrix){return super.div(other);}
        else return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");
        String space = "";
        for (double v : value) {
            stringBuilder.append(space).append(v);
            space = ", ";

        }
        stringBuilder.append("}");


        return stringBuilder.toString();
    }
}
