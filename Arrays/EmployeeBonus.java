import java.util.Scanner;

 class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        double[] salary = new double[n], bonus = new double[n], newSalary = new double[n];
        int[] years = new int[n];
        double totalOld = 0, totalBonus = 0, totalNew = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Salary: ");
            salary[i] = sc.nextDouble();
            System.out.print("Years of Service: ");
            years[i] = sc.nextInt();
            if (salary[i] <= 0 || years[i] < 0) {
                System.out.println("Invalid input.");
                i--;
                continue;
            }
        }

        for (int i = 0; i < n; i++) {
            bonus[i] = salary[i] * (years[i] > 5 ? 0.05 : 0.02);
            newSalary[i] = salary[i] + bonus[i];
            totalOld += salary[i];
            totalBonus += bonus[i];
            totalNew += newSalary[i];
        }

        for (int i = 0; i < n; i++)
            System.out.printf("Emp %d: Old = %.2f, Bonus = %.2f, New = %.2f\n", i + 1, salary[i], bonus[i], newSalary[i]);

        System.out.printf("\nTotal Old = %.2f, Total Bonus = %.2f, Total New = %.2f\n", totalOld, totalBonus, totalNew);
        sc.close();
    }
}
