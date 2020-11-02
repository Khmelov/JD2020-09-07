package by.it.mialeshka.jd02_05.calc;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParserTest {

    @Test
    public void checkCalcScalar1() throws Exception{
        String expression = "A=2+5.3";
        double expected = 7.3;
        Parser parser = new Parser();
        System.out.println("Check " +expression);
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-8);
        System.out.println(actual);
    }

    @Test
    public void checkCalcScalar2() throws Exception{
        String expression = "B=A*3.5";
        double expected = 25.55;
        Parser parser = new Parser();
        System.out.println("Check " +expression);
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-8);
        System.out.println(actual);
    }

    @Test
    public void checkCalcScalar3() throws Exception{
        String expression = "B1=B+0.11*-5";
        double expected = 25;
        Parser parser = new Parser();
        System.out.println("Check " +expression);
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-8);
        System.out.println(actual);
    }

    @Test
    public void checkCalcScalar4() throws Exception{
        String expression = "B2=A/2-1";
        double expected = 2.65;
        Parser parser = new Parser();
        System.out.println("Check " +expression);
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-8);
        System.out.println(actual);
    }

    @Test
    public void checkCalcScalar5() throws Exception{
        String expression = "C=B+(A*2)";
        double expected = 40.15;
        Parser parser = new Parser();
        System.out.println("Check " +expression);
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-8);
        System.out.println(actual);
    }

    @Test
    public void checkCalcScalar6() throws Exception{
        String expression = "D=((C-0.15)-20)/(7-5)";
        double expected = 10;
        Parser parser = new Parser();
        System.out.println("Check " +expression);
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-8);
        System.out.println(actual);
    }


    @Test
    public void checkCalcVector1() throws Exception{
        String expression = "{12.0, 15.33}/3+{3,4}";
        double[] expected = {7.0, 9.11};
        Parser parser = new Parser();
        System.out.println("Check " +expression);
        Var var = parser.calc(expression);
        double[] actual = ((Vector)var).getVar();
        assertArrayEquals(expected, actual, 1e-8);
        System.out.println(var.toString());
    }

    @Test
    public void checkCalcVector2() throws Exception{
        String expression = "{1, 2}*2-{3,4}";
        double[] expected = {-1.0, 0.0};
        Parser parser = new Parser();
        System.out.println("Check " +expression);
        Var var = parser.calc(expression);
        double[] actual = ((Vector)var).getVar();
        assertArrayEquals(expected, actual, 1e-8);
        System.out.println(var.toString());
    }

    @Test
    public void checkCalcVector3() throws Exception{
        String expression = "{1,2}*{3,4}";
        double expected = 11;
        Parser parser = new Parser();
        System.out.println("Check " +expression);
        Var var = parser.calc(expression);
        double actual = Double.parseDouble(var.toString());
        assertEquals(expected, actual, 1e-8);
        System.out.println(var.toString());
    }


    @Test
    public void checkCalcVector4() throws Exception{
        String expression = "E={2,3}*(D/2)";
        double[] expected = {10, 15};
        Parser parser = new Parser();
        System.out.println("Check " +expression);
        Var var = parser.calc(expression);
        double[] actual = ((Vector)var).getVar();
        assertArrayEquals(expected, actual, 1e-8);
        System.out.println(var.toString());
    }

    @Test
    public void checkCalcMatrix1() throws Exception{
        String expression = "{{1.23,2,3},{4,6,7}}+{{4,5.98,6},{12,3.45,7}}";
        double[][] expected = {{5.23, 7.98, 9.0}, {16.0, 9.45, 14.0}};
        Parser parser = new Parser();
        System.out.println("Check " +expression);
        Var var = parser.calc(expression);
        double[][] actual = ((Matrix)var).getVar();
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-8);
        }
        System.out.println(var.toString());
    }

    @Test
    public void checkCalcMatrix2() throws Exception{
        String expression = "{{1.23,2,3},{4,6,7}}-{{4,5.98,6},{12,3.45,7}}";
        double[][] expected = {{-2.77, -3.98, -3.0}, {-8.0, 2.55, 0.0}};
        Parser parser = new Parser();
        System.out.println("Check " +expression);
        Var var = parser.calc(expression);
        double[][] actual = ((Matrix)var).getVar();
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-8);
        }
        System.out.println(var.toString());
    }

    @Test
    public void checkCalcMatrix3() throws Exception{
        String expression = "{{1.23,2},{4,6}}*{{4,5.98},{12,3.45}}";
        double[][] expected = {{28.92, 14.2554}, {88.0, 44.62}};
        Parser parser = new Parser();
        System.out.println("Check " +expression);
        Var var = parser.calc(expression);
        double[][] actual = ((Matrix)var).getVar();
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-8);
        }
        System.out.println(var.toString());
    }

    @Test
    public void checkCalcMatrix4() throws Exception{
        String expression = "{{-2.77, -3.98}, {-8.0, 2.55}}*3";
        double[][] expected = {{-8.31, -11.94}, {-24.0, 7.65}};
        Parser parser = new Parser();
        System.out.println("Check " +expression);
        Var var = parser.calc(expression);
        double[][] actual = ((Matrix)var).getVar();
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], 1e-8);
        }
        System.out.println(var.toString());
    }

    @Test
    public void checkCalcMatrix5() throws Exception{
        String expression = "{{-8.31, -11.94}, {-24.0, 7.65}}*{1,2}";
        double[] expected = {-32.19, -8.7};
        Parser parser = new Parser();
        System.out.println("Check " +expression);
        Var var = parser.calc(expression);
        double[] actual = ((Vector)var).getVar();
        assertArrayEquals(expected, actual, 1e-8);
        System.out.println(var.toString());
    }

}