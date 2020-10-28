package by.it.hryntsaliou.jd02_04;

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

    private static final Map<String, Var> vars = new HashMap<>();

    static Var save(String name, Var value) throws CalcException {
        vars.put(name, value);
        saveToTxt();
        return value;
    }

    static void load() throws CalcException {
        Path path = Paths.get(getPath() + "vars.txt");
        if (Files.exists(path)) {
            try {
                List<String> list = Files.lines(path).collect(Collectors.toList());
                Parser parser = new Parser();
                for (String line : list) parser.calc(line);
            } catch (IOException e) {
                throw new RuntimeException("error read vars", e);
            }
        }
    }

    private static void saveToTxt() throws CalcException {
        String path = getPath() + "vars.txt";
        try (PrintWriter writer = new PrintWriter(path)) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                writer.printf("%s=%s\n", pair.getKey(), pair.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new CalcException(e);
        }
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
        return "Var{}";
    }

    static Var createVar(String strVar) throws CalcException{
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else {
            Var var = vars.get(strVar);
            if (var != null)
                return var;
        }
        throw new CalcException("Неизвестная переменная " + strVar);
    }

    private static String getPath() {
        String relativePath = Var.class
                .getName()
                .replace(Var.class.getSimpleName(), "")
                .replace(".", File.separator);
        return System.getProperty("user.dir") +
                File.separator + "src" + File.separator + relativePath;
    }

}
