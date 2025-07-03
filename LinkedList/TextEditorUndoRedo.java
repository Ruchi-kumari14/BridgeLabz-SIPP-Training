import java.util.Scanner;

class TextState {
    String content;
    TextState prev, next;

    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState head, tail, current;
    private int size;
    private final int MAX_SIZE = 10;

    public TextEditor() {
        head = tail = current = new TextState(""); // Initial empty state
        size = 1;
    }

    // Add new state after typing or editing
    public void type(String newContent) {
        TextState newState = new TextState(newContent);

        // Remove all redo states after current
        current.next = null;
        tail = current;

        // Add new state
        newState.prev = current;
        current.next = newState;
        current = newState;
        tail = newState;
        size++;

        // If size exceeds MAX_SIZE, remove oldest state (head)
        if (size > MAX_SIZE) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("Text updated.");
    }

    // Undo: go to previous state
    public void undo() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo: go to next state
    public void redo() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Display current state
    public void display() {
        System.out.println("Current Text: \"" + current.content + "\"");
    }
}

public class TextEditorUndoRedo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\n--- Text Editor ---");
            System.out.println("1. Type/Edit Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String newText = sc.nextLine();
                    editor.type(newText);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.display();
                    break;
                case 5:
                    System.out.println("Exiting editor.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
