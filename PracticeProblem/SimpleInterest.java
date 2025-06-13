import java.util.Scanner;
class SimpleInterest{
    public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    System.out.print("Enter principal:");
    double principal=scanner.nextDouble();
    System.out.print("enter rate :");
    double rate=scanner.nextDouble();
    System.out.print("enter time(in years):");
    double time=scanner.nextDouble();
    double SimpleInterest=(principal*rate*time)/100;
    System.out.printf("The simple interest is: %.2f\n",SimpleInterest);
    scanner.close();
    }
}
    

    

    
  
