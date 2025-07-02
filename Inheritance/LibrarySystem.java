class Book{
   String title;
   int publicationYear;

//Constructor
   Book(String title,int publicationYear){
      this.title=title;
      this.publicationYear=publicationYear;
  }

   void displayInfo(){
      System.out.println("Book Title: "+title);
      System.out.println("Publication Year: "+ publicationYear);
   }
}
class Author extends Book{
   String name;
   String Bio;

   Author(String title,int publicationYear,String name,String Bio){
      super(title,publicationYear);
      this.name=name;
      this.Bio=Bio;
   }
@Override
   void displayInfo(){
      super.displayInfo();
      System.out.println("Author Name: " +name);
      System.out.println("Author Bio: " +Bio);
   }
}

class  LibrarySystem{
   public static void main(String[] args){
      Author auth=new Author("The Java HandBook",2022,"ruchi","Java Developer and Educator");
      auth.displayInfo();
   }
}
      

  