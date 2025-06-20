import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        String input = getInput("Enter a string to check if it is a palindrome: ");
        boolean isPalindrome = checkPalindrome(input);
        displayResult(input, isPalindrome);
    }

    public static String getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static boolean checkPalindrome(String str) {
        
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void displayResult(String original, boolean result) {
        if (result) {
            System.out.println("\"" + original + "\" is a palindrome.");
        } else {
            System.out.println("\"" + original + "\" is NOT a palindrome.");
        }
    }
}
