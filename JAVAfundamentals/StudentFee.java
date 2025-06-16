import java.util.Scanner;

class StudentFee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the course fee (INR): ");
        double fee = scanner.nextDouble();
        
        System.out.print("Enter the discount percentage: ");
        double discountPercent = scanner.nextDouble();
        
        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;
        
        System.out.print("The discount amount is INR " + discount + 
                         " and final discounted fee is INR " + finalFee);
        
        scanner.close();
    }
}
