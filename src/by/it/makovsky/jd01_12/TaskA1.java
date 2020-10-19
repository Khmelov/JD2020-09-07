package by.it.makovsky.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private List<Integer> marks= new ArrayList<>();
    private void clearBad(List<Integer> grades){
        Iterator<Integer> itr=grades.iterator();
        while (itr.hasNext()){
            int grade= itr.next();
            if (grade<4){
                itr.remove();
            }
        }

    }
    public static void main(String[] args) {
        TaskA1 task=new TaskA1();
        for (int i = 0; i <= 25; i++) {
            task.marks.add((int) Math.ceil(Math.random()*10));
        }
        System.out.println(task.marks);
        task.clearBad(task.marks);
        System.out.println(task.marks);
    }
}
