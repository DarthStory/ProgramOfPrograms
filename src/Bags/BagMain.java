package Bags;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BagMain {

	public static void Bags() {

		Scanner scnr = new Scanner(System.in); 
		Bag<Object> bag1 = new Bag<>();
		Bag<Object> bag2 = new Bag<>();	
		
			System.out.println("""
                    This program is Bag Manipulation. We have 2 bags that you can work with. 
                    We are going to request 10 values. Integer, Float, Double, Char or String. 
                    Afterwards, we will modify that Bag with requests for the user to do different functions.""");
			int i = 0;
			while(i < 10) {
				for(i = 0; i < 10; i++) {
				System.out.println("Enter in a value: ");
				String value = scnr.nextLine();
				bag1.add(value);
			}
			while(true) {
				System.out.println("\nModify the bags? Y(Yes), or Exit, N(No).");
				String answer = scnr.next();
				char ch = answer.charAt(0);
                switch (ch) {
                    case 'n', 'N' -> {
                        return;
                    }
                    case 'y', 'Y' -> {
                        System.out.println("Choose 1. Add, 2. Remove, 3. Query, 4. Clear, 5. Size, 6. Count, 7. Merge, 8. View Bags.");  
                        int selection = -1;
                        while(selection < 0)
                            try {
                                selection = scnr.nextInt();
                            }catch (InputMismatchException e) {
                                System.out.println("Invalid entry. Please try again. 1-8: ");
                                scnr.next();
                            }
						switch(selection) {
							case 1 -> {
								// Add
								
								System.out.println("Enter Bag number to add, 1 or 2?");
								int chosenAdd = scnr.nextInt();
								System.out.println("Add value. Enter value: ");
								String inputValueAdd = scnr.next();
								if(chosenAdd == 1) {
									System.out.println("Adding to bag 1: " + inputValueAdd);
									bag1.add(inputValueAdd);
								}else {
									System.out.println("Adding to bag 2: " + inputValueAdd);
									bag2.add(inputValueAdd);
								}
								System.out.println(bag1);
								System.out.println(bag2);
								continue;
					}
							case 2 -> {
								// Remove
								
								System.out.println("Enter Bag number to remove, 1 or 2?");
								int chosenRemove = scnr.nextInt();
								System.out.println("Add value. Enter value: ");
								String inputValueRemove = scnr.next();
								System.out.println("Removing value.");
								if(chosenRemove == 1) {
									System.out.println("Removing from bag 1: " + inputValueRemove);
									bag1.remove(inputValueRemove);
								}else {
									System.out.println("Removing from bag 2: " + inputValueRemove);
									bag2.remove(inputValueRemove);
								}
								System.out.println(bag1);
								System.out.println(bag2);
								continue;
							}
							case 3 -> {
								//Query
								
								System.out.println("Enter Bag number to query, 1 or 2?");
								int chosenQuery = scnr.nextInt();
								System.out.println("Query value. Enter value: ");
								String inputValueQuery = scnr.next();
								if(chosenQuery == 1) {
									System.out.println("Does Bag 1 contain: " + inputValueQuery + "?: " + bag1.contains(inputValueQuery));
								}else {
									System.out.println("Does Bag 2 contain: " + inputValueQuery + "?: " + bag2.contains(inputValueQuery));
								}
								System.out.println(bag1);
								System.out.println(bag2);
								continue;
							}
							case 4 -> {
								// Clear
								
								System.out.println("Enter Bag number to remove, 1 or 2?");
								int chosenClear = scnr.nextInt();
								if(chosenClear == 1) {
									System.out.println("Clearing bag 1.");
									bag1.clear();
								}else {
									System.out.println("Clearing bag 2.");
									bag2.clear();
								}
								continue;
							}
							case 5 -> {
								// Size
								
								System.out.println("Enter a bag to find the size, 1, 2 or 3(Both): ");
								int chosenSize = scnr.nextInt();
								System.out.println("Counting Bag(s).");
							switch (chosenSize) {
								case 1 -> System.out.println("Bag 1 Quantity: " + bag1.size());
								case 2 -> System.out.println("Bag 2 Quantity: " + bag2.size());
								default -> System.out.println("Bag Quantities: \nBag 1: " + bag1.size() +"\nBag 2: " + bag2.size());
							}
								continue;
							}
							case 6 -> {
								// Count
								
								System.out.println("");
								System.out.println("Which bag do you need to count from? ");
								int chosenCount = scnr.nextInt();
								System.out.println("What value do you want to count? ");
								String inputValueCount = scnr.next();
								if(chosenCount == 1) {
									System.out.println("Bag 1 has " + bag1.count(inputValueCount));
								}else {
									System.out.println("Bag 2 has " + bag2.count(inputValueCount));
								}
								continue;
							}
							case 7 -> {
								// Merge
								
								System.out.println("Merging Bags.\n");
								bag1.merge(bag2);
								bag1.print();
								System.out.println("");
								bag2.print();
								continue;
							}
							case 8 -> {
								// View Bags
								
								System.out.print("Bag 1: ");
								bag1.print();
								System.out.println("");
								System.out.print("Bag 2: ");
								bag2.print();
								continue;
							}
							default -> {
								return;
							}
						}
					}
					default -> System.out.println("Invalid Entry. Enter in Y(Yes) or N(No).");
				}
			}
		}
	}
}