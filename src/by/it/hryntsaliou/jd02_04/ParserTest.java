package by.it.hryntsaliou.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    Parser parser = new Parser();

    @Test
    public void TestA1() throws CalcException {
        Var result = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(result.toString());
        double expected = 7.3;
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void TestA2() throws CalcException {
        Var result = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(result.toString());
        double expected = 25.55;
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void TestA3() throws CalcException {
        Var result = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(result.toString());
        double expected = 25;
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void TestA4() throws CalcException {
        Var result = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(result.toString());
        double expected = 2.65;
        assertEquals(expected, actual, 1e-6);
    }
}