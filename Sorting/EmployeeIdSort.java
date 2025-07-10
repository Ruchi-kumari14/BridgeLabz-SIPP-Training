
import java .util.Arrays;
class EmployeeIdSort {
	public static void  insertionSort(int[] empIds) {
		int n=empIds.length;
		for(int i=0;i<n;i++) {
			int key=empIds[i] ;
			int j=i-1;
			
			while(j>=0 && empIds[j]>key) {
				empIds[j+1]=empIds[j];
				j--;
			}
			empIds[j+1]=key;
		  }
		}
		public static void main(String[] args) {
			int[]employeeIds= {1005,1003,1008,1004,1002};
			insertionSort(employeeIds);
			System.out.println(Arrays.toString(employeeIds));
		
	}

}