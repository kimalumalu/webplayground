package bodymassindex;

public class User {
	protected Gender gender;
	protected int age;
	protected double height;
	protected double weight;
	
	public User() {
		
	}
	
	public User(Gender gender, int age, double height, double weight) {
		this.gender = gender;
		this.age    = age;
		this.height = height;
		this.weight = weight;
	}	

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
