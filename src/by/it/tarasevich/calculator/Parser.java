package by.it.tarasevich.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) throws CalcException {
        String[] parts = expression.split(Patterns.OPERATION, 2);
        //если нет операции, а есть только одно число или одна переменная
        if (parts.length == 1)
            return Var.createVar(expression);

        //какая-то операция есть, получим правую часть и проверим присваивание
        Var right = Var.createVar(parts[1]);
        if (expression.contains("="))
            return Var.save(parts[0], right);

        //это вычислительная операция, получаем левую часть
        Var left = Var.createVar(parts[0]);

       //иначе ищем операцию и выполняем ее
        Matcher matcherOperation = Pattern
                .compile(Patterns.OPERATION)
                .matcher(expression);
        if (matcherOperation.find()) {
            switch (matcherOperation.group()) {
                case "+":
                    return left.add(right);
                case "-":
                    return left.sub(right);
                case "*":
                    return left.mul(right);
                case "/":
                    return left.div(right);
            }
        }
        throw new CalcException("Неизвестная операция "+expression);
    }
}
