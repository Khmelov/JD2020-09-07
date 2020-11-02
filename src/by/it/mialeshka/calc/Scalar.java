package by.it.mialeshka.calc;

class Scalar extends Var {
    double var;
    @Override

    public String toString() {
        return Double.toString(var);
    }

    public Scalar(double var) {
        this.var = var;
    }
       public Scalar(String str) {
        this.var = Double.parseDouble(str);
    }

    public Scalar(Scalar scalar) {
        this.var = scalar.var;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar)
        {
            double sum = this.var+((Scalar) other).var;
            return new Scalar(sum);
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar)
        {
            double sub = this.var-((Scalar) other).var;
            return new Scalar(sub);
        }
        else return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar)
        {
            double mul = this.var*((Scalar) other).var;
            return new Scalar(mul);
        }
        else return other.mul(this);
    }

    public double getVar() {
        return var;
    }


    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar)
        {
            if(((Scalar) other).var == 0)
                throw new CalcException(ErrMesages.res.get(ErrMesages.divZero));
            double div = this.var/((Scalar) other).var;
            return new Scalar(div);
        }
        else return super.div(other);
    }
}
