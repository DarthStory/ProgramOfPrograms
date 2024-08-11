package PackageCuz;

import java.util.ArrayList;
import java.util.Scanner;

public class SortingAlgorithmsOverview {

	public static void SortAlgOverview() {
		System.out.println("""
			Here we will go over Sorting algorithms. We will request 10 integer values, then let you pick one of 4 sorting algorithms
			to sort the data with. This will Explain what each does in order to get the outcome printed.\n\n
						
			""");
			SortingAlgorithems();
		
	
	}
	public static void SortingAlgorithems() {

		ArrayList<Integer> numSort = new ArrayList<>(10);

		Scanner scnr = new Scanner(System.in);
		System.out.println("Please type out 10 integers under 100. ");

		for(int i = 0; i < 10; i++) {
			int dataIn = scnr.nextInt();
			numSort.add(dataIn);
		}

		System.out.println("Which algorithm would you like to go over? ");
		System.out.println("0. Exit, 1. Selection Sort, 2. Quick Sort, 3. Merge Sort, 4. Bubble Sort, 5. Insertion Sort?");
		
		int choice = scnr.nextInt();
		while(choice != 0){
			switch(choice) {
				case 1 -> {
					System.out.println("1. Selection Sort.");
					}
				case 2 -> {
					System.out.println("2. Quick Sort.");
				}
				case 3 -> {
					System.out.println("3. Merge Sort.");
				}
				case 4 -> {
					System.out.println("Bubble Sort.");
				}
				case 5 -> {
					System.out.println("Insertion Sort.");
				}
				default -> {
					System.out.println("Exit program.");
				}
			}
		}
	}
}