import java.util.Scanner;

public class LexicographicalCompare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        int len1 = str1.length();
        int len2 = str2.length();
        int minLen = Math.min(len1, len2);
        boolean areEqual = true;

        for (int i = 0; i < minLen; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if (ch1 != ch2) {
                areEqual = false;
                if (ch1 < ch2) {
                    System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
                } else {
                    System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order");
                }
                break;
            }
        }

        if (areEqual) {
            if (len1 == len2) {
                System.out.println("Both strings are equal.");
            } else if (len1 < len2) {
                System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
            } else {
                System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order");
            }
        }

        scanner.close();
    }
}
