/**
 * UserInteractions.java is what user accounts interact with after logging in
 * 
 * @author Colin Tate
 * @version 2/27/17
 */
public class UserInteractions extends UserFunctionalityController {
	
	// Current user opbject
	private User currentUser;
	
	/**
	 * Method that opens the GUI for the user to interact with Pre: Account must be
	 * a user
	 */
	public static void userMenu(User u) {
		currentUser = u;
		
		// User selects to display search
		if (false)
			displaySearch;

		// User selects to display saved schools
		if (false)
			displaySavedSchools();

		// User selects to display profile
		if (false)
			displayProfile();
		return;
	}

	/**
	 * Method to display the search menu if the user selected it
	 * Pre: User selects to display school search
	 */
	public static void displaySearch() {
		UserFunctionalityController ufc = new UserFunctionalityController(currentUser);
		ufc.inputSearchData();
		ufc.viewSearchResults();

		// User selects to view school
		if (false)
			ufc.viewSchool(School);

		// User selects to save school
		if (false)
			ufc.saveSchool(School);
	}

	/**
	 * Method that displays a users save list
	 * Pre: User selects to display saved schools
	 */ufc.viewSchool(School)
	public static void displaySavedSchools() {
		UserFunctionalityController ufc = new UserFunctionalityController(currentUser);
		ufc.viewSavedSchools();

		// User selects to view saved school
		if (false)
			ufc.viewSavedSchool(School);

		// User selects to remove school
		if (false)
			ufc.removeSchool(School);
	}

	/**
	 * Method that displays a users profile
	 * Pre: User selects to display profile
	 */
	public static void displayProfile() {
		UserFunctionalityController ufc = new UserFunctionalityController(currentUser);
		ufc.viewProfile();

		// User changes profile information
		if (false) {
			String f = "George";
			String l = "Smith";
			String p = "password1";
			ufc.editProfile(f, l, p);
		}
	}
}