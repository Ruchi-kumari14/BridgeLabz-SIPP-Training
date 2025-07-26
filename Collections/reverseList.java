import java.util.*;
class reverseList{
    public static <T> void reverseList(List<T> list){
        int left=0;
        int right=list.size()-1;
        while(left<right){
            T temp=list.get(left);
            list.set(left,list.get(right));
            list.set(right,temp);
            left++;
            right--;
        }
    }
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        
        //ArrayList
        System.out.print("enter number of elements:");
        int n1=scanner.nextInt();
        List<Integer> arrayList=new ArrayList<>();
        System.out.println("enter " + n1 + " elements:");
        for(int i=0;i<n1;i++){
            arrayList.add(scanner.nextInt());
        }
        System.out.println("Original ArrayList" + arrayList);
        reverseList(arrayList);
        System.out.println("Reversed ArrayList" + arrayList);
         
         
        //LinkedList
         System.out.print("enter number of elements:");
        int n2=scanner.nextInt();
        List<Integer> LinkedList = new LinkedList<>();
        System.out.println("enter " + n2 + " elements:");
        for(int i=0;i<n2;i++){
            LinkedList.add(scanner.nextInt());
        }
        System.out.println("Original LinkedList" + LinkedList);
        reverseList(LinkedList);
        System.out.println("Reversed LinkedList" + LinkedList);
         
        
        
    }
    
}
