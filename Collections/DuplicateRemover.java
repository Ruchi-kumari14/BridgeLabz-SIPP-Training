import java.util.*;
class DuplicateRemover{
    public static List<Integer>removeDuplicates(List<Integer>list){
        Set<Integer> seen=new HashSet<>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Integer element=list.get(i);
            if(!seen.contains(element)){
                seen.add(element);
                result.add(element);
                result.add(element);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputList = new ArrayList<>(); // Declared as List

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            inputList.add(scanner.nextInt()); // List interface method
        }

        List<Integer> outputList = removeDuplicates(inputList);

        System.out.println("List after removing duplicates: " + outputList);

        scanner.close();
    }
}