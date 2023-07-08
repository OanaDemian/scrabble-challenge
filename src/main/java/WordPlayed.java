public class WordPlayed {
    private String wordPlayed;
    private Character[] firstL;
    private Character[] secondL;
    private boolean doubleWord;
    private boolean tripleWord;
    private int finalScore;

    public WordPlayed(String wordPlayed) {
        this.wordPlayed = wordPlayed;
        this.finalScore = 0;
    }

    public WordPlayed(String wordPlayed, Character[] firstL, Character[] secondL, boolean doubleWord, boolean tripleWord) {
        this.wordPlayed = wordPlayed;
        this.firstL = firstL;
        this.secondL = secondL;
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
        if (this.isDoubleWord(word)) { this.finalScore *= 2;};
        if (this.isTripleWord(word)) { this.finalScore *= 3;};
        return this.finalScore;
    }
    public int calculateLetterScore (char letter) {
        return isLetterValid(letter) ? getLetterScore (letter) : 0;
    }

    public int getLetterScore (char letter) {
        return LetterValues.getLetterPoints().get(String.valueOf(letter));
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

