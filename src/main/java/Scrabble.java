
public class Scrabble {
    private static String word;

    public Scrabble(String word) {
        this.word = word;
    }

    public static void main(String[] args) {
        Scrabble word = new Scrabble("a");
        System.out.println(Scrabble.score());
    }

    public static int score() {
        WordPlayed wordPlayed = new WordPlayed(Scrabble.word);
        if (wordPlayed.isNull() || wordPlayed.isEmptyWord()) return 0;
        return wordPlayed.calculateWordScore(Scrabble.word);
    }

}
