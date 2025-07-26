import java.util.*;
class ListRotater{
    public static List<Integer>rotateList(List<Integer>list,int k){
        int n=list.size();
        k=k%n;
        List<Integer> rotated=new ArrayList<>();
        for(int i=k;i<n;i++){
            rotated.add(list.get(i));
        }
        for(int i=0;i<k;i++){
            rotated.add(list.get(i));
        }
        return rotated;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        List<Integer> inputList=new ArrayList<>();
        System.out.println("number of elements:");
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            inputList.add(scanner.nextInt());
        }
        System.out.print("enter positions to rotate:");
        int k=scanner.nextInt();
        List<Integer> result=rotateList(inputList,k);
        System.out.println(result);
        scanner.close();
            
        
    }
}