package PackageCuz;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
		ArrayList<Integer> orgArray = new ArrayList<>(10);
		ArrayList<Integer> orgArray1 = new ArrayList<>(10);
		ArrayList<Integer> orgArray2 = new ArrayList<>(10);
		//ArrayList<Integer> orgArray3 = new ArrayList<>(10);

		Scanner scnr = new Scanner(System.in);
		System.out.println("Please type out 10 integers under 100. ");

			int i = 0;
			while(i < 10) {
				try {
					int dataIn = scnr.nextInt();
					if (dataIn < 0 || dataIn > 100) {
						throw new IllegalArgumentException();
					}
					numSort.add(dataIn);
					orgArray.add(dataIn);
					orgArray1.add(dataIn);
					orgArray2.add(dataIn);
					//orgArray3.add(dataIn);
					i++;
				} catch (InputMismatchException | IllegalArgumentException e) {
					System.out.println("Please enter a number from 0 - 100. No decimal numbers.");
					scnr.next();
				} 						
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
					System.out.println("Original Array: " + orgArray);
					System.out.println("Here is the 3rd smallest number: " + numSort.get(2));
					System.out.println("First you have to determine the size of the ArrayList. Array Size is: " + numSort.size());
					System.out.println("Then you have to iterate over the list from the first element: " + orgArray.get(0) 
						+ " to the second to last element in the array: " + orgArray.get(8));

					System.out.println("Examples of Array, First part minus last element, Second part minus First element: ");
					System.out.println(numSort);
					SelectionSort.selectionSortFirst(orgArray1);
					System.out.println(orgArray1);
					SelectionSort.selectionSortLast(orgArray2);
					System.out.println(orgArray2);
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