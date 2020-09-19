package by.it.kulik.jd01_06;

public class TaskB1 {

    public static void main(String[] args) {
        String letters = "ЙЦКНГШЩЗХЪФВПРЛДЖЧСМТЬБйцкнгшщзхъфвпрлджчсмтьб";
        String letters2 = "ЁёУуЕеЫыАаОоЯяИиЮюЭэ";
        String text = Poem.text;
        text = text.trim();
        for (String word : text.split(" ")) {
            if (letters.contains(word.substring(0, 1)))
                {

                    System.out.println(word);
                }

        }

    }
}