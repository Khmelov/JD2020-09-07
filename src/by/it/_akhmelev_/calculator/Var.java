package by.it._akhmelev_.calculator;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation{

    private static Map<String,Var> vars=new HashMap<>();


    static Var save(String name, Var value) throws CalcException {
        vars.put(name,value);
        saveToTxt();
        return value;
    }

    private static String getPath(Class<?> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskAClass
                .getName()
                .replace(taskAClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }

    private static void saveToTxt() throws CalcException {
        String path = getPath(Var.class)+"vars.txt";
        try (PrintWriter writer = new PrintWriter(path)) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                writer.printf("%s=%s\n",pair.getKey(),pair.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new CalcException(e);
        }
    }

    static void load() throws CalcException {
        String path = getPath(Var.class)+"vars.txt";
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                lines.add(reader.readLine());
            }
        } catch (FileNotFoundException e) {
            //throw new RuntimeException("error read vars",e);
        }
        catch (IOException e) {
            throw new RuntimeException("error read vars",e);
        }
        Parser parser = new Parser();
        for (String line : lines) {
            parser.calc(line);
        }
    }

    @Override
    public Var add(Var other)  throws CalcException{
        throw new CalcException(String.format("Операция %s + %s невозможна\n",this,other));
    }

    @Override
    public Var sub(Var other)   throws CalcException{
        throw new CalcException(String.format("Операция %s - %s невозможна\n",this,other));
    }

    @Override
    public Var mul(Var other)   throws CalcException{
        throw new CalcException(String.format("Операция %s * %s невозможна\n",this,other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s / %s невозможна\n",this,other));
    }

    @Override
    public String toString() {
        return "abstract Var ";
    }

    static Var createVar(String strVar) throws CalcException {

        if (strVar.matches(Patterns.SCALAR)){
            return new Scalar(strVar);
        }
        else if (strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }
        else if (strVar.matches(Patterns.MATRIX)){
            return new Matrix(strVar);
        }
        else {
            Var var = vars.get(strVar);
            if (var!=null)
                return var;

        }

        throw new CalcException(String.format("Неизвестная переменная "+strVar));
    }
}
