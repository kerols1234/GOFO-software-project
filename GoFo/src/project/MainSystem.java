package project;

import java.util.Scanner;
import java.util.Vector;

/**
 * @author kerols
 */
public class MainSystem {
	/**
	 * Attribute vector of player object to save all objects of player
	 */
	private Vector<Player> players = new Vector<Player>();
	/**
	 * Attribute vector of owner object to save all objects of owner
	 */
	private Vector<PlaygroundOwner> owners = new Vector<PlaygroundOwner>();
	/**
	 * Default attribute of administrator
	 */
	private Administrator admin = new Administrator("ahmed", "123456", "XXXXX@gmail.com", "01234567890", "6-october",
			"administrator");

	/**
	 * Main method which control every thing Display menu to make user choose ( login or register or exit )
	 */
	public void mainMethod() {
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("1-Login");
			System.out.println("2-Register");
			System.out.println("3-Exit");
			int x;
			x = input.nextInt();
			if (x == 1) {
				login();
			} else if (x == 2) {
				register();
			} else if (x == 3) {
				System.out.println("Thank you for using this program");
				break;
			} else {
				System.out.println("Wrong input");
			}
		}
		return;
	};

	/**
	 * Method to create object from class user ( player or owner ) Make user enter data
	 */
	private void register() {
		Scanner input = new Scanner(System.in);
		String name, password1, password2, email, phone, location, role;
		System.out.println("Enter name : ");
		name = input.nextLine();
		System.out.println("Enter Password : ");
		password1 = input.nextLine();
		System.out.println("Re-enter Password : ");
		password2 = input.nextLine();
		while (true) {
			Scanner in = new Scanner(System.in);
			if (password1.equalsIgnoreCase(password2)) {
				break;
			}
			System.out.println("The two password not equal");
			System.out.println("Enter Password : ");
			password1 = in.nextLine();
			System.out.println("Re-enter Password : ");
			password2 = in.nextLine();
		}
		System.out.println("Enter Email : ");
		email = input.nextLine();
		while (!checkEmail(email)) {
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter correct Email");
			email = in.nextLine();
		}
		System.out.println("Enter phone : ");
		phone = input.nextLine();
		while (true) {
			Scanner in = new Scanner(System.in);
			if (phone.length() == 11) {
				break;
			}
			System.out.println("Please enter correct phone number");
			phone = in.nextLine();
		}
		System.out.println("Enter location : ");
		location = input.nextLine();
		System.out.println("Enter role(player, owner) : ");
		role = input.nextLine();
		while (true) {
			Scanner in = new Scanner(System.in);
			if (role.equalsIgnoreCase("player")) {
				Player object = new Player(name, password1, email, phone, location, role);
				players.add(object);
				profileOfPlayer(players.size() - 1);
				break;
			} else if (role.equalsIgnoreCase("owner")) {
				PlaygroundOwner object = new PlaygroundOwner(name, password1, email, phone, location, role);
				owners.add(object);
				profileOfowner(owners.size() - 1);
				break;
			}
			System.out.println("Wrong input");
			System.out.println("Enter player or owner : ");
			role = in.nextLine();
		}
	};

	/**
	 * Method to check email is correct or not
	 * 
	 * @param email
	 * @return boolean
	 */
	private boolean checkEmail(String email) {
		boolean x = false, y = false;
		for (int i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '.') {
				x = true;
			} else if (email.charAt(i) == '@') {
				y = true;
			}
		}
		if (x && y) {
			return true;
		}
		return false;
	};

	/**
	 * Method make user enter data and check if this data saved in system or not 
	 * 
	 * To make user login in system
	 */
	private void login() {
		Scanner input = new Scanner(System.in);
		String email, password, role;
		System.out.println("Enter Email : ");
		email = input.nextLine();
		System.out.println("Enter Password : ");
		password = input.nextLine();
		System.out.println("Enter Role(player, owner, administrator) : ");
		role = input.nextLine();
		if (role.equalsIgnoreCase("administrator")) {
			if (admin.getEmail().equalsIgnoreCase(email) && admin.getPassword().equalsIgnoreCase(password)
					&& admin.getRole().equalsIgnoreCase(role)) {
				profileOfadmin();
				return;
			} else {
				System.out.println("invalid email or password or role");
			}
		} else if (role.equalsIgnoreCase("player")) {
			for (int i = 0; i < players.size(); i++) {
				if (players.get(i).getEmail().equalsIgnoreCase(email)
						&& players.get(i).getPassword().equalsIgnoreCase(password)
						&& players.get(i).getRole().equalsIgnoreCase(role)) {
					profileOfPlayer(i);
					return;
				}
			}
		} else if (role.equalsIgnoreCase("owner")) {
			for (int i = 0; i < owners.size(); i++) {
				if (owners.get(i).getEmail().equalsIgnoreCase(email)
						&& owners.get(i).getPassword().equalsIgnoreCase(password)
						&& owners.get(i).getRole().equalsIgnoreCase(role)) {
					profileOfowner(i);
					return;
				}
			}
		}
		System.out.println("invalid email or password or role");
		return;
	};

	/**
	 * Method to display all data of player and small menu with all player options
	 * 
	 * Attribute index is position of object player in vector players
	 * 
	 * @param index
	 */
	private void profileOfPlayer(int index) {
		while (true) {
			Scanner input = new Scanner(System.in);
			players.get(index).displayInformation();
			System.out.println("1-Show all masseges");
			System.out.println("2-Create a team");
			System.out.println("3-Send invitation");
			System.out.println("4-Cancel booking");
			System.out.println("5-Book playground");
			System.out.println("6-View playground");
			System.out.println("7-deposit money to Ewallet");
			System.out.println("8-Logout");
			int x = input.nextInt();
			if (x == 1) {
				players.get(index).showAllMasseges();
			} else if (x == 2) {
				createTeam(index);
			} else if (x == 3) {
				sendInvitation();
			} else if (x == 4) {
				System.out.println("this option has not been added yet");
			} else if (x == 5) {
				bookPlayground(index);
			} else if (x == 6) {
				viewPlayground(index);
			} else if (x == 7) {
				System.out.println("Enter the amount of money : ");
				double money;
				money = input.nextDouble();
				players.get(index).deposit(money);
			} else if (x == 8) {
				break;
			} else {
				System.out.println("Wrong input");
			}
		}
	};

	/**
	 * Method to make user enter data of team and create object of team and add it in all players object in the team 
	 * 
	 * Attribute index is position of object player in vector players
	 * 
	 * @param index
	 */
	private void createTeam(int index) {
		Vector<String> playerEmails = new Vector<String>();
		Scanner input = new Scanner(System.in);
		String teamName = "", email = "", playerName = "";
		System.out.println("Enter name of team : ");
		teamName = input.nextLine();
		System.out.println("Number if player (not more than 7 player) : ");
		int x = input.nextInt();
		Team t = new Team();
		t.setName(teamName);
		for (int i = 0; i < x; i++) {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter name of player number " + (i + 1) + " : ");
			playerName = in.nextLine();
			System.out.println("Enter email of player number " + (i + 1) + " : ");
			email = in.nextLine();
			t.addplayer(playerName, email);
		}
		t.addplayer(players.get(index).getName(), players.get(index).getEmail());
		playerEmails = t.getEmailsOfPlayers();
		for (int i = 0; i < players.size(); i++) {
			for (int j = 0; j < playerEmails.size(); j++) {
				if (playerEmails.get(j).equalsIgnoreCase(players.get(i).getEmail())) {
					players.get(i).addTeam(t);
				}
			}
		}
	};

	/**
	 * Make user send message to another player or team
	 */
	private void sendInvitation() {
		Scanner input = new Scanner(System.in);
		String mss, email;
		int id;
		System.out.println("Emter the massege : ");
		mss = input.nextLine();
		System.out.println("You want to send massege to\n 1-team \n 2-player");
		int x = input.nextInt();
		if (x == 1) {
			System.out.println("Enter id of team : ");
			id = input.nextInt();
			boolean flag, flag2 = true;
			for (int i = 0; i < players.size(); i++) {
				flag = players.get(i).addMassege(mss, id);
				if (flag) {
					flag2 = false;
				}
			}
			if (flag2) {
				System.out.println("Wrong input");
			}
		} else if (x == 2) {
			String y;
			while (true) {
				Scanner in = new Scanner(System.in);
				System.out.println("Enter email of player : ");
				email = in.nextLine();
				boolean flag = true;
				for (int i = 0; i < players.size(); i++) {
					if (players.get(i).getEmail().equalsIgnoreCase(email)) {
						players.get(i).addMassege(mss);
						flag = false;
						break;
					}
				}
				if (flag) {
					System.out.println("Wrong input");
				}
				System.out.println("You want to send email to another player( y , n )");
				y = in.nextLine();
				if (y.equalsIgnoreCase("n")) {
					break;
				}
			}
		} else {
			System.out.println("Wrong input");
		}
	};

	/**
	 * Make user do a booking by enter the data of slot Attribute index is position of object player in vector players
	 * 
	 * @param index
	 */
	private void bookPlayground(int index) {
		Scanner input = new Scanner(System.in);
		int id1, id2, hour, day;
		double flag = -1;
		System.out.println("Enter the id of playground : ");
		id1 = input.nextInt();
		System.out.println("Enter the day : ");
		day = input.nextInt();
		System.out.println("Enter the hour : ");
		hour = input.nextInt();
		System.out.println("Enter owner id : ");
		id2 = input.nextInt();
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getId() == id2) {
				flag = owners.get(i).bookAvailableHour(day, id1, hour, players.get(index).getId(),
						players.get(index).getEwallet());
				if (flag != -1 && flag != -2) {
					players.get(index).withdraw(flag);
					players.get(index).addMassege("You are book hour : " + hour + " in day : " + day
							+ " at playground id : " + id1 + " which owner id : " + id2);
					System.out.println("Successful operation");
					return;
				}
				break;
			}
		}
		if (flag == -2) {
			System.out.println("you do not have enough money");
			return;
		}
		System.out.println("Wrong input");
	}

	/**
	 * Display all available hours in all playground Display option to user to filter it 
	 * 
	 * Attribute index is position of object player in vector players
	 * 
	 * @param index
	 */
	private void viewPlayground(int index) {
		for (int i = 0; i < owners.size(); i++) {
			owners.get(i).displayAvaliableHourInAllPlayground();
		}
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("1-Filter");
			System.out.println("2-Back");
			int x = input.nextInt();
			if (x == 1) {
				filter(index);
			} else if (x == 2) {
				break;
			} else {
				System.out.println("Wrong input");
			}
		}
	};

	/**
	 * Make user filter available hours in playground 
	 * 
	 * Attribute index is position of object player in vector players
	 * 
	 * @param index
	 */
	private void filter(int index) {
		Scanner input = new Scanner(System.in);
		System.out.println("1-Filter by id of owner");
		System.out.println("2-Filter by id of playground");
		System.out.println("3-Filter by day");
		System.out.println("4-Filter by hour");
		System.out.println("5-Back to profile");
		int x = input.nextInt();
		if (x == 1) {
			System.out.println("Enter id of owner");
			int id = input.nextInt();
			for (int i = 0; i < owners.size(); i++) {
				if (id == owners.get(i).getId()) {
					owners.get(i).displayAvaliableHourInAllPlayground();
					return;
				}
			}
			System.out.println("Wrong input");
		} else if (x == 2) {
			System.out.println("Enter id of playground");
			int id = input.nextInt();
			boolean flag;
			for (int i = 0; i < owners.size(); i++) {
				flag = owners.get(i).displayAvaliableHourInSpecialPlayground(id);
				if (flag) {
					return;
				}
			}
			System.out.println("Wrong input");
		} else if (x == 3) {
			int start, end;
			while (true) {
				Scanner in = new Scanner(System.in);
				System.out.println("Enter two days from to in two different line (min 1 : max 31) : ");
				start = in.nextInt();
				end = in.nextInt();
				if (start > 0 && end < 32) {
					break;
				}
				System.out.println("Wrong input");
			}
			for (int i = 0; i < owners.size(); i++) {
				owners.get(i).displayAvaliableHourInAllPlaygroundAtSpecialHourOrDay(start - 1, end - 1, "day");
			}
		} else if (x == 4) {
			int start, end;
			while (true) {
				Scanner in = new Scanner(System.in);
				System.out.println("Enter two hours from to in two different line (min 0 : max 24) : ");
				start = in.nextInt();
				end = in.nextInt();
				if (start > -1 && end < 25) {
					break;
				}
				System.out.println("Wrong input");
			}
			for (int i = 0; i < owners.size(); i++) {
				owners.get(i).displayAvaliableHourInAllPlaygroundAtSpecialHourOrDay(start, end, "hour");
			}
		} else if (x != 5) {
			System.out.println("Wrong input");
		}
	};

	/**
	 * Method to display all data of administrator and small menu with all administrator options
	 */
	private void profileOfadmin() {
		while (true) {
			Scanner input = new Scanner(System.in);
			admin.displayInfo();
			System.out.println("1-Show all masseges");
			System.out.println("2-Suspend");
			System.out.println("3-Delete");
			System.out.println("4-Activate");
			System.out.println("5-Aprove");
			System.out.println("6-Logout");
			int x = input.nextInt();
			if (x == 1) {
				admin.displaymasseges();
			} else if (x == 2) {
				System.out.println("this option has not been added yet");
			} else if (x == 3) {
				System.out.println("this option has not been added yet");
			} else if (x == 4) {
				System.out.println("this option has not been added yet");
			} else if (x == 5) {
				activatPlayground();
			} else if (x == 6) {
				break;
			} else {
				System.out.println("Wrong input");
			}
		}
	};

	/**
	 * Make administrator approve playground
	 */
	private void activatPlayground() {
		Scanner input = new Scanner(System.in);
		int id1, id2;
		boolean flag;
		System.out.println("Enter id of playground : ");
		id1 = input.nextInt();
		System.out.println("Enter id of owner : ");
		id2 = input.nextInt();
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getId() == id2) {
				System.out.println("Data of playground : ");
				owners.get(i).displayPlayground(id1);
				break;
			}
		}
		for (int i = 0; i < owners.size(); i++) {
			if (owners.get(i).getId() == id2) {
				flag = owners.get(i).activateplayground(admin, id1);
				if (flag) {
					return;
				}
			}
		}
		System.out.println("Wrong input");
	};

	/**
	 * Method to display all data of owner and small menu with all owner options
	 *
	 * Attribute index is position of object owner in vector owners
	 * 
	 * @param index
	 */
	private void profileOfowner(int index) {
		while (true) {
			Scanner input = new Scanner(System.in);
			owners.get(index).createProfile();
			System.out.println("1-Show all masseges");
			System.out.println("2-Add playground");
			System.out.println("3-Check ewllat");
			System.out.println("4-Update playground");
			System.out.println("5-View bookings");
			System.out.println("6-Logout");
			int x = input.nextInt();
			if (x == 1) {
				owners.get(index).showAllMasseges();
			} else if (x == 2) {
				addPlayground(index);
			} else if (x == 3) {
				System.out.print("Your money in Ewallet : ");
				System.out.println(owners.get(index).getEwallet());
			} else if (x == 4) {
				System.out.println("this option has not been added yet");
			} else if (x == 5) {
				System.out.println("this option has not been added yet");
			} else if (x == 6) {
				break;
			} else {
				System.out.println("Wrong input");
			}
		}
	};

	/**
	 * Make owner add play ground by enter data of it 
	 * 
	 * Attribute index is position of object owner in vector owners
	 * 
	 * @param index
	 */
	private void addPlayground(int index) {
		Scanner input = new Scanner(System.in);
		String name, size, location, period;
		int price, number, h, d;
		System.out.println("Enter name of playground : ");
		name = input.nextLine();
		System.out.println("Enter size of playground (L : W) : ");
		size = input.nextLine();
		System.out.println("Enter location of playground : ");
		location = input.nextLine();
		System.out.println("Enter period of playground like(3d or 2h) : ");
		period = input.nextLine();
		System.out.println("Enter price per hour : ");
		price = input.nextInt();
		Playground ground = new Playground(name, size, owners.get(index).getName(), location, period, price);
		System.out.println("Enter number of hours was available : ");
		number = input.nextInt();
		System.out.println("Enter day then hour in two different line (day [1,30] hour [0,23] : ");
		for (int i = 0; i < number; i++) {
			Scanner in = new Scanner(System.in);
			d = in.nextInt();
			h = in.nextInt();
			if (d > 0 && d < 31 && h > -1 && h < 24) {
				ground.addAvailabeHours(d, h);
			}
		}
		owners.get(index).addPlayground(ground);
		admin.addmassge("Owner wit id : " + owners.get(index).getId() + " make requst to add playground with id : "
				+ ground.getId());
	}

}
