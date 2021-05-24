package project;

import java.util.Vector;

/**
 * 
 * @author Khaled
 *
 */
public class Team {
	/**
	 * Attribute to save name of team
	 */
	private String name;
	/**
	 * Attribute to save id of team
	 */
	private int id;
	/**
	 * Attribute to generate id without repeat
	 */
	private static int ID = 1;
	/**
	 * Attribute to save all players name
	 */
	private Vector<String> Playername = new Vector<String>();
	/**
	 * Attribute to save all players email
	 */
	private Vector<String> PlayerEmail = new Vector<String>();

	/**
	 * Default constructor
	 */
	public Team() {
		id = ID;
		ID++;
	};

	/**
	 * Constructor to set attribute
	 * 
	 * @param name
	 */
	public Team(String name) {
		this.name = name;
		id = ID;
		ID++;
	}

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
	 * Getter method to id
	 * 
	 * @return integer
	 */
	public int getId() {
		return id;
	}

	/**
	 * Display all data of team
	 */
	public void dispaly() {
		System.out.println("team's name is : " + name);
		System.out.println("team's id is : " + id);
		for (int i = 0; i < Playername.size(); i++) {
			System.out.println("name of player is : " + Playername.get(i) + " his email is : " + PlayerEmail.get(i));
		}
	}

	/**
	 * To add player ( name , email )
	 * 
	 * @param name
	 * @param email
	 */
	public void addplayer(String name, String email) {
		for (int i = 0; i < PlayerEmail.size(); i++) {
			if (PlayerEmail.get(i) == email) {
				return;
			}
		}
		Playername.add(name);
		PlayerEmail.add(email);
	}

	/**
	 * To get vector which save all players email
	 * 
	 * @return Vector<String>
	 */
	public Vector<String> getEmailsOfPlayers() {
		return PlayerEmail;
	};
}