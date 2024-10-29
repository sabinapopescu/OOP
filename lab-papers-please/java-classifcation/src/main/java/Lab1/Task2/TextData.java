package Task2;

public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String fileName, String text) {
        this.fileName = fileName;
        this.text = text;
        calculateAttributes();
    }

    private void calculateAttributes() {
        numberOfVowels = countVowels(text);
        numberOfConsonants = countConsonants(text);
        numberOfLetters = text.replaceAll("[^a-zA-Z]", "").length();
        numberOfSentences = text.split("[.!?]").length;
        longestWord = findLongestWord(text);
    }

    private int countVowels(String text) {
        return text.replaceAll("[^AEIOUaeiou]", "").length();
    }

    private int countConsonants(String text) {
        return text.replaceAll("[^BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz]", "").length();
    }

    private String findLongestWord(String text) {
        String[] words = text.split("\\W+");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public String getFilename() { return fileName; }
    public String getText() { return text; }
    public int getNumberOfVowels() { return numberOfVowels; }
    public int getNumberOfConsonants() { return numberOfConsonants; }
    public int getNumberOfLetters() { return numberOfLetters; }
    public int getNumberOfSentences() { return numberOfSentences; }
    public String getLongestWord() { return longestWord; }
}
