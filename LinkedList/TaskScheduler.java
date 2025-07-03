import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskList {
    private Task head = null;
    private Task current = null;

    // Add task at beginning
    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
        System.out.println("Task added at beginning.");
    }

    // Add task at end
    public void addAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
        System.out.println("Task added at end.");
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos < 1) {
            System.out.println("Invalid position.");
            return;
        }
        if (pos == 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newTask.next = temp.next;
        temp.next = newTask;
        System.out.println("Task added at position " + pos);
    }

    // Remove task by ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        Task temp = head, prev = null;

        // Case: head is to be deleted
        if (head.taskId == id) {
            if (head.next == head) { // Only one task
                head = null;
                current = null;
            } else {
                Task last = head;
                while (last.next != head) {
                    last = last.next;
                }
                head = head.next;
                last.next = head;
                if (current.taskId == id) current = head;
            }
            System.out.println("Task with ID " + id + " removed.");
            return;
        }

        do {
            prev = temp;
            temp = temp.next;
        } while (temp != head && temp.taskId != id);

        if (temp.taskId == id) {
            prev.next = temp.next;
            if (current.taskId == id) current = prev.next;
            System.out.println("Task with ID " + id + " removed.");
        } else {
            System.out.println("Task ID not found.");
        }
    }

    // View current task and move to next
    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Current Task:");
        displayTask(current);
        current = current.next;
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        boolean found = false;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }

    // Display task details
    private void displayTask(Task task) {
        System.out.println("Task ID: " + task.taskId + ", Name: " + task.taskName +
                ", Priority: " + task.priority + ", Due Date: " + task.dueDate);
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularTaskList taskList = new CircularTaskList();

        while (true) {
            System.out.println("\n--- Task Scheduler ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task & Move Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            int id, pos, priority;
            String name, dueDate;

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID, Name, Priority, Due Date: ");
                    id = sc.nextInt();
                    name = sc.next();
                    priority = sc.nextInt();
                    dueDate = sc.next();
                    taskList.addAtBeginning(id, name, priority, dueDate);
                    break;

                case 2:
                    System.out.print("Enter Task ID, Name, Priority, Due Date: ");
                    id = sc.nextInt();
                    name = sc.next();
                    priority = sc.nextInt();
                    dueDate = sc.next();
                    taskList.addAtEnd(id, name, priority, dueDate);
                    break;

                case 3:
                    System.out.print("Enter Position, Task ID, Name, Priority, Due Date: ");
                    pos = sc.nextInt();
                    id = sc.nextInt();
                    name = sc.next();
                    priority = sc.nextInt();
                    dueDate = sc.next();
                    taskList.addAtPosition(pos, id, name, priority, dueDate);
                    break;

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    id = sc.nextInt();
                    taskList.removeById(id);
                    break;

                case 5:
                    taskList.viewCurrentTask();
                    break;

                case 6:
                    taskList.displayAllTasks();
                    break;

                case 7:
                    System.out.print("Enter Priority to search: ");
                    priority = sc.nextInt();
                    taskList.searchByPriority(priority);
                    break;

                case 8:
                    sc.close();
                    System.out.println("Exiting Task Scheduler...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
