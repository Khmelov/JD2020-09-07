package by.it._akhmelev_.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ParserTest {
    Parser parser;

    @Before
    public void setUp() throws CalcException {
        parser = new Parser();
    }

    @Test
    public void calc() throws CalcException {
        Var res = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(res.toString());
        double expected = 7.3;
        assertEquals(expected, actual, 1e-6);
    }

    @After
    public void tearDown() throws CalcException {
        new File("6788967987659865798").delete();
    }

}