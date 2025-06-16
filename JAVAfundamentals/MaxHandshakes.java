import java.util.Scanner;
class MaxHandshakes{
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
       System.out.print("the number of Students:");
       int totalStudents=sc.nextInt();
       int handshakes=(totalStudents * (totalStudents -1))/2;
       System.out.println("Maximum number of handshakes: " + handshakes);

        sc.close();
    }
}