package by.it._examples_.jd02_01;

class Threads_01_Thread {
    //пример показывает как можно создать потоки на базе класса Thread
    public static class MyThread extends Thread {
        @Override
        public void run() { //метод run должен обязательно быть у каждого потока
            //это тело потока.
            System.out.println(this.getName() + "Цикл №" + 0);
            try {
                sleep((int) (Math.random() * 1000)); // остановка на 0..999 миллисекунд
                yield (); //так можно указать, что поток желает временно отдать
                //управление для выполнения других конкуррентных потоков
            } catch (InterruptedException e) {
                System.err.print(e.toString());
            }
            //это тело потока.
            System.out.println(this.getName() + "Цикл №" + 1);
            try {
                sleep((int) (Math.random() * 1000)); // остановка на 0..999 миллисекунд
                yield (); //так можно указать, что поток желает временно отдать
                //управление для выполнения других конкуррентных потоков
            } catch (InterruptedException e) {
                System.err.print(e.toString());
            }
            //это тело потока.
            System.out.println(this.getName() + "Цикл №" + 2);
            try {
                sleep((int) (Math.random() * 1000)); // остановка на 0..999 миллисекунд
                yield (); //так можно указать, что поток желает временно отдать
                //управление для выполнения других конкуррентных потоков
            } catch (InterruptedException e) {
                System.err.print(e.toString());
            }
            //это тело потока.
            System.out.println(this.getName() + "Цикл №" + 3);
            try {
                sleep((int) (Math.random() * 1000)); // остановка на 0..999 миллисекунд
                yield (); //так можно указать, что поток желает временно отдать
                //управление для выполнения других конкуррентных потоков
            } catch (InterruptedException e) {
                System.err.print(e.toString());
            }
            //это тело потока.
            System.out.println(this.getName() + "Цикл №" + 4);
            try {
                sleep((int) (Math.random() * 1000)); // остановка на 0..999 миллисекунд
                yield (); //так можно указать, что поток желает временно отдать
                //управление для выполнения других конкуррентных потоков
            } catch (InterruptedException e) {
                System.err.print(e.toString());
            }
            //это тело потока.
            System.out.println(this.getName() + "Цикл №" + 5);
            try {
                sleep((int) (Math.random() * 1000)); // остановка на 0..999 миллисекунд
                yield (); //так можно указать, что поток желает временно отдать
                //управление для выполнения других конкуррентных потоков
            } catch (InterruptedException e) {
                System.err.print(e.toString());
            }
            //это тело потока.
            System.out.println(this.getName() + "Цикл №" + 6);
            try {
                sleep((int) (Math.random() * 1000)); // остановка на 0..999 миллисекунд
                yield (); //так можно указать, что поток желает временно отдать
                //управление для выполнения других конкуррентных потоков
            } catch (InterruptedException e) {
                System.err.print(e.toString());
            }
            //это тело потока.
            System.out.println(this.getName() + "Цикл №" + 7);
            try {
                sleep((int) (Math.random() * 1000)); // остановка на 0..999 миллисекунд
                yield (); //так можно указать, что поток желает временно отдать
                //управление для выполнения других конкуррентных потоков
            } catch (InterruptedException e) {
                System.err.print(e.toString());
            }
            //это тело потока.
            System.out.println(this.getName() + "Цикл №" + 8);
            try {
                sleep((int) (Math.random() * 1000)); // остановка на 0..999 миллисекунд
                yield (); //так можно указать, что поток желает временно отдать
                //управление для выполнения других конкуррентных потоков
            } catch (InterruptedException e) {
                System.err.print(e.toString());
            }
            //это тело потока.
            System.out.println(this.getName() + "Цикл №" + 9);
            try {
                sleep((int) (Math.random() * 1000)); // остановка на 0..999 миллисекунд
                yield (); //так можно указать, что поток желает временно отдать
                //управление для выполнения других конкуррентных потоков
            } catch (InterruptedException e) {
                System.err.print(e.toString());
            }
        }

        MyThread(String name) { //конструктор потока передает
                                       // имя суперклассу
            super(name);
        }
    }

    public static void main(String[ ] args) {
        new MyThread("-Первый поток. ").start();
        new MyThread("--Второй поток. ").start();
    }

}
