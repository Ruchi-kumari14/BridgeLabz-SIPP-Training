public class Book{
    String title;
    String Author;
    double price;
//default constructor
public Book(){
   title="unknown";
   Author="unknown";
   price=0.0;
}
//parametrised constructor
public Book(String title,String Author,double prize){
   this.title=title;
   this.Author=Author;
   this.price=price;
}
//display result
void display(){
    System.out.println("Title:" + title);
    System.out.println("Author:" + Author);
    System.out.println("price: ₹" + price);
}

public static void main(String[] args){
        Book b1=new Book();
        Book b2=new Book("Verity","Colleen Hoover",300);
        b1.display();
        b2.display();
    } 
 
} 