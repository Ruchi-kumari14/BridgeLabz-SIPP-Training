import java.util.Scanner;
class MultiplicationTable{
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      int[] table=new int[10];
      System.out.print("Enter a number: ");
      int number=sc.nextInt();
      for(int i=1;i<=10;i++){
          table[i-1]=number*i;
       }
    for(int i=1;i<=10;i++){
    System.out.println(number + " * " + i + " = " + table[i-1]);
   }
   sc.close();
 }
}






