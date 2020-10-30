package by.it.makovsky.calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class ParserTest {
    Parser parser;

    @SuppressWarnings("RedundantThrows") //на будущее, если будут исключения
    @Before
    public void setUp() throws CalcException {
        parser = new Parser();
    }


    @Test
    public void calcA1() throws CalcException {
        Var res = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(res.toString());
        double expected = 7.3;
        assertEquals(expected, actual, 1e-6);
    }
    @Test
    public void calcA2() throws CalcException {
        Var res = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(res.toString());
        double expected = 25.55;
        assertEquals(expected, actual, 1e-6);
    }
    @Test
    public void calcA3() throws CalcException {
        Var res = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(res.toString());
        double expected = 25;
        assertEquals(expected, actual, 1e-6);
    }
    @Test
    public void calcA4() throws CalcException {
        Var res = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(res.toString());
        double expected = 2.65;
        assertEquals(expected, actual, 1e-6);
    }
    @Test
    public void calcB1() throws CalcException {
        Var res = parser.calc("C=B+(A*2)");
        double actual = Double.parseDouble(res.toString());
        double expected = 40.15;
        assertEquals(expected, actual, 1e-6);
    }
    @Test
    public void calcB2() throws CalcException {
        Var res = parser.calc("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(res.toString());
        double expected = 10;
        assertEquals(expected, actual, 1e-6);
    }
    @Test
    public void calcB3() throws CalcException {
        Vector res = (Vector) parser.calc("E={2,3}*(D/2)");
        double[] actual = res.getValue();
        double[] expected = {10,15};
        assertArrayEquals(expected, actual, 1e-6);
    }
    @Test
    public void calcScalar() throws Exception {
        Var res = parser.calc("S=1+2-3*4/5");
        double actual = Double.parseDouble(res.toString());
        double expected = 0.6;
        assertEquals(expected, actual, 1e-6);
    }
    @Test
    public void vectorAddScalar() throws CalcException {
        Vector res = (Vector) parser.calc("V1={1,2}+3");
        double[] actual = res.getValue();
        double[] expected = {4,5};
        assertArrayEquals(expected, actual, 1e-6);
    }
    @Test
    public void vectorAddVector() throws CalcException {
        Vector res = (Vector) parser.calc("V2={1,2}+{3,4}");
        double[] actual = res.getValue();
        double[] expected = {4,6};
        assertArrayEquals(expected, actual, 1e-6);
    }
    @Test
    public void vectorSubScalar() throws CalcException {
        Vector res = (Vector) parser.calc("V3={1,2}-3");
        double[] actual = res.getValue();
        double[] expected = {-2,-1};
        assertArrayEquals(expected, actual, 1e-6);
    }
    @Test
    public void vectorSubVector() throws CalcException {
        Vector res = (Vector) parser.calc("V4={1,2}-{3,4}");
        double[] actual = res.getValue();
        double[] expected = {-2,-2};
        assertArrayEquals(expected, actual, 1e-6);
    }
    @Test
    public void vectorMulScalar() throws CalcException {
        Vector res = (Vector) parser.calc("V5={1,2}*3");
        double[] actual = res.getValue();
        double[] expected = {3,6};
        assertArrayEquals(expected, actual, 1e-6);
    }
    @Test
    public void vectorMulVector() throws CalcException {
        Var res = parser.calc("V6={1,2}*{3,4}");
        double actual = Double.parseDouble(res.toString());
        double expected = 11;
        assertEquals(expected, actual, 1e-6);
    }
    @Test
    public void vectorDivScalar() throws CalcException {
        Vector res = (Vector) parser.calc("V7={1,2}/2");
        double[] actual = res.getValue();
        double[] expected = {0.5,1};
        assertArrayEquals(expected, actual, 1e-6);
    }
    @Test
    public void matrixAddScalar() throws CalcException {
        Matrix res = (Matrix) parser.calc("M1={{1,2},{3,4}}+5");
        double[][] expected = {{6.0, 7.0}, {8.0, 9.0}};
        double[][] actual = res.getValue();
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i],actual[i],1e-6);
        }
    }
    @Test
    public void matrixAddMatrix() throws CalcException {
        Matrix res = (Matrix) parser.calc("M2={{1,2},{3,4}}+{{5,6},{7,8}}");
        double[][] expected = {{6.0, 8.0}, {10.0, 12.0}};
        double[][] actual = res.getValue();
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i],actual[i],1e-6);
        }
    }
    @Test
    public void matrixSubScalar() throws CalcException {
        Matrix res = (Matrix) parser.calc("M3={{5,4},{3,2}}-1");
        double[][] expected = {{4.0, 3.0}, {2.0, 1.0}};
        double[][] actual = res.getValue();
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i],actual[i],1e-6);
        }
    }
    @Test
    public void matrixSubMatrix() throws CalcException {
        Matrix res = (Matrix) parser.calc("M4={{5,6},{7,8}}-{{1,2},{3,4}}");
        double[][] expected = {{4.0, 4.0}, {4.0, 4.0}};
        double[][] actual = res.getValue();
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i],actual[i],1e-6);
        }
    }
    @Test
    public void matrixMulScalar() throws CalcException {
        Matrix res = (Matrix) parser.calc("M5={{1,2},{3,4}}*5");
        double[][] expected = {{5.0, 10.0}, {15.0, 20.0}};
        double[][] actual = res.getValue();
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i],actual[i],1e-6);
        }
    }
    @Test
    public void matrixMulVector() throws CalcException {
        Vector res = (Vector) parser.calc("M6={{1,2},{3,4}}*{5,6}");
        double[] actual = res.getValue();
        double[] expected = {17,39};
        assertArrayEquals(expected, actual, 1e-6);
    }
    @Test
    public void matrixMulMatrix() throws CalcException {
        Matrix res = (Matrix) parser.calc("M7={{1,2},{3,4}}*{{5,6},{7,8}}");
        double[][] expected = {{19.0, 22.0}, {43.0, 50.0}};
        double[][] actual = res.getValue();
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i],actual[i],1e-6);
        }
    }

    @After
    public void tearDown() throws CalcException {
        Var.clear();
    }

}