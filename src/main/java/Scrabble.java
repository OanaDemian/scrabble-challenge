
public class Scrabble {
    private static String word;

    public Scrabble(String word) {
        this.word = word;
    }

    public static void main(String[] args) {

    }

    public static int score() {
        WordPlayed wordPlayed = new WordPlayed(Scrabble.word);
        return (wordPlayed.isNull() || wordPlayed.isEmptyWord()) ? 0 : wordPlayed.calculateWordScore(Scrabble.word);
    }

}
