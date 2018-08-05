package various;

public class SortStrings<T> {
	T data;
	
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		SortStrings ss = new SortStrings();
		
		String[] animals = {"1","lion","zebra","ant","frog","cat","2","dog","fish"};
		
		ss.data = "hello";

		
		for(int i = 0; i < animals.length; i++) {
			for (int l = 0; l < (animals.length - i - 1); l++) {
				if(animals[l].compareTo(animals[l+1]) > 0) {
					String temp = animals[l];
					animals[l] = animals[l+1];
					animals[l+1] = temp;
				}
			}
		}
		
		ss.PrintAll(ss.data);
		
	}
	
	public void PrintAll(T data) {
		System.out.println(data);
	}
}
