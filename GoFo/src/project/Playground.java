package project;

/**
 * 
 * @author Mohamed Saeed
 *
 */
public class Playground {
	/**
	 * Attributes to save name, size, owner name, location, period of cancellation
	 */
	private String name, size, ownerName, location, cancellitionPeriod;
	/**
	 * Attributes of price per hour and id of playground
	 */
	private int price_hour, id;
	/**
	 * Attribute to generate id without repeat
	 */
	private static int ID = 1;
	/**
	 * Attribute to save if playground active or not
	 */
	private boolean activation;
	/**
	 * Attribute to save all available hours
	 */
	private boolean availableHours[][] = new boolean[30][24];
	/**
	 * Attribute to save all booked hours
	 */
	private boolean bookedHours[][] = new boolean[30][24];

	/**
	 * Getter method to name
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter method to name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter method to size
	 * 
	 * @return String
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Setter method to size
	 * 
	 * @param size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Getter method to owner name
	 * 
	 * @return String
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * Setter method to owner name
	 * 
	 * @param ownerName
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * Getter method to location
	 * 
	 * @return String
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Setter method to location
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Getter method to period of cancellation
	 * 
	 * @return String
	 */
	public String getCancellitionPeriod() {
		return cancellitionPeriod;
	}

	/**
	 * Setter method to period of cancellation
	 * 
	 * @param cancellitionPeriod
	 */
	public void setCancellitionPeriod(String cancellitionPeriod) {
		this.cancellitionPeriod = cancellitionPeriod;
	}

	/**
	 * Getter method to price per hour
	 * 
	 * @return integer
	 */
	public int getPrice_hour() {
		return price_hour;
	}

	/**
	 * Setter method to price per hour
	 * 
	 * @param price_hour
	 */
	public void setPrice_hour(int price_hour) {
		this.price_hour = price_hour;
	}

	/**
	 * Getter method to id
	 * 
	 * @return integer
	 */
	public int getId() {
		return id;
	};

	/**
	 * Getter method to activation of playground ( active or not )
	 * 
	 * @return
	 */
	public boolean isActivation() {
		return activation;
	}

	/**
	 * Setter method to activation of playground ( active or not ) by administrator
	 * 
	 * @param admin
	 * @return boolean
	 */
	public boolean setActivation(Administrator admin) {
		if (admin.getEmail().equalsIgnoreCase("XXXXX@gmail.com") && admin.getId() == 0) {
			activation = true;
			System.out.println("Successful operation");
			return true;
		}
		return false;
	};

	/**
	 * Add available hour
	 * 
	 * @param day
	 * @param hour
	 */
	public void addAvailabeHours(int day, int hour) {
		availableHours[day - 1][hour] = true;
	}

	/**
	 * Setter method to Booked Hours
	 * 
	 * @param day
	 * @param hour
	 * @param flag
	 * @return boolean
	 */
	public boolean setBookedHours(int day, int hour, boolean flag) {
		if (activation && availableHours[day - 1][hour]) {
			bookedHours[day - 1][hour] = flag;
			return true;
		}
		return false;
	}

	/**
	 * Default constructor
	 */
	public Playground() {
		activation = false;
		id = ID;
		ID++;
	}

	/**
	 * Constructor to set attribute
	 * 
	 * @param name
	 * @param size
	 * @param ownerName
	 * @param location
	 * @param cancellitionPeriod
	 * @param price_hour
	 */
	public Playground(String name, String size, String ownerName, String location, String cancellitionPeriod,
			int price_hour) {
		this.name = name;
		this.size = size;
		this.ownerName = ownerName;
		this.location = location;
		this.cancellitionPeriod = cancellitionPeriod;
		this.price_hour = price_hour;
		this.id = ID;
		ID++;
		activation = false;
	}

	/**
	 * Display all data of playground
	 * 
	 * @param id
	 */
	public void displayPlayground(int id) {
		if (activation == true || id == 0) {
			System.out.println("ID of the playground : " + this.id);
			System.out.println("Name of the playground : " + name);
			System.out.println("Size of playground : " + size);
			System.out.println("name of the owner : " + ownerName);
			System.out.println("Location of the playground : " + location);
			System.out.println("CancellitionPeriod of the playground : " + cancellitionPeriod);
			System.out.println("Price of one hour : " + price_hour);
			System.out.println("availabe Hours in the playground (day , hour , booked or not) : ");
			System.out.println("[ ");
			for (int i = 0; i < 30; i++) {
				for (int j = 0; j < 24; j++) {
					if (availableHours[i][j]) {
						System.out.println(i + 1 + " , " + j + " , " + bookedHours[i][j]);
					}
				}
			}
			System.out.println("]");
		} else {
			System.out.println("Playground with id : " + id + " is not active");
		}
	};

	/**
	 * Display all available hours
	 */
	public void displayAvaliableHours() {
		if (activation) {
			System.out.println("Playground id : " + id);
			System.out.println("availabe Hours in the playground (day , hour , booked or not) : ");
			System.out.println("[ ");
			for (int i = 0; i < 30; i++) {
				for (int j = 0; j < 24; j++) {
					if (availableHours[i][j] && !bookedHours[i][j]) {
						System.out.println(i + 1 + " , " + j + " , " + bookedHours[i][j]);
					}
				}
			}
			System.out.println("]");
		} else {
			System.out.println("Playground with id : " + id + " is not active");
		}
	};

	/**
	 * Display available hours with this day and hour
	 * 
	 * @param from
	 * @param to
	 * @param choose
	 */
	public void displayAvaliableHours(int from, int to, String choose) {
		if (activation) {
			System.out.println("Playground id : " + id);
			int start1 = 0, start2 = 0, end1 = 30, end2 = 24;
			if (choose.equalsIgnoreCase("day")) {
				start1 = from;
				end1 = to;
			} else {
				start1 = from;
				end1 = to;
			}
			System.out.println("availabe Hours in the playground : ");
			System.out.println("[ ");
			for (int i = start1; i < end1; i++) {
				for (int j = start2; j < end2; j++) {
					if (availableHours[i][j] && !bookedHours[i][j]) {
						System.out.println("Day : " + i + 1 + " , Hour : " + j);
					}
				}
			}
			System.out.println("]");
		} else {
			System.out.println("Playground with id : " + id + " is not active");
		}
	};
}
