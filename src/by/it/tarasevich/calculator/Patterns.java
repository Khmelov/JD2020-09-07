package by.it.tarasevich.calculator;

public interface Patterns {
    String OPERATION="[-+*/=]";
    String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    String VECTOR="\\{"+SCALAR+"(,\\s*"+SCALAR+")*}";
    String MATRIX="\\{"+VECTOR+"(,\\s*"+VECTOR+")*}";
}
