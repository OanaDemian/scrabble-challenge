
public class Scrabble {
    protected String word;

    public Scrabble(String wordToScore) {
        this.word = wordToScore;
    }

    public static void main(String[] args) {

    }

    public int score() {
        WordPlayed wordPlayed = new WordPlayed(this.word);
        return (wordPlayed.isNull() || wordPlayed.isEmptyWord()) ? 0 : wordPlayed.calculateWordScore(this.word);
    }

}
