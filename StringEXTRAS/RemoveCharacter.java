import java.util.Scanner;

class RemoveCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = scanner.nextLine();

        System.out.print("Enter the character to remove: ");
        char charToRemove = scanner.nextLine().charAt(0);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch != charToRemove) {
                result.append(ch);
            }
        }

        System.out.println("Modified String: " + result.toString());

        scanner.close();
    }
}
