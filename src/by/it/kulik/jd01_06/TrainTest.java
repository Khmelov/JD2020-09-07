package by.it.kulik.jd01_06;

public class TrainTest {
    public static void main(String[] args) {
        String [] arr={"one", "no one", "","u","A cook","a any o","o O "};
        String str;
        for (String s:arr) {
            str=n(s);
            System.out.println("Result of n(" +s+ "):" + str + " ");
        }
    }


    static char[] chars = "aeiou".toCharArray();
    static String n(String s) {

        StringBuilder sb = new StringBuilder();
        boolean start = true, word = false;
        char[] schars = s.toCharArray();
        char c;
        for (int i = 0; i <= schars.length; i++) {

            c = i < schars.length ? Character.toLowerCase(schars[i]) : ' ';
            if (Character.isWhitespace(c)) {

                if (word) {

                    sb.append(' ');
                    word = false;
                }

                start = true;
            }
            else if (start) {

                start = false;
                for (char ch : chars) {

                    if (c == ch) {

                        word = true;
                        break;
                    }
                }
            }


            if (word) {

                sb.append(schars[i]);
            }
        }

        return sb.toString().trim();
    }
}
