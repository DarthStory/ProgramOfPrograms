package AutomobileInventory;

public class Automobile {

	// variables of an object "Automobile"
	private String make;
	private String model;
	private String color;
	private int year;
	private int mileage;
	
	// Constructor, inputs for what an "Automobile" is
	public Automobile(String make, String model, String color, int year, int mileage) {
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.mileage = mileage;
	}
	// Getters and Setters for each variable. 
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	/* Override to return a specific string 
		* from various types of variables. 
		* Used to output data as a string.
		*/ 
	@Override
	public String toString() {
		return make + " " + model + " " + color   + " " + year + " " + mileage;
	}
}