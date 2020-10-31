package by.it.mialeshka.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class VarTest {

    @Test
    public void createVarScalar() throws CalcException {
        String expression = "10.45";
        String expected = "10.45";
        System.out.println("Check " +expression);
        String actual = Var.createVar(expression).toString();
        assertEquals(expected, actual);
        System.out.println(actual);
    }

    @Test
    public void createVarVector() throws CalcException {
        String expression = "{1,2,3,4}";
        String expected = "{1.0, 2.0, 3.0, 4.0}";
        System.out.println("Check " +expression);
        String actual = Var.createVar(expression).toString();
        assertEquals(expected, actual);
        System.out.println(actual);
    }

    @Test
    public void createVarMatrix() throws CalcException {
        String expression = "{{1.35,2,12.5},{8,9,0}}";
        String expected = "{{1.35, 2.0, 12.5}, {8.0, 9.0, 0.0}}";
        System.out.println("Check " +expression);
        String actual = Var.createVar(expression).toString();
        assertEquals(expected, actual);
        System.out.println(actual);
    }
}