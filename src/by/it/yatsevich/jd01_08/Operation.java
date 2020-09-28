package by.it.yatsevich.jd01_08;

interface Operation {
    Object add(Var other);
    Var sub(Var other);
    Var mul(Var other);
    Var div(Var other);
}
