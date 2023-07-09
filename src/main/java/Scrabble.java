public class Scrabble {
    private final String word;
    private Character[] doubleLetters;
    private Character[] tripleLetters;
    private boolean doubleWord;
    private boolean tripleWord;
    protected boolean justWord;

    public Scrabble(String wordToScore) {
        this.word = wordToScore;
        this.justWord = true;
    }

    public Scrabble(String word, Character[] doubleLetters, Character[] tripleLetters, boolean doubleWord, boolean tripleWord) {
        this.word = word;
        this.doubleLetters = doubleLetters;
        this.tripleLetters = tripleLetters;
        this.doubleWord = doubleWord;
        this.tripleWord = tripleWord;
        this.justWord = false;
    }

    public static void main(String[] args) {
    }
    public int score() {
        Turn player1 = new Turn(this.word);
        Turn player2 = new Turn(this.word, this.doubleLetters, this.tripleLetters, this.doubleWord, this.tripleWord);
        if (this.justWord) {
            return player1.calculateWordScore(this.word);
        }
        return player2.calculateWordScore(this.word);
    }


}

