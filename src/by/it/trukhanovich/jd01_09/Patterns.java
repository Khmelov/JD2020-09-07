package by.it.trukhanovich.jd01_09;

interface Patterns {
    String SKALAR="-?\\d+(\\.\\d+)?";
    String VECTOR="\\{"+SKALAR+"(\\,\\s?"+SKALAR+")*}";
    String MATRIX="\\{"+VECTOR+"(\\,\\s?"+VECTOR+")*}";
    String OPERANIONS="[-+*/]";

}
