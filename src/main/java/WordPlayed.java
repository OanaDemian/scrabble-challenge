public class WordPlayed {
    private final String wordPlayed;
    int finalScore;

    public WordPlayed(String wordPlayed) {
        this.wordPlayed = wordPlayed;
        this.finalScore = 0;
    }
    public boolean isEmptyWord () {
        return (this.wordPlayed == "");
    }

    public boolean isNull () {
        return (this.wordPlayed == null);
    }
}

