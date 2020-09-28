package by.it.drugov.jd01_08;


class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double result = this.value + ((Scalar) other).value;
            return new Scalar(result);

        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double result = this.value - ((Scalar) other).value;
            return new Scalar(result);
        } else {
            return new Scalar(-1).mul(this).add(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double result = this.value * ((Scalar) other).value;
            return new Scalar(result);
        } else {
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double result = this.value / ((Scalar) other).value;
            return new Scalar(result);
        } else if (other instanceof Vector) {
            return other.div(this);
        } else {
            return super.div(other);
        }
    }
}
