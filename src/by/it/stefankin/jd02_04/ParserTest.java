package by.it.stefankin.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void checkCalcScalar() throws Exception {
        double expected = 7.3;
        Parser parser = new Parser();
        Var varA = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(varA.toString());
        assertEquals(actual,expected,1-8);
    }

    @Test
    public void checkNextCalcScalar() throws Exception {
        double expected = 25.55;
        Parser parser = new Parser();
        Var varB = parser.calc("B=A*3.5");
        double actual = Double.parseDouble(varB.toString());
        assertEquals(actual,expected,1-8);
    }
    @Test
    public void checkCalcScalar3() throws Exception {
        double exp =25;
        Parser parser = new Parser();
        Var var3 = parser.calc("B1=B+0.11*-5");
        double actual = Double.parseDouble(var3.toString());
        assertEquals(actual,exp,1-8);
    }
    @Test
    public void checkCalcScalar4() throws Exception {
        double expected = 2.65;
        Parser parser = new Parser();
        Var var4 = parser.calc("B2=A/2-1");
        double actual = Double.parseDouble(var4.toString());
        assertEquals(actual,expected,1-8);
    }



    @Test
    public void checkCalcVector() throws Exception {
        double[] expected ={2,4,6};
        Parser parser = new Parser();
        Var vectorB = parser.calc("V={1,2,3}+{1,2,3}");
        double[] actual =((Vector)vectorB).getValue();
        assertArrayEquals(actual,expected,1-8);
    }

    @Test
    public void checkCalc6() throws Exception {
        double expected =21.9;
        Parser parser = new Parser();
        Var var6 = parser.calc("C=A+(A*2)");
        double actual = Double.parseDouble(var6.toString());
        assertEquals(actual,expected,1-8);
    }

    @Test
    public void checkCalc7() throws Exception {
        Parser parser = new Parser();
        Var var7 = parser.calc("D=((C-0.15)/(7-5))");
        double expected =10.875;
        double actual = Double.parseDouble(var7.toString());
        assertEquals(expected,actual,1-8);
    }

    @Test
    public void checkCalcVector2() throws Exception {
        double[] expected ={10,15};
        Parser parser = new Parser();
        Var vectorB2 = parser.calc("E={2,3}*(10/2)");
        double[] actual =((Vector)vectorB2).getValue();
        assertArrayEquals(actual,expected,1-8);
    }





}