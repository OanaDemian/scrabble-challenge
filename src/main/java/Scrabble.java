public class Scrabble {
    private static String word = "";
    public Scrabble (String word) {
        this.word = word;
    }
    public static void main(String[] args) {
        Scrabble.score();
    }
    public static int score() {
        if (Scrabble.isEmptyWord()) return 0;
        return 4;
    }
    public static boolean isEmptyWord () {
        return (Scrabble.word == "");
    }
}
