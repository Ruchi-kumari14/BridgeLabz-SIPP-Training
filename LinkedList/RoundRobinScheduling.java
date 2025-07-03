import java.util.*;

class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnAroundTime = 0;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
        System.out.println("Process P" + pid + " added.");
    }

    private Process removeProcess(Process prev, Process current) {
        System.out.println("Process P" + current.pid + " completed.");
        if (current == head && current == tail) {
            head = tail = null;
            return null;
        }

        if (current == head) {
            head = head.next;
            tail.next = head;
            return head;
        }

        if (current == tail) {
            tail = prev;
            tail.next = head;
            return head;
        }

        prev.next = current.next;
        return current.next;
    }

    public void simulate() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0;
        Process current = head, prev = tail;

        System.out.println("\n--- Starting Round Robin Scheduling ---");
        while (head != null) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(current.remainingTime, timeQuantum);
                System.out.println("Time " + time + ": Executing P" + current.pid + " for " + execTime + " units.");
                current.remainingTime -= execTime;
                time += execTime;

                Process temp = head;
                do {
                    if (temp != current && temp.remainingTime > 0) {
                        temp.waitingTime += execTime;
                    }
                    temp = temp.next;
                } while (temp != head);

                if (current.remainingTime == 0) {
                    current.turnAroundTime = time;
                    current = removeProcess(prev, current);
                    if (current == null) break;
                    continue;
                }
            }

            prev = current;
            current = current.next;
            displayProcesses();
        }

        printStatistics(time);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("Process Queue is empty.");
            return;
        }

        System.out.println("Current Process Queue:");
        Process temp = head;
        do {
            System.out.printf("P%d [BT: %d, RT: %d] → ", temp.pid, temp.burstTime, temp.remainingTime);
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    private void printStatistics(int totalTime) {
        int totalWT = 0, totalTAT = 0, count = 0;
        Process temp = head;
        if (temp == null) return;

        System.out.println("\n--- Final Statistics ---");
        do {
            System.out.printf("P%d: Waiting Time = %d, Turnaround Time = %d\n",
                    temp.pid, temp.waitingTime, temp.turnAroundTime);
            totalWT += temp.waitingTime;
            totalTAT += temp.turnAroundTime;
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.printf("\nAverage Waiting Time: %.2f\n", (float) totalWT / count);
        System.out.printf("Average Turnaround Time: %.2f\n", (float) totalTAT / count);
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Time Quantum: ");
        int tq = sc.nextInt();

        RoundRobinScheduler scheduler = new RoundRobinScheduler(tq);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Process");
            System.out.println("2. Display Queue");
            System.out.println("3. Simulate Scheduling");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter PID, Burst Time, Priority: ");
                    int pid = sc.nextInt();
                    int bt = sc.nextInt();
                    int prio = sc.nextInt();
                    scheduler.addProcess(pid, bt, prio);
                    break;

                case 2:
                    scheduler.displayProcesses();
                    break;

                case 3:
                    scheduler.simulate();
                    break;

                case 4:
                    System.out.println("Exiting.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
