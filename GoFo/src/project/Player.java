package project;

import java.util.Vector;

/**
 * @author kerols
 */
public class Player extends User {
	/**
	 * Attribute to save all objects of team
	 */
	private Vector<Team> teams = new Vector<Team>();
	/**
	 * Attribute to save all email
	 */
	private Vector<String> masseges = new Vector<String>();
	/**
	 * Attribute to save the money which player owned
	 */
	private double Ewallet;

	/**
	 * Constructor to set attribute and set Ewallet to zero
	 * 
	 * @param name
	 * @param password
	 * @param email
	 * @param phone
	 * @param location
	 * @param role
	 */
	public Player(String name, String password, String email, String phone, String location, String role) {
		super(name, password, email, phone, location, role);
		Ewallet = 0;
	}

	/**
	 * Default constructor and set Ewallet to zero
	 */
	public Player() {
		super();
		Ewallet = 0;
	}

	/**
	 * Make player enter amount of money to the Ewallet
	 * 
	 * @param amountMoney
	 */
	public void deposit(double amountMoney) {
		Ewallet += amountMoney;
	};

	/**
	 * Make player get amount of money from this Ewallet
	 * 
	 * @param amountMoney
	 * @return boolean
	 */
	public boolean withdraw(double amountMoney) {
		if (amountMoney > Ewallet) {
			return false;
		}
		Ewallet -= amountMoney;
		return true;
	};

	/**
	 * Make player know how much money in this Ewallet?
	 * 
	 * @return double
	 */
	public double getEwallet() {
		return Ewallet;
	};

	/**
	 * Display all data of player
	 */
	public void displayInformation() {
		System.out.println("Name of player : " + super.getName());
		System.out.println("ID of player : " + super.getId());
		System.out.println("Email of player : " + super.getEmail());
		System.out.println("phone of player : " + super.getPhone());
		System.out.println("Location of player : " + super.getLocation());
		System.out.println("Money in the Ewallet : " + Ewallet);
		System.out.println("Player have " + teams.size() + " teams");
		for (int i = 0; i < teams.size(); i++) {
			System.out.println("team number " + (i + 1) + " : ");
			teams.get(i).dispaly();
		}
	}

	/**
	 * Add object of team to his vector
	 * 
	 * @param t
	 */
	public void addTeam(Team t) {
		for (int i = 0; i < teams.size(); i++) {
			if (teams.get(i).getId() == t.getId()) {
				return;
			}
		}
		teams.add(t);
	}

	/**
	 * Display all email of player
	 */
	public void showAllMasseges() {
		if (masseges.isEmpty()) {
			System.out.println("there is no message");
		} else {
			for (int i = masseges.size() - 1, j = 1; i > -1; i--, j++) {
				System.out.println("massege " + j + " : " + masseges.get(i));
			}
		}
	}

	/**
	 * Add email to his vector
	 * 
	 * @param massege
	 */
	public void addMassege(String massege) {
		masseges.add(massege);
	}

	/**
	 * Add email to his vector if the id of team is one of team id which user have it
	 * 
	 * @param massege
	 * @param id
	 * @return boolean
	 */
	public boolean addMassege(String massege, int id) {
		for (int i = 0; i < teams.size(); i++) {
			if (teams.get(i).getId() == id) {
				masseges.add(massege);
				return true;
			}
		}
		return false;
	}
}
