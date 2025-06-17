import java.util.Scanner;
class factorial{
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      System.out.print("enter positive number:");
      int number=sc.nextInt();
      if (number<0){
      System.out.println("Invalid ");
        } else {
            
            int factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial = factorial * i;
            }

           
            System.out.println("The factorial of " + number + " is " + factorial);
        }

        sc.close();
    }
}

    
