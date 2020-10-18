package by.it.trukhanovich.calc;

import java.io.*;
import java.util.*;

abstract class Var implements Operation {

    static Map<String,Var> vars =new HashMap<>();

    static TreeMap sortMap(){
        TreeMap treeMap = new TreeMap(vars);
                return treeMap;

    }

    static Var saveVar (String name, Var var) throws CalcException {
        vars.put(name, var);
        saveToTxt();
        return var;
    }

    static void load () throws CalcException{
    String path=getPath(Var.class)+"vars.txt";
    ArrayList<String> lines=new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            while (br.ready()){
                lines.add(br.readLine());
            }

        }
        catch (FileNotFoundException e) {
//            throw new RuntimeException("error read vars", e);
        } catch (IOException e) {
            throw new RuntimeException("error read vars",e);
        }
        Parser parser=new Parser();
        for (String line : lines) {
            parser.calc(line);
        }
    }
    private static void saveToTxt () throws CalcException {
        String path=getPath(Var.class)+"vars.txt";
        try (PrintWriter writer = new PrintWriter(path))
        {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                writer.printf ("%s=%s\n",pair.getKey(),pair.getValue());

            }
        } catch (FileNotFoundException e) {
            throw new CalcException(e);
        }
    }
    private static String getPath(Class<?> taskAClass) {
        String rootProject = System.getProperty("user.dir");
        String relativePath = taskAClass
                .getName()
                .replace(taskAClass.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s + %s невозможна\n", this, other));

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s - %s невозможна\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s * %s невозможна\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s / %s невозможна\n", this, other));

    }

    @Override
    public String toString() {
        return "Это класс Var{}";
    }

    static Var createVar (String strVar) throws CalcException {
        if (strVar.matches(Patterns.SKALAR)){
            return new Scalar(strVar);
        }
       else if (strVar.matches(Patterns.VECTOR)){
            return new Vector(strVar);
        }
        else if (strVar.matches(Patterns.MATRIX)){
            return new Matrix(strVar);
        }
        else if(vars.containsKey(strVar)){
            return vars.get(strVar);
        }
        else {
            throw new CalcException(String.format("Незвестная переменная "+strVar));

        }
    }

    protected abstract int getSize();


}
