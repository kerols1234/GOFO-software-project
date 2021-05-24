package project;

/**
 * 
 * @author kerols
 *
 */
public class User {
	/**
	 * Attribute to generate id without repeat
	 */
	private static int ID = 0;
	/**
	 * Attributes to save name , password , email , phone , location , role of user
	 */
	private String name, password, email, phone, location, role;
	/**
	 * Attribute to save id
	 */
	private int id;

	/**
	 * Default constructor
	 */
	public User() {
		this.id = ID;
		ID++;
	};

	/**
	 * Constructor to set attribute
	 * 
	 * @param name
	 * @param password
	 * @param email
	 * @param phone
	 * @param location
	 * @param role
	 */
	public User(String name, String password, String email, String phone, String location, String role) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.location = location;
		this.role = role;
		this.id = ID;
		ID++;
	};

	/**
	 * Getter method to name
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	};

	/**
	 * Setter method to name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	};

	/**
	 * Getter method to password
	 * 
	 * @return String
	 */
	public String getPassword() {
		return password;
	};

	/**
	 * Setter method to password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	};

	/**
	 * Getter method to email
	 * 
	 * @return String
	 */
	public String getEmail() {
		return email;
	};

	/**
	 * Setter method to email
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	};

	/**
	 * Getter method to phone
	 * 
	 * @return String
	 */
	public String getPhone() {
		return phone;
	};

	/**
	 * Setter method to phone
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	};

	/**
	 * Getter method to location
	 * 
	 * @return String
	 */
	public String getLocation() {
		return location;
	};

	/**
	 * Setter method to location
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	};

	/**
	 * Getter method to role
	 * 
	 * @return String
	 */
	public String getRole() {
		return role;
	};

	/**
	 * Setter method to role
	 * 
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	};

	/**
	 * Getter method to id
	 * 
	 * @return integer
	 */
	public int getId() {
		return id;
	};

	/**
	 * Setter method to id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	};
}