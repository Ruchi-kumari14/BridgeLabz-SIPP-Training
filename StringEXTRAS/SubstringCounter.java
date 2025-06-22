import java.util.Scanner;

public class SubstringCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String mainString = scanner.nextLine();

        System.out.print("Enter the substring to search: ");
        String subString = scanner.nextLine();

        int count = 0;
        int index = 0;

        while ((index = mainString.indexOf(subString, index)) != -1) {
            count++;
            index += subString.length(); // Move past the last found substring
        }

        System.out.println("The substring '" + subString + "' occurs " + count + " time(s).");

        scanner.close();
    }
}
