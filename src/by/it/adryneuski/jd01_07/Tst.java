package by.it.adryneuski.jd01_07;

public class Tst {
    public static void main(String[] args) {

        Person tom = new Person();
        tom.displayInfo();

        Person GOGA = new Person("GOGA");
        GOGA.displayInfo();


    }
}
class Person{

    String name;    // имя
    int age;        // возраст

    public Person() {
        this("FOKA",33);
    }

    public Person(String name) {

       this(name,79);
    }

    public Person(String name, int age) {


        this.name = name;
        this.age = age;
    }

    void displayInfo(){
        System.out.printf("Name: %s \tAge: %d\n", name, age);
    }
}
