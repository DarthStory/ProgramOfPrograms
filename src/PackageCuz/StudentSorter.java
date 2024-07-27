package PackageCuz;
import java.util.Comparator;
import java.util.LinkedList;

public class StudentSorter {
	
	/*
	 * Selection sort method for the variables in the comparator from the Student class
	 * 
	 * "i" is used as the minIndex and "j" for the second variable. "for" loops progress through variables. 
	 *  
	 *  it then compares "j" and "minIndex". If "j" is less than the "minIndex", "j" becomes the "minIndex"
	 *  It does this by seeing if the result is lesser(less than 0), equal(0), or greater(greater than 0)
	 *  
	 *  the last part takes the "temp" variable to swap the 2 values as you need the "3 hands" to swap variables
	 */

	public static void selectionSort(LinkedList<Student> students, Comparator<Student> comparator) {
		int n = students.size();
		for(int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < n; j++) {
				if(comparator.compare(students.get(j), students.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				Student temp = students.get(i);
				students.set(i,  students.get(minIndex));
				students.set(minIndex, temp);
			}
		}
	}
}