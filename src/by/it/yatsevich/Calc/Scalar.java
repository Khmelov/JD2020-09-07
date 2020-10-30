package by.it.yatsevich.Calc;

class Scalar extends Var {

    public double getValue() {
        return value;
    }

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        }else {
            try {
                return other.add(this);
            } catch (CalcException e) {
                e.printStackTrace();
            }
        }
        return other;
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        }else {
            try {
                return new Scalar(-1).mul(other).add(this);
            } catch (CalcException e) {
                e.printStackTrace();
            }
        }
        return other;
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        }else {
            try {
                return other.mul(this);
            } catch (CalcException e) {
                e.printStackTrace();
            }
        }
        return other;
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        }else {
            try {
                return super.div(this);
            } catch (CalcException e) {
                e.printStackTrace();
            }
        }
        return other;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
