class Employee{
   String name;
   int id;
   int salary;


Employee(String name,int id,int salary){
   this.name=name;
   this.id=id;
   this.salary=salary;
}
void displayDetails(){
System.out.println("Name:" + name + " id:" + id + " salary: " + salary);
   }
}
 
class Manager extends Employee{
     int teamSize;
     Manager(String name,int id,int salary,int teamSize){
     super(name,id,salary);
     this.teamSize=teamSize;
}
void displayDetails(){
super.displayDetails();
System.out.println("Role:Manager, Teamsize:" + teamSize); 
    }
}

class Developer extends Employee{
     String Language;
      Developer(String name,int id,int salary,String Language){
      super(name,id,salary);
      this.Language=Language;
}
void displayDetails(){
super.displayDetails();
System.out.println("Role:Developer , Language:" + Language);
  }
}


class Intern extends Employee{
      int months;
      Intern(String name,int id,int salary,int months){
      super(name,id,salary);
      this.months=months;
}
void displayDetails(){
super.displayDetails();
System.out.println("Role:Intern , months:" + months);
  }
}


public class EmployeeManagementSystem{
    public static void main(String[] args){
        Employee e1=new Manager("Anjali",101,90000,5);
        Employee e2 = new Developer("Ravi", 102, 75000, "Java");
        Employee e3 = new Intern("Sneha", 103, 15000, 6);

        e1.displayDetails();
        e2.displayDetails();
        e3.displayDetails();
    }
}
 


