package PackageCuz;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class GPASorter {

	public static void GPA() {
		LinkedList<Student> students = new LinkedList<>();
		@SuppressWarnings("resource")
		Scanner scnr = new Scanner(System.in);
		while(true) { 
			System.out.println("Do you want to enter in a new Student. Y(Yes) or N(No)");
			String answer = scnr.next();
			char ch = answer.charAt(0);
                    switch (ch) {
                        case 'n', 'N' -> {
                            System.out.println("Sorting by Name. Saving: StudentGPA.txt \n\t\t---> Exiting application. <---");
                            StudentSorter.selectionSort(students, new StringComparator());
                            for(Student student : students) {
                                System.out.println(student);
                                saveToFile(students);
                            }
                            return;
                        }
                        case 'y', 'Y' -> {
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
                        }
                        default -> System.out.println("Please enter in either 'Y' or 'N'. Thank you.");
                    }
                    //System.exit(0);
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
                System.out.println("\n");
            }else{
                // Create a new file
                file.createNewFile();
                System.out.println("File created: " + file.getName());
            }
            FileWriter writer = new FileWriter(file);
                    try (BufferedWriter bufferWriter = new BufferedWriter(writer)) {
                        for(Student student : students) {
                            bufferWriter.write(student.toString() + "\n");
                        }   }
		}catch (IOException e) {
	    }
	}
}