import java.util.Scanner;
class PerimeterofRectangle{
    public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    System.out.print("enter the length:");
    double length=scanner.nextDouble();
    System.out.print("enter the width:");
    double width=scanner.nextDouble();

    double Perimeter=2*(length+width);
    System.out.printf("the perimeter of rectangle is:%.2f\n",Perimeter);
    scanner.close();

    }
}

    

