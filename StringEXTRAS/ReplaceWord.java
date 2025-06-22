import java.util.Scanner;

public class ReplaceWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the sentence: ");
        String sentence = scanner.nextLine();

        System.out.print("Enter the word to replace: ");
        String oldWord = scanner.nextLine();

        System.out.print("Enter the replacement word: ");
        String newWord = scanner.nextLine();

        String result = replaceWord(sentence, oldWord, newWord);
        System.out.println("Modified sentence: " + result);

        scanner.close();
    }

    public static String replaceWord(String sentence, String oldWord, String newWord) {
        StringBuilder result = new StringBuilder();

        String[] words = sentence.split("\\b");

        for (String word : words) {
            if (word.equals(oldWord)) {
                result.append(newWord);
            } else {
                result.append(word);
            }
        }

        return result.toString();
    }
}
