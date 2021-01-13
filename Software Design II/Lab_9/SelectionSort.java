import java.util.*;

public class SelectionSort
{
	ArrayList<Integer> list;
	
	public SelectionSort(ArrayList<Integer> list)
	{
		this.list = list;
	}

	public void sort() {
		
		for (int i = 0; i <= this.list.size()-1; i++) {
			int currentLargest = this.list.get(i);
			for(int x = 0; x < this.list.size()-1; x++){
				if(this.list.get(x) > currentLargest){
					currentLargest = this.list.get(x);
					swap(i,x);
				}
			}
			System.out.println(this.list);
		}
		
	}
	
	public void swap(int firstIndex, int secondIndex)
	{
		int temp = this.list.get(firstIndex);
		this.list.set(firstIndex, this.list.get(secondIndex));
		this.list.set(secondIndex, temp);
	}
	
	//public static class SortRunner {
		public static void main(String[] args) {
			Integer[] numbers = {1,2,7,2,9,18,29,30,6,3};
			ArrayList<Integer> data = new ArrayList<Integer>(Arrays.asList(numbers));
			SelectionSort sort = new SelectionSort(data);
			sort.sort();
			System.out.println(sort.list);
		//}
	}
}








/*for (int i = this.list.size()-1; i >= 0; i--) {
	int currentLargest = this.list.get(i);
	for(int x = 0; x < i; x++){
		if(this.list.get(x) > currentLargest){
			currentLargest = this.list.get(x);
			swap(i,x);
		}
	}
	System.out.println(this.list);
}*/