package by.it.hryntsaliou.jd02_04;

public interface Patterns {
    String OPERATION="(?<=[^{,=+*/-])[-+*/=]";
    String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    String VECTOR="\\{"+SCALAR+"(,\\s*"+SCALAR+")*}";
    String MATRIX="\\{"+VECTOR+"(,\\s*"+VECTOR+")*}";
}
