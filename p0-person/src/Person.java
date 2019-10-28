/**
 * @author PUT YOUR NAME HERE
 * @date WHEN DID YOU FINISH THIS
 *
 * Class in the first assignment for Compsci 201
 * in Fall 2019
 */

public class Person {
	
	private String myName;
	private int myAge;
	
	/**
	 * Construct a Person object with a name and age
	 * @param name is used as the identifier for this object
	 * @param age is used as the age for this object
	 */
	
	public Person(String name, int age) {
		// TODO: complete constructor
		myName = name;
		myAge = age;
	} 
	
	/**
	 * Construct a default Person, identifier
	 * will be "they with no name", age will be 13
	 */
	
	public Person() {
		this("NoName",13);
	}
	
	/**
	 * Returns this object's identifier/name
	 * @return this objects identifying String/label
	 */
	public String getName() {
		// TODO: complete this method
		return myName;
	}
	
	/**
	 * Returns age of this person
	 * @return the age of this person.
	 */
	public int getAge() {
		return myAge;
	}
	
	@Override
	public String toString() {
		return String.format("%s %d", getName(), getAge());
	}
}
