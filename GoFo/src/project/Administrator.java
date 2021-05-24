package project;

import java.util.Vector;

public class Administrator extends User {
	public Vector<String> masseges = new Vector<String>();

	public Administrator() {
		super();
	};

	public Administrator(String name, String password, String email, String phone, String location, String role) {
		super(name, password, email, phone, location, role);
	}

	public void addmassge(String massege) {
		masseges.add(massege);
	}

	public void displaymasseges() {
		if (masseges.isEmpty()) {
			System.out.println("there is no message");
		} else {
			for (int i = masseges.size() - 1, j = 1; i > -1; i--, j++) {
				System.out.println("massege " + j + " : " + masseges.get(i));
			}
		}
	}

	public void displayInfo() {
		System.out.println(
				"Name : " + getName() + " ,Email : " + getEmail() + " ,Phone : " + getPhone() + " ,ID : " + getId());
	}

}
