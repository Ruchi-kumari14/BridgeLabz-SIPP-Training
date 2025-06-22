import java.util.Scanner;

class MostFrequentCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int[] freq = new int[256]; 

        for (int i = 0; i < input.length(); i++) {
            freq[input.charAt(i)]++;
        }

        int maxFreq = 0;
        char mostFrequentChar = ' ';

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                mostFrequentChar = (char) i;
            }
        }

        System.out.println("Most Frequent Character: '" + mostFrequentChar + "'");

        scanner.close();
    }
}
