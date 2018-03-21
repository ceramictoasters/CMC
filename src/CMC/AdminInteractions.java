package CMC;

import java.util.*;

/**
 * AdminInteractions is the interface for the Admin Functionalites
 * 
 * @author Richard Morris
 * @version February 26, 2018
 */
public class AdminInteractions {
	private AdminFunctionalityController adminFunctionalityController = new AdminFunctionalityController();

	public ArrayList<School> displaySchools() {
		return adminFunctionalityController.viewSchools();
	}

	public ArrayList<Account> displayAccounts() {
		return adminFunctionalityController.viewAccounts();
	}

	public static void adminMenu(Account acc) {

		int selection;
		Scanner input = new Scanner(System.in);

		System.out.println("Choose from these choices");
		System.out.println("-------------------------\n");
		System.out.println("1 - View School ");
		System.out.println("2 - View Schools ");
		System.out.println("3 - Add New Schools ");
		System.out.println("4 - View Accounts ");
		System.out.println("5 - Add New User ");
		System.out.println("6 - Deactivate User ");
		System.out.println("7 - View Account ");

		selection = input.nextInt();

		switch (selection) {
		case 1:
			System.out.println("You picked option 1");
			break;
		case 2:
			System.out.println("You picked option 2");
			break;
		case 3:
			System.out.println("You picked option 3");
			break;
		case 4:
			System.out.println("You picked option 4");
		case 5:
			System.out.println("You picked option 5");
		case 6:
			System.out.println("You picked option 6");
		case 7:
			System.out.println("You picked option 7");
		default:
			System.out.println("Unrecognized option");
			break;
		}
	}
}