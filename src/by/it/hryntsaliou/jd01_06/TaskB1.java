package by.it.hryntsaliou.jd01_06;

class TaskB1 {
    public static void main(String[] args) {
        char[] letters = {'а', 'е', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я', 'ё'};
        char[] lettersSogl = {'й', 'ц', 'к', 'н', 'г', 'ш', 'щ', 'з', 'х', 'ф', 'в', 'п', 'р', 'л', 'д', 'ж',
                'ч', 'с', 'м', 'т', 'б', 'Й', 'Ц', 'К', 'Н', 'Г', 'Ш', 'Щ', 'З',
                'Х', 'Ф', 'В', 'П', 'Р', 'Л', 'Д', 'Ж', 'Ч', 'С', 'М', 'Т', 'Б'};
        String poem = Poem.text;
        String[] words = poem.split("[\\p{Punct} \\t\\n\\r]");
        result(words, letters, lettersSogl);
    }

    private static void result(String[] words, char[] letters, char[] lettersSogl) {
        for (int i = 0; i < words.length; i++) {
            for (char letter : lettersSogl) {
                if (words[i].length() > 0) {
                    if (words[i].charAt(0) == letter) {
                        for (char letter2 : letters) {
                            if (words[i].charAt(words[i].length() - 1) == letter2) {
                                System.out.println(words[i]);
                            }
                        }
                    }
                }
            }
        }
    }
}
