public class Circle{
   double radius;
//Default Constructor
public Circle(){
    radius=0.0;
}
//parameterized constructor
public Circle(double radius){
   this.radius=radius;
}
public double getArea(){
    return Math.PI*radius*radius;
}
public void display(){
    System.out.println("Radius:"+radius +",Area: " + getArea());
}
public static void main(String[] args){
    Circle c1=new Circle();
    Circle c2=new Circle(5.5);
    c1.display();
    c2.display();
   }
}