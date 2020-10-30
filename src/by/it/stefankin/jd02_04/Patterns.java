package by.it.stefankin.jd02_04;

public class Patterns {
    //static final String OPERATION="(?<=[^{,=+*/-])[-+*/=]|[\\(\\)]";
    //static final String OPERATION="(?<=[^/{,=+*-])[=+*/-]";
    //static final String OPERATION="(?<=[^/{,=+*-])[=+*/-]";
    static final String OPERATION="(?<=[^{,=+*/-])[-+*/=]|[\\(\\)]";
   // static final String SCALAR="-?\\d+(\\.\\d+)?";
    static final String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    static final String VECTOR="\\{"+SCALAR+"(,\\s*"+SCALAR+")*}";

    //String SKALAR="-?\\d+(\\.\\d+)?";
    //String VECTOR="\\{"+SKALAR+"(\\,\\s?"+SKALAR+")*}";







}
