import java.lang.reflect.Constructor;

public class Scrabble {
    private static String word;
    private static Character[] doubleLetters;
    private static Character[] tripleLetters;
    private static boolean doubleWord;
    private static boolean tripleWord;

    private boolean justWord;

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
//        Scrabble scrabble = new Scrabble("quirky", new Character[]{}, new Character[]{}, true, false);
//        WordPlayed wordPlayed1 = new WordPlayed("quirky", new Character[]{}, new Character[]{}, true, false);
//        System.out.println(wordPlayed.isDoubleWord("quirky"));
//        System.out.println(wordPlayed.calculateWordScore("quirky"));
//        System.out.println(scrabble.score());

    }

    public int score() {
        WordPlayed wordPlayed1 = new WordPlayed(this.word);
        WordPlayed wordPlayed2 = new WordPlayed(this.word, this.doubleLetters, this.tripleLetters, this.doubleWord, this.tripleWord);
        if (this.justWord) {
            return wordPlayed1.calculateWordScore(this.word);
        }
        return wordPlayed2.calculateWordScore(this.word);
    }


}

