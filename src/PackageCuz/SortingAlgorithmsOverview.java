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
	@SuppressWarnings("resource")
	public static void SortingAlgorithems() {

		ArrayList<Integer> numSort = new ArrayList<>(10);
		Scanner scnr = new Scanner(System.in);
		System.out.println("Please type out 10 integers under 100. ");

					for(int i = 0; i < 10; i++) {
						int dataIn = scnr.nextInt();
						numSort.add(dataIn);
					}

		while (true) { 

			long start;
			long duration;

			System.out.println("Which algorithm would you like to go over? ");
			
			System.out.println("1. Selection Sort");
			System.out.println("2. Quick Sort.");
			System.out.println("3. Merge Sort");
			System.out.println("4. Bubble Sort");
			System.out.println("5. Insertion Sort");
			System.out.println("0. Exit");
			int choice = -1;
			while(choice < 0)

				try {
					choice = scnr.nextInt();
				} catch (Exception e) {
					System.out.println("Invalid entry. Please try again. 0-5");
					scnr.next();
				}
			switch(choice) {
				case 0 -> {
					System.out.println("Exiting Algorithms.");
					return;
				}
				case 1 -> {
					System.out.println("1. Selection Sort.");
					System.out.println("Here is the inital Array as you input: ");
					System.out.println(numSort);
					
					start = System.nanoTime();
					SelectionSort.selectionSort(numSort);
					duration = (System.nanoTime() - start) / 100000;

					System.out.println("Sorted Array: ");
					for(int num : numSort) {
						System.out.print(num + " ");
					}
					System.out.println("\n" + duration + "ms");
					continue;
					}

				case 2 -> {
					System.out.println("2. Quick Sort.");
					System.out.println("Here is the inital Array as you input: ");
					System.out.println(numSort);

					continue;
				}
				case 3 -> {
					System.out.println("3. Merge Sort.");
					System.out.println("Here is the inital Array as you input: ");
					System.out.println(numSort);

					continue;
				}
				case 4 -> {
					System.out.println("Bubble Sort.");
					System.out.println("Here is the inital Array as you input: ");
					System.out.println(numSort);

					continue;
				}
				case 5 -> {
					System.out.println("Insertion Sort.");
					System.out.println("Here is the inital Array as you input: ");
					System.out.println(numSort);

					continue;
				}
				default -> {
					System.out.println("Invalid Entry.");
					continue;
				}
			}	
		}
	}
}