package PackageCuz;

import java.util.ArrayList;

public class SelectionSort {
    
    public static void selectionSort(ArrayList<Integer> numbers) {
		int size = numbers.size();
		
		for(int i = 0; i < size - 1; i++) {
			int minIndex = i;
            for(int j = i + 1; j < size; j++) {
                if(numbers.get(j) < numbers.get(minIndex)) {
                    minIndex = j;
                }
            }
			int temp = numbers.get(minIndex);
		numbers.set(minIndex, numbers.get(i));
		numbers.set(i, temp);
		}
	}
}
