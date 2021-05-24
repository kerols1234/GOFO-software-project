package project;

import java.util.Vector;

/**
 *
 * @author Omnia
 *
 */
public class PlaygroundOwner extends User {
	/**
	 * Attribute to save all objects of playground
	 */
	private Vector<Playground> Playgrounds = new Vector<Playground>();
	/**
	 * Attribute to save all email
	 */
	private Vector<String> masseges = new Vector<String>();
	/**
	 * Attribute to save the money which owner owned
	 */
	private double Ewallet;

	/**
	 * Default constructor and set Ewallet to zero
	 */
	public PlaygroundOwner() {
		super();
		Ewallet = 0;
	};

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
	public PlaygroundOwner(String name, String password, String email, String phone, String location, String role) {
		super(name, password, email, phone, location, role);
		Ewallet = 0;
	}

	/**
	 * Display all data of owner
	 */
	public void createProfile() {
		System.out.println("Name : " + getName() + " ,Email : " + getEmail() + " ,Phone : " + getPhone() + " ,ID : "
				+ getId() + " ,Ewallet : " + Ewallet);
		if (Playgrounds.size() == 0) {
			System.out.println("Owner has not any playgrounds yet");
		} else {
			System.out.println("Playgrounds owned by this owner " + Playgrounds.size() + " : ");
			for (int i = 0; i < Playgrounds.size(); i++) {
				Playgrounds.get(i).displayPlayground(1);
			}
		}
	}

	/**
	 * Add object of playground to his vector
	 * 
	 * @param obj
	 */
	public void addPlayground(Playground obj) {
		Playgrounds.add(obj);
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
	 * Book available hour in playground with this id and check if use have enough money
	 * 
	 * @param day
	 * @param id
	 * @param hour
	 * @param idOfPlayer
	 * @param money
	 * @return double
	 */
	public double bookAvailableHour(int day, int id, int hour, int idOfPlayer, double money) {
		boolean flag;
		for (int i = 0; i < Playgrounds.size(); i++) {
			if (Playgrounds.get(i).getId() == id) {
				if (money < Playgrounds.get(i).getPrice_hour()) {
					return -2;
				}
				flag = Playgrounds.get(i).setBookedHours(day, hour, true);
				if (flag) {
					deposit(Playgrounds.get(i).getPrice_hour());
					addMassege("playground of id : " + id + " has booked at day : " + day + " at hour : " + hour
							+ " by player with id : " + idOfPlayer);
					return (Playgrounds.get(i).getPrice_hour());
				}
				break;
			}
		}
		return -1;
	};

	/**
	 * Display available hour in all playground owned by owner
	 */
	public void displayAvaliableHourInAllPlayground() {
		System.out.println("Owner id : " + super.getId());
		for (int i = 0; i < Playgrounds.size(); i++) {
			Playgrounds.get(i).displayAvaliableHours();
		}
	};

	/**
	 * Display available hour in Playground with this id if it exists
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean displayAvaliableHourInSpecialPlayground(int id) {
		for (int i = 0; i < Playgrounds.size(); i++) {
			if (id == Playgrounds.get(i).getId()) {
				System.out.println("Owner id : " + super.getId());
				Playgrounds.get(i).displayAvaliableHours();
				return true;
			}
		}
		return false;
	};

	/**
	 * Display available hour in all playground at special hour or day owned by owner
	 * 
	 * @param start
	 * @param end
	 * @param choose
	 */
	public void displayAvaliableHourInAllPlaygroundAtSpecialHourOrDay(int start, int end, String choose) {
		System.out.println("Owner id : " + super.getId());
		for (int i = 0; i < Playgrounds.size(); i++) {
			Playgrounds.get(i).displayAvaliableHours(start, end, choose);
		}
	};

	/**
	 * Activate playground by send object of administrator and check if it correct id
	 * 
	 * @param admin
	 * @param id
	 * @return boolean
	 */
	public boolean activateplayground(Administrator admin, int id) {
		for (int i = 0; i < Playgrounds.size(); i++) {
			if (Playgrounds.get(i).getId() == id) {
				return Playgrounds.get(i).setActivation(admin);
			}
		}
		return false;
	};

	/**
	 * Display playground with this id
	 * 
	 * @param id
	 * @return boolean
	 */
	public boolean displayPlayground(int id) {
		for (int i = 0; i < Playgrounds.size(); i++) {
			if (Playgrounds.get(i).getId() == id) {
				Playgrounds.get(i).displayPlayground(0);
				return true;
			}
		}
		return false;
	};

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
}
