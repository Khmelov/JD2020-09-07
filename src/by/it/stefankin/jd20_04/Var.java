package by.it.stefankin.jd20_04;

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

public abstract class Var implements Operation {

    private static final Map<String,Var> vs = new HashMap<>();

    static Var save(String name,Var value) throws CalcException {
        vs.put(name, value);
        saveToTxt();
        return value;
    }

    static Var createVar (String operand)  throws CalcException{
         operand=operand.trim().replace("\\s+","");

            if (operand.matches(Patterns.SCALAR))
                return new Scalar(operand);
            if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
            else {
                Var var = vs.get(operand);
                if (var != null)
                    return var;

            }

            throw new CalcException("Невозможно создать "+operand);
    }

    @Override
    public Var add(Var other) throws CalcException {
       throw new CalcException("Операция сложения "+this+ " + "+other+" невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания "+this+" - "+other+" невозможна");
        }

    @Override
    public Var mul(Var other)throws CalcException  {
        throw new CalcException("Операция умножения "+this+" * "+other+" невозможна");
        }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления "+this+" / "+other+" невозможна");
        }


    private static String getPath() {
        String path = Var.class
                .getName()
                .replace(Var.class.getSimpleName(), "")
                .replace(".", File.separator);
        return System.getProperty("user.dir") +
                File.separator + "src" + File.separator + path;
    }



    private static void saveToTxt() throws CalcException {
        String path = getPath() + "var.txt";
        try (PrintWriter writer = new PrintWriter(path)) {
            for (Map.Entry<String,Var>  pair : vs.entrySet()) {
                writer.printf("%s=%s\n", pair.getKey(), pair.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new CalcException(e);
        }
    }

    static void clear() throws CalcException {
        try {
            Path path = Paths.get(getPath() + "vars.txt");
            if (Files.exists(path)) {
                Files.delete(path);
            }
        } catch (IOException e) {
            throw new CalcException("ERROR: clear vars", e);
        }
    }

    static void load() throws CalcException {
        Path path = Paths.get(getPath() + "vars.txt");
        if (Files.exists(path)) {
            try {
                List<String> list = Files.lines(path).collect(Collectors.toList());
                Parser parser = new Parser();
                for (String line : list) parser.calc(line);
            } catch (IOException e) {
                throw new RuntimeException("Error see vars", e);
            }
        }
    }




}
