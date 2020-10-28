package by.it.makovsky.calc;

public interface Patterns {
    String OPERATIONS = "(?<=[^{,=+*/-])[-+*/=]|[\\(\\)]";
    String SCALAR = "-?\\d+(\\.\\d+)?";
    String VECTOR = "\\{"+SCALAR+"(\\,\\s?"+SCALAR+")*}";
    String MATRIX = "\\{"+VECTOR+"(\\,\\s?"+VECTOR+")*}";
}
