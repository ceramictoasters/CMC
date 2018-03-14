/**
 * UserInteractions.java is what user accounts interact with after logging in
 * 
 * @author Colin Tate
 * @version 2/27/17
 */
package CMC;

import java.util.Scanner;

public class UserInteractions extends UserFunctionalityController {
	
	// Current user opbject
	private User currentUser;
	
	/**
	 * Method that opens the GUI for the user to interact with Pre: Account must be
	 * a user
	 */
	public static void userMenu(User u) {
		currentUser = u;
		UserFunctionalityController ufc = new UserFunctionalityController(currentUser);
		
	    
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
	    
	    switch ( selection ) 
	    {
	      case 1:
	        displaySearch();
	      case 2:
	        displaySavedSchools();
	      case 3:
	    	String schoolToView = input.next();
	    	ufc.viewSchool(schoolToView);
	      case 4:
	    	String schoolToSave = input.next();
	        ufc.saveSchool(schoolToSave);;
	      case 5:
	    	String schoolToRemove = input.next();
		    ufc.removeSchool(schoolToRemove);;
	      default:
	        System.out.println ( "Unrecognized option" );
	        break;
	    }    
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
	 */
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