package by.it.kulik.jd01_06;

public class TaskB1 {
private static String[] glasnye= {"А,а,и,И,У,у,Е,е,э,Э,О,о,Ю,ю,Я,я"};
    private static String[] soglasnye= {"Й,й,ц,Ц,к,К,Н,н,Г,г,Ш,ш,Щ,щ,З,з,Х,х," +
            "Ф,ф,в,В,П,п,Р,р,Л,л,Д,д,Ж,ж,ч,Ч,С,с,М,м,Т,т,Ь,ь,Б,б"};
    public static void main(String[] args) {
        String letters = "Й Ц К Н Г Ш Щ З Х Ъ Ф В П Р Л Д Ж Ч С М Т Ь Б й " +
                "ц к н г ш щ з х ъ ф в п р л д ж ч с м т ь б";
        String letters2 = "ЁёУуЕеЫыАаОоЯяИиЮюЭэ";
        String text = Poem.text;
        text = text.trim();
        String[] words = text.split(" ");


    }
}