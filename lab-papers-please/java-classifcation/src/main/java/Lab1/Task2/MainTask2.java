package Task2;

public class MainTask2 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the file path as an argument.");
            return;
        }

        String filePath = args[0];
        FileReader fileReader = new FileReader();
        String fileContent = fileReader.readFileIntoString(filePath);

        TextData textData = new TextData(filePath, fileContent);

        System.out.println("File Name: " + textData.getFilename());
        System.out.println("Text: " + textData.getText());
        System.out.println("Number of Vowels: " + textData.getNumberOfVowels());
        System.out.println("Number of Consonants: " + textData.getNumberOfConsonants());
        System.out.println("Number of Letters: " + textData.getNumberOfLetters());
        System.out.println("Number of Sentences: " + textData.getNumberOfSentences());
        System.out.println("Longest Word: " + textData.getLongestWord());
    }
}
