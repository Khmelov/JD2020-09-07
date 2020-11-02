package by.it.mialeshka.calc;

interface Patterns {
    String OPERATION = "(?<=[^-+*=/{,])[-+*/=]";
    String SCALAR = "-?[0-9]+\\.?[0-9]*";
    String VECTOR = "\\{"+SCALAR+"(,\\s*"+SCALAR+")*}";
    String MATRIX = "\\{"+VECTOR+"(,\\s*"+VECTOR+")*}";
    String GROUPOPERATION  = "[(]{1}[-+*/0-9a-zA-Z.,{}]+[)]{1}";
}
