import java.util.Arrays;

public class Turn {
    private final String wordPlayed;
    private final Character[] doubleLetters;
    private final Character[] tripleLetters;
    private final boolean doubleWord;
    private final boolean tripleWord;
    private int finalScore;

    public Turn(String wordPlayed) {
        this.wordPlayed = wordPlayed;
        this.doubleLetters = new Character[0];
        this.tripleLetters = new Character[0];
        this.doubleWord = false;
        this.tripleWord = false;
        this.finalScore = 0;
    }

    public Turn (String wordPlayed, Character[] doubleLetters, Character[] tripleLetters, boolean doubleWord, boolean tripleWord) {
        this.wordPlayed = wordPlayed;
        this.doubleLetters = doubleLetters;
        this.tripleLetters = tripleLetters;
        this.doubleWord = doubleWord;
        this.tripleWord = tripleWord;
        this.finalScore = 0;
    }

    public char [] wordToLowerCaseLettersArray (String word){
        return (word.toLowerCase()).toCharArray();
    }
    public int calculateWordScore (String word) {
        if (isNull() || isEmptyWord()) return 0;
        calculateSimpleWordScore(word);
        premiumLettersScore();
        premiumWordScore ();
        return this.finalScore;
    }
    public void premiumWordScore () {
        if (this.isDoubleWord()) this.finalScore *= 2;
        if (this.isTripleWord()) this.finalScore *= 3;
    }
    public void calculateSimpleWordScore(String word) {
        for (char letter : wordToLowerCaseLettersArray(word)) {
            this.finalScore += calculateLetterScore(letter);
        }
    }
    public void premiumLettersScore() {
        for (char doubleLetter : getDoubleLetters()) {
            this.finalScore += calculateLetterScore(doubleLetter);
        }
        for (char tripleLetter : getTripleLetters()) {
            this.finalScore += 2 * calculateLetterScore(tripleLetter);
        }
    }
    public int calculateLetterScore (char letter) {
        if (isLetterValid(letter)) return getLetterScore(letter);
        return 0;
    }
    public int getLetterScore (char letter) {
        return LetterValues.getLetterPoints().get(String.valueOf(letter));
    }
    public char[] getDoubleLetters () {
        String dLettersStr = Arrays.toString(this.doubleLetters);
        return dLettersStr.toLowerCase().toCharArray();
    }

    public char[] getTripleLetters () {
        String tLettersStr = Arrays.toString(this.tripleLetters);
        return tLettersStr.toLowerCase().toCharArray();
    }

    public boolean isDoubleWord() {
        return this.doubleWord;
    }
    public boolean isTripleWord() {
        return this.tripleWord;
    }
    public boolean isLetterValid(char letter) {
        return LetterValues.getLetterPoints().containsKey(String.valueOf(letter));
    }
    public boolean isEmptyWord () {
        return (this.wordPlayed.equals(""));
    }
    public boolean isNull () {
        return (this.wordPlayed == null);
    }
}

