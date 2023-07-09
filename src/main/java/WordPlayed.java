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
        if (this.isDoubleWord(word)) { this.finalScore *= 2;};
        if (this.isTripleWord(word)) { this.finalScore *= 3;};
        return this.finalScore;
    }

    public static char[] removeArrayElement(char[] arr, int index)
    {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || index < 0
                || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        char[] anotherArray = new char[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
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

//    public int premiumLetterScore(String word) {
//        for (char letter : wordToLowerCaseLettersArray(word)) {
//            for (char doubleLetter : getDoubleLetters()) {
//                if (letter == doubleLetter) {
//
//                }
//            }
//        }
//    }

//    public boolean isTripleLetter (char letter) {
//        char [] arr = this.wordPlayed.toCharArray();
//        String str = String.valueOf(letterToLowerCase(letter));
//        for (char c : arr) {
//            if (c==letter) { return this.tripleLetters.toString().contains(str);}
//        }
//        return false;
//    }
    public boolean isDoubleWord(String word) {
        return this.doubleWord;
    }
    public boolean isTripleWord(String word) {
        return this.tripleWord;
    }

    public char letterToLowerCase(char letter) {
        String str = String.valueOf(letter).toLowerCase();
        letter = str.charAt(0);
        return letter;
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

