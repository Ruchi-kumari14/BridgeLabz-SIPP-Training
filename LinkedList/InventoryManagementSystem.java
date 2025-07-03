import java.util.Scanner;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head = null;

    // Add at beginning
    public void addAtBeginning(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
        System.out.println("Item added at beginning.");
    }

    // Add at end
    public void addAtEnd(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newItem;
        }
        System.out.println("Item added at end.");
    }

    // Add at position (1-based index)
    public void addAtPosition(int position, String name, int id, int quantity, double price) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (position == 1) {
            addAtBeginning(name, id, quantity, price);
            return;
        }

        Item newItem = new Item(name, id, quantity, price);
        Item temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position exceeds list length. Item not added.");
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
            System.out.println("Item added at position " + position);
        }
    }

    // Remove item by ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item with ID " + id + " removed.");
            return;
        }

        Item temp = head, prev = null;
        while (temp != null && temp.itemId != id) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Item ID not found.");
        } else {
            prev.next = temp.next;
            System.out.println("Item with ID " + id + " removed.");
        }
    }

    // Update quantity
    public void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item ID not found.");
    }

    // Search by ID or Name
    public void search(String key) {
        boolean found = false;
        Item temp = head;
        while (temp != null) {
            if (String.valueOf(temp.itemId).equals(key) || temp.itemName.equalsIgnoreCase(key)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found.");
    }

    // Total Inventory Value
    public void totalInventoryValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.printf("Total Inventory Value: ₹%.2f\n", total);
    }

    // Display all items
    public void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\n--- Inventory Items ---");
        Item temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    // Display single item
    private void displayItem(Item item) {
        System.out.printf("ID: %d | Name: %s | Qty: %d | Price: ₹%.2f\n",
                item.itemId, item.itemName, item.quantity, item.price);
    }

    // Merge Sort wrapper
    public void sortInventory(String criteria, boolean ascending) {
        head = mergeSort(head, criteria, ascending);
        System.out.println("Inventory sorted by " + criteria + " in " +
                (ascending ? "ascending" : "descending") + " order.");
    }

    // Merge sort on linked list
    private Item mergeSort(Item head, String criteria, boolean asc) {
        if (head == null || head.next == null) return head;

        Item middle = getMiddle(head);
        Item nextToMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, criteria, asc);
        Item right = mergeSort(nextToMiddle, criteria, asc);

        return mergeSortedLists(left, right, criteria, asc);
    }

    // Get middle node
    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted lists
    private Item mergeSortedLists(Item a, Item b, String criteria, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (criteria.equalsIgnoreCase("name")) {
            condition = asc ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                            : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }

        if (condition) {
            a.next = mergeSortedLists(a.next, b, criteria, asc);
            return a;
        } else {
            b.next = mergeSortedLists(a, b.next, criteria, asc);
            return b;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Add Item (Beginning)");
            System.out.println("2. Add Item (End)");
            System.out.println("3. Add Item (Position)");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search Item (ID or Name)");
            System.out.println("7. Display All Items");
            System.out.println("8. Total Inventory Value");
            System.out.println("9. Sort Inventory (Name/Price)");
            System.out.println("10. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            int id, qty, pos;
            double price;
            String name;

            switch (choice) {
                case 1:
                    System.out.print("Enter Name, ID, Quantity, Price: ");
                    name = sc.next();
                    id = sc.nextInt();
                    qty = sc.nextInt();
                    price = sc.nextDouble();
                    inventory.addAtBeginning(name, id, qty, price);
                    break;

                case 2:
                    System.out.print("Enter Name, ID, Quantity, Price: ");
                    name = sc.next();
                    id = sc.nextInt();
                    qty = sc.nextInt();
                    price = sc.nextDouble();
                    inventory.addAtEnd(name, id, qty, price);
                    break;

                case 3:
                    System.out.print("Enter Position, Name, ID, Quantity, Price: ");
                    pos = sc.nextInt();
                    name = sc.next();
                    id = sc.nextInt();
                    qty = sc.nextInt();
                    price = sc.nextDouble();
                    inventory.addAtPosition(pos, name, id, qty, price);
                    break;

                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    id = sc.nextInt();
                    inventory.removeById(id);
                    break;

                case 5:
                    System.out.print("Enter Item ID and new quantity: ");
                    id = sc.nextInt();
                    qty = sc.nextInt();
                    inventory.updateQuantity(id, qty);
                    break;

                case 6:
                    System.out.print("Enter Item ID or Name to search: ");
                    name = sc.next();
                    inventory.search(name);
                    break;

                case 7:
                    inventory.displayAll();
                    break;

                case 8:
                    inventory.totalInventoryValue();
                    break;

                case 9:
                    System.out.print("Sort by (name/price): ");
                    String by = sc.next();
                    System.out.print("Ascending (true/false)? ");
                    boolean asc = sc.nextBoolean();
                    inventory.sortInventory(by, asc);
                    break;

                case 10:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
