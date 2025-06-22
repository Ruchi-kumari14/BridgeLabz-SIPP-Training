

import java.util.Scanner;
class StringReverse{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String input=sc.nextLine();
        char[] characters=input.toCharArray();
        String reversed="";
        for(int i=characters.length-1;i>=0;i--){
            reversed += characters[i];
         }
        System.out.println("reversed string:" +reversed);
        sc.close();
     }
}