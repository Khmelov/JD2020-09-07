package by.it.hryntsaliou.jd01_01;

class Args {
    String[] args;

    Args(String[] args) {
        this.args = args;
    }

    void printargs() {
        int i = 0;
        for (String arg : args) {
            i = i + 1;
            System.out.println("Argument " + i + "=" + arg);
        }
    }
}
