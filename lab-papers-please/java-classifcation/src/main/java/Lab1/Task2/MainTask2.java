package Lab1.Task2;

public class MainTask2 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide at least one file path as an argument.");
            return;
        }

        FileReader fileReader = new FileReader();

        for (String filePath : args) {
            System.out.println("\nProcessing file: " + filePath);
            String fileContent = fileReader.readFileIntoString(filePath);

            if (fileContent.isEmpty()) {
                System.out.println("Unable to read content from " + filePath);
                continue;
            }

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
}
