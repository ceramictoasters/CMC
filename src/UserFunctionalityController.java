import java.util.*;

/**
 * UserFunctionalityController.java does all of the work for the User
 * interactions class
 * 
 * @author Colin Tate
 * @version 2/27/17
 */
public class UserFunctionalityController extends SearchController, User, School {
	private User curUser;
	private ArrayList<School> results = new ArrayList<School>;

	/**
	 * UFController main constructor that sets the current user	
	 * 
	 * @param u current user
	 */
	public UserFunctionalityController(User u) {
		curUser = u;
	}
	
	/**
	 * Method that has the user input the search data and sets the search results
	 */
	public void inputSearchData() {
		// Variables to be set by user
		String name = null;
		String state = null;
		String loc = null;
		curtUser.set
		String con = null;
		int nsl = -1;
		int nsh = -1;
		double fpl = -1;
		double fph = -1;
		int svl = -1;
		int svh = -1;
		int sml = -1;
		int smh = -1;
		double exl = -1;
		double exh = -1;
		double fal = -1;
		double fah = -1;
		int nal = -1;
		int nah = -1;
		double al = -1;
		double ah = -1;
		double el = -1;
		double eh = -1;
		int asl = -1;
		int ash = -1;
		int ssl = -1;
		int ssh = -1;
		int qll = -1;
		int qlh = -1;
		String[] emp = null;

		results = search(name, state, loc, con, nsl, nsh, fpl, fph, svl, svh, sml, smh, exl, exh, fal, fah, nal, nah,
				al, ah, el, eh, asl, ash, ssl, ssh, qll, qlh, emp);
	}

	/**
	 * Method that will display the search results to the users GUI
	 */
	public void viewSearchResults() {
		System.out.println(results);
	}

	/**
	 * Method that will display a selected school
	 * Pre: User selects a school
	 * 
	 * @param s selected school to view
	 */
	public void viewSchool(School s) {
		ArrayList<School> rec = getRecommendations(s);
		System.out.println(s+"\n"+rec);
	}

	/**
	 * Method that add a school to the users save list Pre: Selected school cannot
	 * already be saved
	 * 
	 * @param s selected school to be saved
	 */
	public void saveSchool(School s) {
		if (saveSchool(s))
			System.out.println(s.getName() + " has been saved.");
		else
			System.out.println(s.getName() + " was saved previously.");
	}

	/**
	 * Displays the users saved schools
	 */
	public void viewSavedSchools() {
		System.out.println(curUser.getSaved()));
	}

	/**
	 * Display the selected saved school
	 * 
	 * @param s selected school to display
	 */
	public void viewSavedSchool(School s) {
		System.out.println(s);
	}

	/**
	 * Method that removes a selected school from the users saved schools list
	 * 
	 * @param s selected school to be removed
	 */
	public void removeSchool(School s) {
		curUser.removeSaved(s);
	}

	/**
	 * Method that displays the profile of the user
	 */
	public void viewProfile() {
		System.out.println(curUser);
	}

	/**
	 * Method to edit user's information
	 * 
	 * @return true if profile changes are valid
	 */
	public boolean editProfile(String f,String l,String p) {
		curUser.setFirst(f);
		curUser.setLast(l);
		curUser.setPassword(p);
	}
}
