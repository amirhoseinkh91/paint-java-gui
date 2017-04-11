package Person;

public class Person {

	private String username;
	private String password;
	
	// constructors
	public Person() {
	}

	public Person(String username, String password) {
		this.username = username;
		this.password = password;
	}

	// getter
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}	
}
