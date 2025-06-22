import java.util.Scanner;
class AnagramCheck {

       public  static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine().replaceAll("\\s+", "").toLowerCase();

        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine().replaceAll("\\s+", "").toLowerCase();

        if (areAnagrams(str1, str2)) {
            System.out.println("The two strings are anagrams.");
        } else {
            System.out.println("The two strings are NOT anagrams.");
        }

        scanner.close();
    }

    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] charCount = new int[256]; // For ASCII chars

        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i)]++;
            charCount[s2.charAt(i)]--;
        }

        for (int count : charCount) {
            if (count != 0) return false;
        }

        return true;
    }
}
