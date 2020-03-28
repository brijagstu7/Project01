

package try01;

import java.util.ArrayList;
import java.util.List;
public class Person implements Cloneable {
	String name;
	int age;
	List<String> favorits;
	public Person(String name,int age){
		this.name=name;
		this.age=age;
		this.favorits=new ArrayList<String>();
	}
	public void addFavorite(String favorite){
		favorits.add(favorite);
	}
	@Override
	public String toString(){
		return String.format("%s,%d,%s", name,age,favorits);
	}
	@Override
	protected Person clone() throws CloneNotSupportedException {
		Person cp=new Person(name,age);
		for (String f : favorits)
			cp.addFavorite(f);
		return cp;
	}

}

class PersonList implements Cloneable {
	List<Person> persons=new ArrayList<Person>();
	void addPerson(Person person){
		persons.add(person);

	}
	@Override
	protected PersonList clone() throws CloneNotSupportedException {
		PersonList a=new PersonList();
		for (Person p : persons)
			a.addPerson(p.clone());
		return a;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for (Person p : persons){
			if (sb.length()>0)
				sb.append(";");
			sb.append("{"+p+"}");
		}
		return sb.toString();
	}
}