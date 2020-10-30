package by.it.trukhanovich.calc;

public class CalcException extends Exception{
    private static Lang resource = Lang.LANG;
    public CalcException() {
    }

    public CalcException(String message) {

//        super("ERROR: "+message);
        super(resource.get(Error.ERR) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(resource.get(Error.ERR)+message, cause);
    }

    public CalcException(Throwable cause) {
        super(cause);
    }
}
