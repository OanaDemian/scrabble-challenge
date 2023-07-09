import java.util.Arrays;

public class WordPlayed {
    private String wordPlayed;
    private Character[] doubleLetters;
    private Character[] tripleLetters;
    private boolean doubleWord;
    private boolean tripleWord;
    private int finalScore;

    public WordPlayed(String wordPlayed) {
        this.wordPlayed = wordPlayed;
        this.doubleLetters = new Character[0];
        this.tripleLetters = new Character[0];
        this.doubleWord = false;
        this.tripleWord = false;
        this.finalScore = 0;
    }

    public WordPlayed(String wordPlayed, Character[] doubleLetters, Character[] tripleLetters, boolean doubleWord, boolean tripleWord) {
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
        if (isNull() || isEmptyWord()) {
            return 0;
        }
        for (char letter : wordToLowerCaseLettersArray(word)) {
            this.finalScore += calculateLetterScore(letter);
        }

        for (char doubleLetter : getDoubleLetters()) {
            this.finalScore += calculateLetterScore(doubleLetter);
        }

        for (char tripleLetter : getTripleLetters()) {
            this.finalScore += 2 * calculateLetterScore(tripleLetter);
        }
        if (this.isDoubleWord(word)) { this.finalScore *= 2;};
        if (this.isTripleWord(word)) { this.finalScore *= 3;};
        return this.finalScore;
    }
    public int calculateLetterScore (char letter) {
        if (isLetterValid(letter)) {return getLetterScore(letter);};
        return 0;
    }
    public int getLetterScore (char letter) {
        return LetterValues.getLetterPoints().get(String.valueOf(letter));
    }
    public char[] getDoubleLetters () {
        String dLettersStr = Arrays.toString(this.doubleLetters);
        char[] dLettersArr = dLettersStr.toLowerCase().toCharArray();
        return dLettersArr;
    }

    public char[] getTripleLetters () {
        String tLettersStr = Arrays.toString(this.tripleLetters);
        char[] tLettersArr = tLettersStr.toLowerCase().toCharArray();
        return tLettersArr;
    }

    public boolean isDoubleWord(String word) {
        return this.doubleWord;
    }
    public boolean isTripleWord(String word) {
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

