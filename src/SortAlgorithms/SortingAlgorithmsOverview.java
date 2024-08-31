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
		ArrayList<Integer> orgArray3 = new ArrayList<>(10);

		
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
					orgArray3.add(dataIn);
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
						+ " to the second to last element in the array: " + orgArray.get(9) + " Using the first element in the array as the smallest element.\n");
					System.out.println("You get 'i' from the smallest number in this array: " + numSort.get(0) + ", and you swap it with the first element in the array.\n");

					System.out.println("Now you go from the second element in the array: " + orgArray.get(1) + ", and go through the array again.\n");
					System.out.println("This is where you get the next lowest element in the array: \n" + numSort.get(1) + "\n");
					System.out.println("Then you repeat this until you have the final order.\n");
					System.out.println(numSort);
					System.out.println("");

					// Demonstration with the first 4 elements
					System.out.println("This is what it would look like if you only sorted the first 4 elements in the array step by step.");
					int[] demoArray = orgArray3.stream().mapToInt(Integer::intValue).toArray();
					demoArray = Arrays.copyOfRange(demoArray, 0, 4);
					System.out.println("Initial 4 elements: " + Arrays.toString(demoArray) + "\n");

					for (int i = 0; i < demoArray.length - 1; i++) {
						int minIndex = i;
						for (int j = i + 1; j < demoArray.length; j++) {
							if (demoArray[j] < demoArray[minIndex]) {
								minIndex = j;
							}
						}

						// Swap the found minimum element with the first unsorted element
						int temp = demoArray[minIndex];
						demoArray[minIndex] = demoArray[i];
						demoArray[i] = temp;

						System.out.println("Array after selecting and swapping element " + demoArray[i] + ": " + Arrays.toString(demoArray) + "\n");
					}

					System.out.println("After these steps, the first 4 elements are sorted.\n");
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
                        You get 'i' from the partitioning process with the pivot. We chose the first element in the array. Here is the pivot element from the Array: 
                        """
						+ orgArray1Array[0] + "\n");
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
					System.out.println("First, you determine the size of the array. Array Size is: \n" + numSortArray.length + "\n");
					System.out.println("Then, you split the array into two halves, sort them, and merge them back together.\n");
				
					// Demonstration with the first 4 elements
					System.out.println("Let's take the first 4 elements and demonstrate how Merge Sort works step by step.\n");
				
					int[] demoArray = Arrays.copyOfRange(orgArray1Array, 0, 4);
					System.out.println("Initial 4 elements: " + Arrays.toString(demoArray) + "\n");
				
					// Split into two halves
					int mid = demoArray.length / 2;
					int[] left = Arrays.copyOfRange(demoArray, 0, mid);
					int[] right = Arrays.copyOfRange(demoArray, mid, demoArray.length);
				
					System.out.println("First, split the array into two halves:");
					System.out.println("Left half: " + Arrays.toString(left));
					System.out.println("Right half: " + Arrays.toString(right) + "\n");
				
					// Sort the two halves (since we're demonstrating, assume they are already sorted here)
					Arrays.sort(left);
					Arrays.sort(right);
				
					System.out.println("Next, sort the two halves (if they aren't already sorted):");
					System.out.println("Sorted left half: " + Arrays.toString(left));
					System.out.println("Sorted right half: " + Arrays.toString(right) + "\n");
				
					// Merge the two sorted halves back together
					int i = 0, j = 0, k = 0;
					while (i < left.length && j < right.length) {
						if (left[i] <= right[j]) {
							demoArray[k++] = left[i++];
						} else {
							demoArray[k++] = right[j++];
						}
					}
				
					// Copy remaining elements of left[], if any
					while (i < left.length) {
						demoArray[k++] = left[i++];
					}
				
					// Copy remaining elements of right[], if any
					while (j < right.length) {
						demoArray[k++] = right[j++];
					}
				
					System.out.println("Finally, merge the sorted halves back together:");
					System.out.println("Merged and sorted array: " + Arrays.toString(demoArray) + "\n");
				
					System.out.println("After these steps, the first 4 elements are sorted using Merge Sort.\n");
					continue;
				}
				
				
				case 4 -> {
					System.out.println("4. Bubble Sort.\n");
					System.out.println("""
						Bubble Sort is a simple, comparison-based sorting algorithm that repeatedly steps through the list,
						compares adjacent elements, and swaps them if they are in the wrong order. This process is repeated
						until the list is sorted.
				
						Key Points:
				
						Bubble Sort has a worst-case and average time complexity of O(n^2), making it inefficient on large datasets.
						
						It is a stable sorting algorithm, meaning that it preserves the relative order of equal elements.
						
						While simple and easy to understand, it is generally not suitable for large datasets due to its inefficiency compared to other algorithms.
						""");
				
					// Convert ArrayList<Integer> to int[] for BubbleSort
					int[] numSortArray = numSort.stream().mapToInt(Integer::intValue).toArray();
					int[] orgArray1Array = orgArray1.stream().mapToInt(Integer::intValue).toArray();
				
					System.out.println("Here is the initial Array as you input: ");
					System.out.println(Arrays.toString(numSortArray));
				
					start = System.nanoTime();
					BubbleSort.bubbleSort(numSortArray);
					duration = (System.nanoTime() - start) / 100000;
				
					System.out.println("Sorted Array: ");
					for (int num : numSortArray) {
						System.out.print(num + " ");
					}
				
					System.out.println("\n" + duration + "ms\n");
					System.out.println("Original Array 1 (pre-sorted): \n" + Arrays.toString(orgArray1Array) + "\n");
					System.out.println("Here is the 3rd smallest number: \n" + numSortArray[2] + "\n");
					System.out.println("First, you determine the size of the array. Array Size is: \n" + numSortArray.length + "\n");
					System.out.println("Then, you iterate over the array multiple times, comparing adjacent elements and swapping them if necessary.\n");

					// Demonstration with the first 4 elements
					System.out.println("Let's take the first 4 elements and demonstrate how Bubble Sort works step by step.\n");

					int[] demoArray = Arrays.copyOfRange(orgArray1Array, 0, 4);
					System.out.println("Initial 4 elements: " + Arrays.toString(demoArray) + "\n");

					// First pass
					System.out.println("First Pass:");
					if (demoArray[0] > demoArray[1]) {
						System.out.println("Swapping " + demoArray[0] + " and " + demoArray[1]);
						int temp = demoArray[0];
						demoArray[0] = demoArray[1];
						demoArray[1] = temp;
					}
					if (demoArray[1] > demoArray[2]) {
						System.out.println("Swapping " + demoArray[1] + " and " + demoArray[2]);
						int temp = demoArray[1];
						demoArray[1] = demoArray[2];
						demoArray[2] = temp;
					}
					if (demoArray[2] > demoArray[3]) {
						System.out.println("Swapping " + demoArray[2] + " and " + demoArray[3]);
						int temp = demoArray[2];
						demoArray[2] = demoArray[3];
						demoArray[3] = temp;
					}
					System.out.println("Array after First Pass: " + Arrays.toString(demoArray) + "\n");

					// Second pass
					System.out.println("Second Pass:");
					if (demoArray[0] > demoArray[1]) {
						System.out.println("Swapping " + demoArray[0] + " and " + demoArray[1]);
						int temp = demoArray[0];
						demoArray[0] = demoArray[1];
						demoArray[1] = temp;
					}
					if (demoArray[1] > demoArray[2]) {
						System.out.println("Swapping " + demoArray[1] + " and " + demoArray[2]);
						int temp = demoArray[1];
						demoArray[1] = demoArray[2];
						demoArray[2] = temp;
					}
					System.out.println("Array after Second Pass: " + Arrays.toString(demoArray) + "\n");

					// Third pass
					System.out.println("Third Pass:");
					if (demoArray[0] > demoArray[1]) {
						System.out.println("Swapping " + demoArray[0] + " and " + demoArray[1]);
						int temp = demoArray[0];
						demoArray[0] = demoArray[1];
						demoArray[1] = temp;
					}
					System.out.println("Array after Third Pass: " + Arrays.toString(demoArray) + "\n");

					System.out.println("After these passes, the first 4 elements are sorted.\n");
					System.out.println("With each full pass through the array, the next largest element is placed in its correct position.\n");
					System.out.println("Finally, after all passes, the array is sorted as: \n" + Arrays.toString(numSortArray) + "\n");
					continue;
				}
				
				case 5 -> {
					System.out.println("5. Insertion Sort.\n");
					System.out.println("""
						Insertion Sort is a simple, comparison-based sorting algorithm that builds the final sorted array one element at a time.
						It works by repeatedly taking the next element from the unsorted portion of the array, and inserting it into the correct position 
						in the sorted portion of the array.
				
						Key Points:
				
						Insertion Sort has a worst-case time complexity of O(n^2), making it inefficient on large datasets.
						
						It is a stable sorting algorithm, meaning that it preserves the relative order of equal elements.
						
						It is particularly efficient for small datasets or partially sorted arrays, as it requires fewer comparisons and swaps.
						""");
				
					// Convert ArrayList<Integer> to int[] for InsertionSort
					int[] numSortArray = numSort.stream().mapToInt(Integer::intValue).toArray();
					int[] orgArray1Array = orgArray1.stream().mapToInt(Integer::intValue).toArray();
				
					System.out.println("Here is the initial Array as you input: ");
					System.out.println(Arrays.toString(numSortArray));
				
					start = System.nanoTime();
					InsertionSort.insertionSort(numSortArray);
					duration = (System.nanoTime() - start) / 100000;
				
					System.out.println("Sorted Array: ");
					for (int num : numSortArray) {
						System.out.print(num + " ");
					}
				
					System.out.println("\n" + duration + "ms\n");
					System.out.println("Original Array 1 (pre-sorted): \n" + Arrays.toString(orgArray1Array) + "\n");
					System.out.println("Here is the 3rd smallest number: \n" + numSortArray[2] + "\n");
					System.out.println("First, you determine the size of the array. Array Size is: \n" + numSortArray.length + "\n");
					System.out.println("Then, you iterate over the array, taking each element and inserting it into its correct position in the sorted portion of the array.\n");
				
					// Demonstration with the first 4 elements
					System.out.println("Let's take the first 4 elements and demonstrate how Insertion Sort works step by step.\n");
				
					int[] demoArray = Arrays.copyOfRange(orgArray1Array, 0, 4);
					System.out.println("Initial 4 elements: " + Arrays.toString(demoArray) + "\n");
				
					for (int i = 1; i < demoArray.length; i++) {
						int key = demoArray[i];
						int j = i - 1;
				
						// Move elements of demoArray[0..i-1], that are greater than key,
						// to one position ahead of their current position
						while (j >= 0 && demoArray[j] > key) {
							demoArray[j + 1] = demoArray[j];
							j = j - 1;
						}
						demoArray[j + 1] = key;
				
						System.out.println("Array after inserting element " + key + ": " + Arrays.toString(demoArray) + "\n");
					}
				
					System.out.println("After these steps, the first 4 elements are sorted.\n");
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