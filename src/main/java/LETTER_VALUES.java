public enum LETTER_VALUES {
    a(1), b(3);

    private int letterVal;

    LETTER_VALUES(int letterVal) {
        this.letterVal = letterVal;
    }

    public int getLetterVal() {
        return letterVal;
    }
}