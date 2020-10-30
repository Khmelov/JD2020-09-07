package by.it.kalashnikov.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void checkA1() throws CalcException {
        Parser parser = new Parser();
        Var resSum = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(resSum.toString());
        double expected = 7.3;
        assertEquals(expected, actual, 1e-8);
    }
    @Test
    public void checkA2() throws CalcException {
        Parser parser = new Parser();
        Var resMul = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(resMul.toString());
        double expected = 25.55;
        assertEquals(expected, actual, 1e-8);
    }
    @Test
    public void checkA3() throws CalcException {
        Parser parser = new Parser();
        Var resMulAndSub = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(resMulAndSub.toString());
        double expected = 25;
        assertEquals(expected, actual, 1e-8);
    }
    @Test
    public void checkA4() throws CalcException {
        Parser parser = new Parser();
        Var resDivAndSub = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(resDivAndSub.toString());
        double expected = 2.65;
        assertEquals(expected, actual, 1e-8);
    }
    @Test
    public void checkB1() throws Exception {
        Parser parser= new Parser();
        Var resB1 = parser.calc("C=B+(A*2)");
        double actual = Double.parseDouble(resB1.toString());
        double expected =40.15;
        assertEquals(expected, actual, 1e-8);
    }
    @Test
    public void checkB2() throws Exception {
        Parser parser= new Parser();
        Var resB2 = parser.calc("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(resB2.toString());
        double expected =10;
        assertEquals(expected, actual, 1e-8);
    }
    @Test
    public void checkB3() throws Exception {
        Parser parser= new Parser();
        Var resB3 =  parser.calc("E={2,3}*(D/2)");
        double [] actual = ((Vector)resB3).getValue();
        double [] expected = {10, 15};
        assertArrayEquals(expected,actual,1e-8);
    }

}