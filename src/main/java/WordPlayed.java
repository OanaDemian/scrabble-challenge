public class WordPlayed {
    private final String wordPlayed;
    int finalScore;

    public WordPlayed(String wordPlayed) {
        this.wordPlayed = wordPlayed;
        this.finalScore = 0;
    }

    public char [] wordToLettersArray (String word){
        return word.toCharArray();
    }
    public int calculateWordScore (String word) {
        for (char letter : wordToLettersArray(word)) {
            this.finalScore += calculateLetterScore(letter);
        }
        return this.finalScore;
    }
    public int calculateLetterScore (char letter) {
        int letterScore = 0;
        int letterValue = getLetterScore(letter);
        letterScore = isLetterValid(letter) ? letterScore += getLetterScore (letter) : letterScore;
        return letterScore;
    }

    public int getLetterScore (char letter) {
        LetterValues letterValues = new LetterValues();
        int letterScore = letterValues.getLetterPoints().get(String.valueOf(letter));
        return letterScore;
    }
    public boolean isLetterValid(char letter) {
        LetterValues letterValues = new LetterValues();
        boolean validLetter = letterValues.getLetterPoints().containsKey(String.valueOf(letter));
        return validLetter;
    }
    public boolean isEmptyWord () {
        return (this.wordPlayed == "");
    }

    public boolean isNull () {
        return (this.wordPlayed == null);
    }
}

