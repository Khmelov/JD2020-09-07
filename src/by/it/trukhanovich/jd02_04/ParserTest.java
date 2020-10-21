package by.it.trukhanovich.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void checkA1() throws Exception {
        double expected =7.3;
        Parser parser= new Parser();
        Var calcA1 = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(calcA1.toString());
        assertEquals(expected, actual, 1e-8);
    }

    @Test
    public void checkA2() throws Exception {
        double expected =25.55;
        Parser parser= new Parser();
        Var calcA2 = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(calcA2.toString());
        assertEquals(expected, actual, 1e-8);
    }
    @Test
    public void checkA3() throws Exception {
        double expected =25;
        Parser parser= new Parser();
        Var calcA3 = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(calcA3.toString());
        assertEquals(expected, actual, 1e-8);
    }
    @Test
    public void checkA4() throws Exception {
        double expected =2.65;
        Parser parser= new Parser();
        Var calcA4 = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(calcA4.toString());
        assertEquals(expected, actual, 1e-8);
    }
    @Test
    public void checkB1() throws Exception {
        double expected =40.15;
        Parser parser= new Parser();
        Var calcB1 = parser.calc("C=B+(A*2)");
        double actual = Double.parseDouble(calcB1.toString());
        assertEquals(expected, actual, 1e-8);
    }
    @Test
    public void checkB2() throws Exception {
        double expected =10;
        Parser parser= new Parser();
        Var calcB2 = parser.calc("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(calcB2.toString());
        assertEquals(expected, actual, 1e-8);
    }
    @Test
    public void checkB3() throws Exception {
        Var expected = new Vector("{10,15}");
        Parser parser= new Parser();
        Var calcB3 = parser.calc("E={2,3}*(D/2)");
        double actual = Double.parseDouble(calcB3.toString());
        assertEquals(String.valueOf(expected), String.valueOf(actual));
    }
    @Test
    public void checkC1() throws Exception {
        Var expected = new Matrix( "{{60.0, 72.0, 84.0}, {252.0, 312.0, 372.0}}");
        Parser parser= new Parser();
        Var actual = parser.calc("E={{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}*{{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}");
        assertEquals(String.valueOf(expected), String.valueOf(actual));
    }
    @Test
    public void checkC2() throws Exception {
        Var expected = new Vector( "{5.0, 14.0}");
        Parser parser= new Parser();
        Var actual = parser.calc("E={{1,2},{8,3}}*{1,2}");
        assertEquals(String.valueOf(expected), String.valueOf(actual));
    }
    @Test
    public void checkC3() throws Exception {
        Var expected = new Matrix( "{{2,4},{16,6}}");
        Parser parser= new Parser();
        Var actual = parser.calc("AD={{1,2},{8,3}}+{{1,2},{8,3}}");
        assertEquals(String.valueOf(expected), String.valueOf(actual));
    }



}