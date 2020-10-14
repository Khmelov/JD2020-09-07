package by.it.adryneuski.jd01_07;

import java.util.regex.Pattern;

class Vector extends Var
{
    private static double[] value;

    public Vector(double[] value)

    {
        this.value = value;
    }

    public Vector(Vector vector)

    {
        this.value = vector.value;
    }

    public Vector(String strVector)
    {
        StringBuilder st = new StringBuilder("{1.0, 2.0, 4.0}");
        st.deleteCharAt(0);
        st.deleteCharAt(st.length() - 1);
        Pattern pattern = Pattern.compile(",");
        String[] arrStr = pattern.split(st);

        for (int i = 0; i < arrStr.length; i++)
        {
            this.value[i] = Double.parseDouble(arrStr[i]);
        }
    }
    @Override
    public String toString()
    {
        StringBuilder st = new StringBuilder("{");
        String delimeter = "";
        for (double element: value)
        {
            st.append(delimeter).append(element);
            delimeter = ", ";
        }

        st.append("}");

        return  st.toString();
    }


}