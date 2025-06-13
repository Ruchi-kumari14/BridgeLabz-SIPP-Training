import java.util.Scanner;
class CylinderVolume{
    public static void main(String[] args){
    Scanner scanner=new Scanner(System.in);
    System.out.print("enter the radius of cylinder:");
    double radius=scanner.nextDouble();
    System.out.print("enter the height of cylinder:");
    double height=scanner.nextDouble();
    double volume=Math.PI *radius*radius*height;
    System.out.printf("the volume of cylinder i:%.2f cubic units\n",volume);
    scanner.close();
    }
}