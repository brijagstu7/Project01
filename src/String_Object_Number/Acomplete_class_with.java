package String_Object_Number;



public class Acomplete_class_with {
	public void toStringTest() {
		Emp emp1 = new Emp("jack",100,"1233313");
		System.out.println(emp1.toString());	
		String str = emp1 + "";
		//The fast way to call toString .
		System.out.println(str);
		System.out.println(emp1);
		//auto call valueOf
		
		
	}
}
/**
 * This class shows what a standard class should 
 * have. 
 * @author brija
 *
 */
class Emp {
	private String name;
	private double salary;
	private String id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	Emp(){
		
	}
	Emp(String name, double salary, String id) {
		this.name = name;
		this.salary = salary;
		this.id = id;
	}
	/**
	 * method toString is belong to class object.
	 * it generally outputs information of 
	 * this class.
	 */
	@Override
	public String toString() {
		return "Emp [name=" + name + ", salary=" + salary + ", id=" + id + "]";
	}
	
	
}