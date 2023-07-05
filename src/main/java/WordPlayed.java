public class WordPlayed {
    private final String wordPlayed;
    int finalScore;

    public WordPlayed(String wordPlayed) {
        this.wordPlayed = wordPlayed;
        this.finalScore = 0;
    }

    public char [] wordToLowerCaseLettersArray (String word){
        return (word.toLowerCase()).toCharArray();
    }
    public int calculateWordScore (String word) {
        for (char letter : wordToLowerCaseLettersArray(word)) {
            this.finalScore += calculateLetterScore(letter);
        }
        return this.finalScore;
    }
    public int calculateLetterScore (char letter) {
        return isLetterValid(letter) ? getLetterScore (letter) : 0;
    }

    public int getLetterScore (char letter) {
        return LetterValues.getLetterPoints().get(String.valueOf(letter));
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

