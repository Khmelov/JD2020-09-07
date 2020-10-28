package by.it.kalashnikov.calculator;

public interface Patterns {

    String OPERATION="(?<=[^{,=+*/-])[-+*/=]|[\\(\\)]";
    String SCALAR="-?\\d+(\\.\\d+)?";
    String VECTOR="\\{"+SCALAR+"(\\,\\s?"+SCALAR+")*}";
    String MATRIX="\\{"+VECTOR+"(\\,\\s?"+VECTOR+")*}";
}
