package PackageCuz;
public class Student {
	
	/*
	 * Setup of the Student object, lists the variables and components. 
	 */

	private String name;
	private String address;
	private double GPA;
	
	
	
	public Student(String name, String address, double GPA) {
		this.name = name;
		this.address = address;
		this.GPA = GPA;
		
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double GPA) {
		this.GPA = GPA;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\nAddress: " + address + "\nGPA: " + GPA;
	}
}