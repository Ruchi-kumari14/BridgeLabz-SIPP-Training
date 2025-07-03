import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head;

    // Add new user
    public void addUser(int id, String name, int age) {
        if (findUserById(id) != null) {
            System.out.println("User ID already exists.");
            return;
        }

        User newUser = new User(id, name, age);
        newUser.next = head;
        head = newUser;
        System.out.println("User " + name + " added.");
    }

    // Search user by ID
    public User findUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search user by name
    public void searchByName(String name) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + temp.name + " (ID: " + temp.userId + ")");
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("User not found.");
    }

    // Add a friend connection (bi-directional)
    public void addFriend(int id1, int id2) {
        if (id1 == id2) {
            System.out.println("Cannot friend yourself.");
            return;
        }

        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIds.contains(id2)) user1.friendIds.add(id2);
        if (!user2.friendIds.contains(id1)) user2.friendIds.add(id1);

        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    // Remove friend connection
    public void removeFriend(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.friendIds.remove(Integer.valueOf(id2));
        user2.friendIds.remove(Integer.valueOf(id1));
        System.out.println("Friend connection removed.");
    }

    // Display all friends of a user
    public void displayFriends(int id) {
        User user = findUserById(id);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        if (user.friendIds.isEmpty()) {
            System.out.println("No friends yet.");
            return;
        }

        for (int friendId : user.friendIds) {
            User friend = findUserById(friendId);
            if (friend != null) {
                System.out.println("→ " + friend.name + " (ID: " + friend.userId + ")");
            }
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        Set<Integer> mutual = new HashSet<>(user1.friendIds);
        mutual.retainAll(user2.friendIds);

        if (mutual.isEmpty()) {
            System.out.println("No mutual friends.");
        } else {
            System.out.println("Mutual friends of " + user1.name + " and " + user2.name + ":");
            for (int fid : mutual) {
                User mutualFriend = findUserById(fid);
                if (mutualFriend != null)
                    System.out.println("→ " + mutualFriend.name + " (ID: " + mutualFriend.userId + ")");
            }
        }
    }

    // Count number of friends for each user
    public void countAllFriends() {
        User temp = head;
        System.out.println("Friend count for each user:");
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }

    // Display all users
    public void displayAllUsers() {
        User temp = head;
        System.out.println("--- All Users ---");
        while (temp != null) {
            System.out.println("ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}

public class SocialMediaConnections {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display Friends");
            System.out.println("5. Find Mutual Friends");
            System.out.println("6. Search User by Name");
            System.out.println("7. Count Friends for All Users");
            System.out.println("8. Display All Users");
            System.out.println("9. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Age: ");
                    int id = sc.nextInt();
                    String name = sc.next();
                    int age = sc.nextInt();
                    sm.addUser(id, name, age);
                    break;
                case 2:
                    System.out.print("Enter User1 ID and User2 ID: ");
                    sm.addFriend(sc.nextInt(), sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter User1 ID and User2 ID to remove connection: ");
                    sm.removeFriend(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter User ID to view friends: ");
                    sm.displayFriends(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter two User IDs to find mutual friends: ");
                    sm.findMutualFriends(sc.nextInt(), sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter name to search: ");
                    sm.searchByName(sc.next());
                    break;
                case 7:
                    sm.countAllFriends();
                    break;
                case 8:
                    sm.displayAllUsers();
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
