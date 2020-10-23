package by.it.tarasevich.jd01_09;

public interface Patterns {

    String OPERATION = "[-+*/]";
    String SCALAR = "-?\\d+(\\.\\d+)?";
    String VECTOR = "\\{"+SCALAR+"(\\,\\s?"+SCALAR+")*}";
    String MATRIX = "\\{"+VECTOR+"(\\,\\s?"+VECTOR+")*}";
}
