import java.util.*;
public class FrequencyCount{
    public static Map<String,Integer>countFrequency(List<String> list){
        Map<String,Integer> frequencyMap=new HashMap<>();
        for(String element: list){
            if(frequencyMap.containsKey(element)){
                frequencyMap.put(element,frequencyMap.get(element)+1);
            }
            else{
                frequencyMap.put(element,1);
            }
        }
        return frequencyMap;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("number of elements:");
        int n=scanner.nextInt();
        scanner.nextLine();
        
        List<String> inputList=new ArrayList<>();
        for(int i=0;i<n;i++){
            inputList.add(scanner.nextLine());
        }
        Map<String,Integer>frequencyMap=countFrequency(inputList);
        System.out.println("frequency:" + frequencyMap);
        scanner.close();
    }
}
