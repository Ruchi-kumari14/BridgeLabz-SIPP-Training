
import java.util.Scanner;
public class KmtoMiles{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double km;
        System.out.print("Enter distance in kilometers: ");
        km=sc.nextInt();
        double miles=km/1.6;
        System.out.println("The totalmiles is" + miles + " mile  for the given " + km + " km ");
        sc.close();
    }
}

  