package by.it.tarasevich.calculator;

interface Patterns {
    String SKALAR="-?\\d+(\\.\\d+)?";
    String VECTOR="\\{"+SKALAR+"(\\,\\s?"+SKALAR+")*}";
    String MATRIX="\\{"+VECTOR+"(\\,\\s?"+VECTOR+")*}";
    String OPERANIONS="(?<=[^{,=+*/-])[-+*/=]|[\\(\\)]";

}
