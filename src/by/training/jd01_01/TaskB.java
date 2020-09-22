package by.training.jd01_01;

class TaskB {
    public static void main(String[] args) {
        Dog spot = new Dog();
        Dog scruffy = new Dog();
        spot.name = "spot";
        spot.says="woofwoof";
        scruffy.says="gafgaf";
        scruffy.name ="scruffy";
        spot.showName();
        spot.showSays();
        scruffy.showName();
        scruffy.showSays();
    }


}
