package by.it.yatsevich.Calc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

abstract class Var implements Operation {

    private static final Map<String,Var> vars = new HashMap<>();

    static Var saveVar(String name,Var value) throws CalcException{
        vars.put(name, value);
        saveToTxt();
        return value;
    }

    static void clear() throws CalcException{
        try {
            Path path = Paths.get(getPath()+"vars.txt");
            if (Files.exists(path)){
                Files.delete(path);
            }
        }catch (IOException e){
            throw new CalcException("Error clearing",e);
        }
    }

    private static String getPath(){
        String rootProject = System.getProperty("user.dir");
        String relativePath = Var.class
                .getName()
                .replace(Var.class.getSimpleName(), "")
                .replace(".", File.separator);
        return rootProject + File.separator + "src" + File.separator + relativePath;
    }

    private static void saveToTxt() throws CalcException{
        String path = getPath() + "vars.txt";
        try (PrintWriter writer = new PrintWriter(path)){
            for (Map.Entry<String, Var> stringVar : vars.entrySet()) {
                writer.printf("%s=%s\n",stringVar.getKey(),stringVar.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new CalcException(e);
        }
    }

    static void load() throws CalcException{
        Path path = Paths.get(getPath()+"vars.txt");
        if (Files.exists(path)){
            try {
                List<String> list = Files.lines(path).collect(Collectors.toList());
                Parser parser = new Parser();
                for (String s : list) parser.calc(s);
            } catch (IOException e) {
                throw new CalcException("ERROR reading",e);
            }
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s + %s невозможна\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s + %s невозможна\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s + %s невозможна\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s + %s невозможна\n", this, other));
    }

    @Override
    public String toString() {
        return "Это класс AbstractVar";
    }

    static Var createVar(String strVar) throws CalcException {
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        }else if (vars.containsKey(strVar)){
            return vars.get(strVar);
        }
        throw new CalcException("unknown variable" + strVar);
    }
}
