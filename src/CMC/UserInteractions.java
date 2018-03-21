/**
 * UserInteractions.java is what user accounts interact with after logging in
 * 
 * @author Colin Tate
 * @version 2/27/17
 */
package CMC;

import java.util.Scanner;

public class UserInteractions {
	private UserFunctionalityController ufc = new UserFunctionalityController();

	/**
	 * Method that opens the GUI for the user to interact with Pre: Account must be
	 * a user
	 */
	public void userMenu() {
		int selection;
		Scanner input = new Scanner(System.in);

		System.out.println("Choose from these choices");
		System.out.println("-------------------------\n");
		System.out.println("1 - Search ");
		System.out.println("2 - View Saved Schools ");
		System.out.println("3 - View School ");
		System.out.println("4 - Save School ");
		System.out.println("5 - Remove School ");

		selection = input.nextInt();

		switch (selection) {
		case 1:
			displaySearch();
		case 2:
		case 3:
			System.out.print("Enter school name: ");
			String schoolToView = input.next();
			ufc.viewSchool(schoolToView);
		case 4:
			String schoolToSave = input.next();
		case 5:
			String schoolToRemove = input.next();
			;
		default:
			System.out.println("Unrecognized option");
			break;
		}
		input.close();
	}

	/**
	 * Method to display the search menu if the user selected it Pre: User selects
	 * to display school search
	 */
	public void displaySearch() {
		ufc.inputSearchData();
		ufc.viewSearchResults();
	}

	/**
	 * Method that displays a users save list Pre: User selects to display saved
	 * schools
	 */
	public void displaySavedSchools(User thisUser) {
		ufc.viewSavedSchools(thisUser);
	}

	/**
	 * Method that displays a users profile Pre: User selects to display profile
	 */
	public void displayProfile() {
		ufc.viewProfile();
	}

	public void saveSchool(User thisUser, String schoolName) {
		ufc.saveSchool(thisUser,schoolName);
		
	}
	
	public void removeSchool(User thisUser, String schoolName) {
		ufc.removeSchool(thisUser,schoolName);
		
	}

	public void viewSchool(String schoolName) {
		ufc.viewSchool(schoolName);
		
	}
}