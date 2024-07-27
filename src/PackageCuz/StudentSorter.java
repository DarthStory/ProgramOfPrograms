package PackageCuz;
import java.util.Comparator;
import java.util.LinkedList;

public class StudentSorter {
	
	

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