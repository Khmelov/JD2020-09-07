package by.it.kulik.jd01_06;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class TaskB1 {

private static final String G= "АаиИУуЕеэЭОоЮюЯя";

    public static void main(String[] args) {


    }
    static boolean checkWord(String word){
        return  G.indexOf(word.charAt(0))<0 && G.indexOf(word.charAt(word.length()-1))>=0;
    }


}