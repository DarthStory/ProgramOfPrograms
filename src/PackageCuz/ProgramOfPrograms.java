package PackageCuz;

import AutomobileInventory.Dealership;
import Bags.BagMain;
import GPA.GPASorter;
import SortAlgorithms.SortingAlgorithmsOverview;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ProgramOfPrograms {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);		
		while(true) {	
								
			System.out.println("""
                                           
                    Hello, 
                    \t This is my program to represent my abilities and understanding thus far
                    in my programming journey. I will give options to chose and show different programs
                    within this man program to do different parts of programing. They will include
                    everything from simple requests from the user and printing it out, to sorting
                    algorithms and searching abilities.""");

			System.out.println("\n\n Lets get started. Please choose an option by selecting a number: ");
			System.out.println("1. First Final Project. Automobile Object Manipulation.");
			System.out.println("2. Second Final Project. List of Students, sort and print.");
			System.out.println("3. This is a program that implements and manipulates a Bag.");
			System.out.println("4. Sorting Algorithms.");
	//		System.out.println("5");
	//		System.out.println("6");
	//		System.out.println("7");
	//		System.out.println("8");
	//		System.out.println("9");
			System.out.println("0. Exits program.");
			
			// User selects which program to play through. 
			int choice = -1;
			while(choice < 0)
				try {
					choice = scnr.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Invalid entry. Please try again. 0-9");
					choice = -1;
				}

			switch(choice) {
				case 0:
					System.out.println("Exiting program.");
					scnr.close();
					return;
				case 1:
					System.out.println("Starting first program. Automobile Object Manipulation.");
					Dealership.dealership();
					continue;
					
				case 2:
					System.out.println("Starting second program. List of Students, sort and print.");
					GPASorter.GPA();
					continue;
				case 3:
					System.out.println("Bag implementation");
					BagMain.Bags();
					continue;
				case 4:
					System.out.println("Sorting Algorithms. Explainations more than Demonstrations.\n");
					SortingAlgorithmsOverview.SortAlgOverview();
				default: 
					System.out.println("Invalid Entry.");
			}
		}
	}
}