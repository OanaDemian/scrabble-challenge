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
        LetterValues letterValues = new LetterValues();
        if (letterValues.getLetterPoints().containsKey(String.valueOf(letter))) letterScore += letterValues.getLetterPoints().get(String.valueOf(letter));
        return letterScore;
    }

    public boolean isEmptyWord () {
        return (this.wordPlayed == "");
    }

    public boolean isNull () {
        return (this.wordPlayed == null);
    }
}

