package by.it.stefankin.jd20_04;

public class Scalar extends Var {

    Double val;

    public Double getVal() {
        return val;
    }

    Scalar (double value){
         val=value;
     }
     Scalar (Scalar scalar){
         this.val=scalar.val;
     }
     Scalar (String strScalar){
         val=Double.parseDouble(strScalar);
     }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sum = this.val+((Scalar) other).val;
            return new Scalar(sum);
        }
        else
            return other.add(this);

    }

    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double subs = this.val-((Scalar) other).val;
            return new Scalar(subs);
        }
        else
            return other.sub(this).mul(new Scalar(-1));

    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double mult = this.val*((Scalar) other).val;
            return new Scalar(mult);
        }
        else
            return other.mul(this);

    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar)other).val==0)
                throw new CalcException("Деление на ноль");
            double divs = this.val/((Scalar) other).val;
            return new Scalar(divs);
        }
        else
            return super.div(other);
    }

    public String toString() {
         return val.toString();

     }

}
