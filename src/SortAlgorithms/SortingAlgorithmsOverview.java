package SortAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
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
	public static void SortingAlgorithems() {

		ArrayList<Integer> numSort = new ArrayList<>(10);
		ArrayList<Integer> orgArray = new ArrayList<>(10);
		ArrayList<Integer> orgArray1 = new ArrayList<>(10);
		ArrayList<Integer> orgArray2 = new ArrayList<>(10);
		//ArrayList<Integer> orgArray3 = new ArrayList<>(10);

		
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		System.out.println("Please type out 10 integers under 100. ");


			for(int i = 0; i < 10; i++) {
				try{
					int dataIn = scnr.nextInt();
					if (dataIn < 0 || dataIn > 100) {
						throw new IllegalArgumentException();
					}
					numSort.add(dataIn);
					orgArray.add(dataIn);
					orgArray1.add(dataIn);
					orgArray2.add(dataIn);
					//orgArray3.add(dataIn);
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
					System.out.println("1. Selection Sort.\n");
					System.out.println("""
							Selection Sort is an in-place comparison sorting algorithm. 
							It works by repeatedly selecting the smallest (or largest, depending on the order you want), 
							element from the unsorted part of the array and swapping it with the first unsorted element. 
							This process continues until the entire array is sorted. 
							Key Points:

							Selection Sort has a time complexity of O(n^2) because it requires two nested loops: 
							one to iterate over the array and another to find the minimum element.

							It is not the most efficient for large datasets but is easy to understand and implement.
							""");
					System.out.println("Here is the inital Array as you input: ");
					System.out.println(numSort);
					
					start = System.nanoTime();
					SelectionSort.selectionSort(numSort);
					duration = (System.nanoTime() - start) / 100000;

					System.out.println("Sorted Array: ");
					for(int num : numSort) {
						System.out.print(num + " ");
					}
					// setup to pull numbers from for the lesson
					SelectionSort.selectionSortFirst(orgArray1);
					SelectionSort.selectionSortLast(orgArray2);

					System.out.println("\n" + duration + "ms\n");
					System.out.println("Original Array: \n" + orgArray + "\n");
					System.out.println("Here is the 3rd smallest number: \n" + numSort.get(2) + "\n");
					System.out.println("First you have to determine the size of the ArrayList. Array Size is: \n" + numSort.size() + "\n");
					System.out.println("Then you have to iterate over the list from the first element: " + orgArray.get(0) 
						+ " to the second to last element in the array: " + orgArray.get(8) + "\n");
					System.out.println("You get 'i' from the smallest number in this array: \n" + orgArray1.get(0) + "\n");
					System.out.println("Now you go over the rest of the array.\n");
					for(int n = 1; n < orgArray.size(); n++) {
						System.out.print(orgArray.get(n) + " ");
					}
					System.out.println("\n");
					System.out.println("This is where you get the next lowest element in the array: \n" + orgArray1.get(1) + "\n");
					System.out.println("Then you repeat this until you have the final order.\n");
					System.out.println(numSort);
					System.out.println("");

					
					continue;
					}

				case 2 -> {
					System.out.println("2. Quick Sort.\n");
					System.out.println("""
						Quick Sort is an efficient, in-place sorting algorithm that uses a divide-and-conquer approach.
						It works by selecting a pivot element, partitioning the array around the pivot such that elements less than the pivot 
						are on the left and elements greater than the pivot are on the right. This process is repeated recursively on the 
						sub-arrays, eventually sorting the entire array.

						Key Points:

						Quick Sort has an average time complexity of O(n log n), making it faster than many other sorting algorithms for large datasets.
						
						It is an in-place sort, meaning it requires a minimal amount of additional memory space.
						""");

					// Convert ArrayList<Integer> to int[] for QuickSort
					int[] numSortArray = numSort.stream().mapToInt(Integer::intValue).toArray();
					int[] orgArray1Array = orgArray1.stream().mapToInt(Integer::intValue).toArray();

					System.out.println("Here is the initial Array as you input: ");
					System.out.println(Arrays.toString(numSortArray));

					start = System.nanoTime();
					QuickSort.quickSort(numSortArray, 0, numSortArray.length - 1);
					duration = (System.nanoTime() - start) / 100000;

					System.out.println("Sorted Array: ");
					for (int num : numSortArray) {
						System.out.print(num + " ");
					}

					System.out.println("\n" + duration + "ms\n");
					System.out.println("Original Array 1 (pre-sorted): \n" + Arrays.toString(orgArray1Array) + "\n");
					System.out.println("Here is the 3rd smallest number: \n" + numSortArray[2] + "\n");
					System.out.println("First you have to determine the size of the array. Array Size is: \n" + numSortArray.length + "\n");
					System.out.println("Then you have to iterate over the list from the first element: " + orgArray1Array[0] 
						+ " to the last element in the array: " + orgArray1Array[orgArray1Array.length - 1] + "\n");
					System.out.println("""
						You get 'i' from the partitioning process with the pivot. 
						We chose the last element in the array. 
						Here is the pivot element from orgArray1Array: \n" + orgArray1Array[0] + "\n
							""");
					System.out.println("Now you go over the rest of the array.\n");
					for (int n = 1; n < orgArray1Array.length; n++) {
						System.out.print(orgArray1Array[n] + " ");
					}
					System.out.println("\n");
					System.out.println("This is where you get the next pivot and continue the partitioning: \n" + orgArray1Array[1] + "\n");
					System.out.println("Then you repeat this until you have the final order.\n");
					System.out.println(Arrays.toString(numSortArray));
					System.out.println("");
					continue;
				}
				case 3 -> {
					System.out.println("3. Merge Sort.\n");
					System.out.println("""
						Merge Sort is a stable, comparison-based sorting algorithm that uses a divide-and-conquer approach.
						It works by recursively splitting the array into two halves, sorting each half, and then merging the sorted halves back together.
				
						Key Points:
				
						Merge Sort has a time complexity of O(n log n) for all cases, making it very predictable in terms of performance.
						
						Unlike Quick Sort, Merge Sort is not an in-place sorting algorithm, meaning it requires additional memory space equivalent to the array size.
				
						It is particularly efficient for sorting large datasets or linked lists.
						""");
				
					// Convert ArrayList<Integer> to int[] for MergeSort
					int[] numSortArray = numSort.stream().mapToInt(Integer::intValue).toArray();
					int[] orgArray1Array = orgArray1.stream().mapToInt(Integer::intValue).toArray();
				
					System.out.println("Here is the initial Array as you input: ");
					System.out.println(Arrays.toString(numSortArray));
				
					start = System.nanoTime();
					MergeSort.mergeSort(numSortArray, 0, numSortArray.length - 1);
					duration = (System.nanoTime() - start) / 100000;
				
					System.out.println("Sorted Array: ");
					for (int num : numSortArray) {
						System.out.print(num + " ");
					}
				
					System.out.println("\n" + duration + "ms\n");
					System.out.println("Original Array 1 (pre-sorted): \n" + Arrays.toString(orgArray1Array) + "\n");
					System.out.println("Here is the 3rd smallest number: \n" + numSortArray[2] + "\n");
					System.out.println("First, you have to determine the size of the array. Array Size is: \n" + numSortArray.length + "\n");
					System.out.println("Then you have to divide the array into two halves: " + Arrays.toString(Arrays.copyOfRange(numSortArray, 0, numSortArray.length / 2)) 
						+ " and " + Arrays.toString(Arrays.copyOfRange(numSortArray, numSortArray.length / 2, numSortArray.length)) + "\n");
					System.out.println("These halves are recursively sorted and then merged back together.\n");
					System.out.println("Finally, the entire array is merged and sorted as: \n" + Arrays.toString(numSortArray) + "\n");
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