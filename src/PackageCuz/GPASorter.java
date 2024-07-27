package PackageCuz;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class GPASorter {

	/*Created a LinkedList <Student> to allow storage of the data
	 * In order to be able to give the user the ability to stop the program, i prompted
	 * for if they wanted to add to the list, or if they were done. This would allow for 
	 * any size List to be tested. 
	 * 
	 * To add a Student, i went through the process of adding the user. I originally had a loop to do this,
	 * but then did not know how to get the program to stop in order to save to file, also did not know exactly
	 * how long the list would be? 3.. 10.. 50? I gave the user the option to determine the amount of data
	 * within the LinkedList. 
	 * 
	 * When they no longer wanted to add to the list, it cycled through the list and showed the order, 
	 * then also printed that list to a .txt file in the C:\Temp folder. 
	 * 
	 * I added the try catch for validation of the GPA.
	 * 
	 * I took care of any input that would be outside of 'y', 'Y', 'n', or 'N'
	 * 
	 * closed the scanner to prevent memory leak
	 */
	public static void GPA() {
		LinkedList<Student> students = new LinkedList<>();
		Scanner scnr = new Scanner(System.in);
		while(true) { 
			System.out.println("Do you want to enter in a new Student. Y(Yes) or N(No)");
			String answer = scnr.next();
			char ch = answer.charAt(0);
				if( ch == 'n' || ch == 'N') {
					
					System.out.println("Sorting by Name. Saving: StudentGPA.txt \n\t\t---> Exiting application. <---");
					StudentSorter.selectionSort(students, new StringComparator());
					for(Student student : students) {
						System.out.println(student);
						saveToFile(students);
						scnr.close();
					}
					return;
					//System.exit(0);
				} else if(ch == 'y' || ch == 'Y') {
		
					System.out.println("Enter Name, Address and GPA. ");
					scnr.nextLine();
					System.out.println("Name: ");
					String name = scnr.nextLine();
			
					System.out.println("Address: ");
					String address = scnr.nextLine();
			
					double GPA = -1.0;
					while(GPA < 0.0) {
						try {
							System.out.println("GPA: ");
							GPA = scnr.nextDouble();
							if (GPA <= 0.0 || GPA > 4.0) {
								System.out.println("Please enter a valid GPA.");
								GPA = -1.0;
									scnr.next();
							}
						}catch (InputMismatchException e) {
							System.out.println("Invalid entry. Please enter again.");
							scnr.next();
						}
					}
					System.out.println("You entered: " + GPA);
					students.add(new Student(name, address, GPA));
					System.out.println("Students Added.");
				}else {
					System.out.println("Please enter in either 'Y' or 'N'. Thank you.");
				}
				System.out.println();
		}
	}
	public static void saveToFile(LinkedList<Student> students) {
		String fileName = "StudentGPA.txt";
		String filePath = System.getProperty("user.dir") + File.separator + fileName;
		
		System.out.println("File path: " + filePath);
		
		File file = new File(filePath);	
		try {
            // Check if the file already exists
            if (file.exists()) {
                System.out.println("File already exists.");
            }else{
                // Create a new file
                file.createNewFile();
                System.out.println("File created: " + file.getName());
            }
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
	        for(Student student : students) {
	        	writer.write(student.toString() + "\n");
	        }
	        bufferWriter.close();
		}catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
}