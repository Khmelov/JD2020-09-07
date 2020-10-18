package by.it.stefankin.jd01_09;

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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double sum = this.val+((Scalar) other).val;
            return new Scalar(sum);
        }
        else
            return other.add(this);

    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double subs = this.val-((Scalar) other).val;
            return new Scalar(subs);
        }
        else
            return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double mult = this.val*((Scalar) other).val;
            return new Scalar(mult);
        }
        else
            return other.mul(this);

    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
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
