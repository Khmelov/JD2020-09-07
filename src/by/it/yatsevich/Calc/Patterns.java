package by.it.yatsevich.Calc;

interface Patterns {
    String OPERATION="(?<=[^{,=+*/-])[-+*/=]|[\\(\\)]";
    String SCALAR="-?\\d+(\\.\\d+)?";
    String VECTOR="\\{"+SCALAR+"(,\\s*"+SCALAR+")*}";
    String MATRIX="\\{"+VECTOR+"(,\\s*"+VECTOR+")*}";
}
