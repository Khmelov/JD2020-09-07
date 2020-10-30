package by.it.yatsevich.Calc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ParserTest {
    Parser parser;

    @SuppressWarnings("RedundantThrows")
    @Before
    public void setUp() throws CalcException{
        parser = new Parser();
    }

    @Test
    public void calcA1() throws CalcException{
        Var result = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(result.toString());
        double expect = 7.3;
        assertEquals(expect,actual,1e-6);
    }

    @Test
    public void calcA2() throws Exception {
        double expected =25.55;
        Parser parser= new Parser();
        Var result = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(result.toString());
        assertEquals(expected, actual, 1e-6);
    }
    @Test
    public void calcA3() throws Exception {
        Var result = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(result.toString());
        double expected =25;
        assertEquals(expected, actual, 1e-6);
    }
    @Test
    public void calcA4() throws Exception {
        Var result = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(result.toString());
        double expected =2.65;
        assertEquals(expected, actual, 1e-6);
    }
    @Test
    public void calcB1() throws Exception {
        Var result = parser.calc("C=B+(A*2)");
        double actual = Double.parseDouble(result.toString());
        double expected =40.15;
        assertEquals(expected, actual, 1e-6);
    }
    @Test
    public void calcB2() throws Exception {
        Var result = parser.calc("D=((C-0.15)-20)/(7-5)");
        double actual = Double.parseDouble(result.toString());
        double expected =10;
        assertEquals(expected, actual, 1e-6);
    }
    @Test
    public void calcB3() throws Exception {
        Vector result = (Vector) parser.calc("E={2,3}*(D/2)");
        double [] actual = result.getValue();
        double [] expected = {10, 15};
        assertArrayEquals(expected,actual,1e-6);
    }
    @Test
    public void calcScalar() throws Exception {
        Var result = parser.calc("A=2+((3*5)-(10/2))");
        double actual = Double.parseDouble(result.toString());
        double expected =12;
        assertEquals(expected, actual, 1e-6);
    }

    @Test
    public void calcMatrixMulMatrix() throws Exception {
        Matrix result = (Matrix)parser.calc("E={{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}*{{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}");
        double [][]actual=result.getValue();
        double[][] expected={{60.0, 72.0, 84.0}, {252.0, 312.0, 372.0}};
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i],actual[i],1e-6);
        }
    }

    @Test
    public void calcMatrixMulVector() throws Exception {
        Vector result = (Vector) parser.calc("E={{1,2},{8,3}}*{1,2}");
        double[] actual= result.getValue();
        double[]expected={5.0, 14.0};
        assertArrayEquals(expected,actual,1e-6);
    }
    @Test
    public void calcMatrixMulScalar() throws Exception {
        Matrix result = (Matrix)parser.calc("E={{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}*2");
        double [][]actual=result.getValue();
        double[][] expected={{4, 8.0, 12}, {28, 32, 36}};
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i],actual[i],1e-6);
        }
    }
    @Test
    public void calcMatrixAddMatrix() throws Exception {
        Matrix result = (Matrix)parser.calc("E={{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}+{{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}");
        double [][]actual=result.getValue();
        double[][] expected={{4, 8.0, 12}, {28, 32, 36}};
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i],actual[i],1e-6);
        }
    }
    @Test
    public void checkMatrixAddScalar() throws Exception {
        Matrix result = (Matrix)parser.calc("E={{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}+3");
        double [][]actual=result.getValue();
        double[][] expected={{5, 7, 9}, {17, 19, 21}};
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i],actual[i],1e-6);
        }
    }
    @Test
    public void checkMatrixSubMatrix() throws Exception {
        Matrix result = (Matrix)parser.calc("E={{2.0, 4.0, 6.0},{14.0, 16.0, 18.0}}-{{2.0, 4.0, 6.0}, {14.0, 16.0, 18.0}}");
        double [][]actual=result.getValue();
        double[][] expected={{0, 0, 0}, {0, 0, 0}};
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i],actual[i],1e-6);
        }
    }
    @Test
    public void checkMatrixSubScalar() throws Exception {
        Matrix result = (Matrix)parser.calc("E={{2.0, 4.0, 6.0},{14.0, 16.0, 18.0}}-1");
        double [][]actual=result.getValue();
        double[][] expected={{1, 3, 5}, {13, 15, 17}};
        for (int i = 0; i < actual.length; i++) {
            assertArrayEquals(expected[i],actual[i],1e-6);
        }
    }
    @Test
    public void checkVectorAddScalar() throws Exception {
        Vector result = (Vector) parser.calc("E={2,3}+1");
        double [] actual = result.getValue();
        double [] expected = {3, 4};
        assertArrayEquals(expected,actual,1e-6);
    }
    @Test
    public void checkVectorAddVector() throws Exception {
        Vector result = (Vector) parser.calc("E={2,3}+{2,3}");
        double [] actual = result.getValue();
        double [] expected = {4, 6};
        assertArrayEquals(expected,actual,1e-6);
    }
    @Test
    public void checkVectorSubScalar() throws Exception {
        Vector result = (Vector) parser.calc("E={2,3}-1");
        double [] actual = result.getValue();
        double [] expected = {1, 2};
        assertArrayEquals(expected,actual,1e-6);
    }
    @Test
    public void checkVectorSubVector() throws Exception {
        Vector result = (Vector) parser.calc("E={2,3}-{12,13}");
        double [] actual = result.getValue();
        double [] expected = {-10, -10};
        assertArrayEquals(expected,actual,1e-6);
    }
    @Test
    public void checkVectorMulScalar() throws Exception {
        Vector result = (Vector) parser.calc("E={2,3}*2");
        double [] actual = result.getValue();
        double [] expected = {4, 6};
        assertArrayEquals(expected,actual,1e-6);
    }
    @Test
    public void checkVectorMulVector() throws Exception {
        Var actual = parser.calc("E={2,3}*{2,3}");
        double expected = 13;
        assertEquals(expected,Double.parseDouble(actual.toString()),1e-6);
    }
    @Test
    public void checkVectorDivScalar() throws Exception {
        Vector result = (Vector) parser.calc("E={2,3}/2");
        double [] actual = result.getValue();
        double [] expected = {1, 1.5};
        assertArrayEquals(expected,actual,1e-6);
    }

    @After
    public void tearDown() throws CalcException{
        Var.clear();
    }
}
