
public class PersonDriver {
	public static void main(String[] args) {
		Person p = new Person();
		Person q = new Person("Sam",21);
		Person r = new Person("Chris", 99);

		System.out.println(p);
		System.out.println(q);
		System.out.println(r);
	}
}
