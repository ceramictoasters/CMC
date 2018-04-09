package CMC;
import java.util.*;

/**
 * UserFunctionalityController.java does all of the work for the User
 * interactions class
 * 
 * @author Colin Tate
 * @version 2/27/17
 */
public class UserFunctionalityController {
	private User curUser = (User)LogOn.getCurrentAccount();
	private ArrayList<School> results;
	DBController dbHome = new DBController();
	
	/**
	 * Contructor for the UFC
	 */
	public UserFunctionalityController() {
		curUser = (User)LogOn.getCurrentAccount();
		results = new ArrayList<School>();
		dbHome = new DBController();
	}
	
	/**
	 * Method that has the user input the search data and sets the search results
	 */
	public void inputSearchData() {
		// Variables to be set by user
		String name = "";
		String state = "";
		String loc = "";
		String con = "";
		int nsl = 20000;
		int nsh = 41000;
		double fpl = 40;
		double fph = 65;
		int svl = 400;
		int svh = 800;
		int sml = 400;
		int smh = 800;
		int exl = 1100;
		int exh = 20000;
		double fal = 40;
		double fah = 90;
		int nal = 1000;
		int nah = 7000;
		double al = -1;
		double ah = -1;
		double el = 60;
		double eh = 100;
		int asl = 1;
		int ash = 60;
		int ssl = 1;
		int ssh = 5;
		int qll = 1;
		int qlh = 5;
		ArrayList<String> emp = new ArrayList<String>();
		emp.add("Something");
		emp.add("Something");
		System.out.println("Search input:\nschoolName - N/A\nstate - N/A\nlocation - N/A\ncontrol - N/A\n"
				+ "numberOfStudentsL - 20000\nnumberOfStudentsH - 41000\nfemaleL - 40\nfemaleH - 65\n"
		  		+ "verbalSATL - 400\nverbalSATH - 800\nmathSATL - 400\nmathSATH - 800\n"
		  		+ "expensesL - 1100\nexpensesH - 20000\naidL - 40\naidH - 90\napplicantsL - 1000 \napplicantsH - 7000\n"
		  		+ "perAdmittedL - N/A\nperAdmittedH - N/A\nperEnrolledL - 60\nperEnrolledH - 100\n"
		  		+ "academicScaleL - 1\nacademicScaleH - 60\nsocialScaleL - 1\nsocialScaleH - 5\n"
		  		+ "qualityScaleL - 1 \nqualityScaleH - 5\nemphasis - N/A\n");
		SearchControllerV2 sc = new SearchControllerV2();
		results = sc.search(name, state, loc, con, nsl, nsh, fpl, fph, svl, svh, sml, smh, exl, exh, fal, fah, nal, nah,
				al, ah, el, eh, asl, ash, ssl, ssh, qll, qlh, emp);
		System.out.println(results);
	}

	/**
	 * Method that will display the search results to the users GUI
	 */
	public ArrayList<School> viewSearchResults() {
		return results;
	}
	
	/**
	 * Method that will display a selected school
	 * Pre: User selects a school
	 * 
	 * @param sn selected school to view
	 */
	public School viewSchool(String sn) {
		return dbHome.getSchool(sn);
	}

	/**
	 * Method that add a school to the users save list Pre: Selected school cannot
	 * already be saved
	 * 
	 * @param s selected school to be saved
	 */
	public boolean saveSchool(User thisUser, String sn) {
		School selectedSchool = dbHome.getSchool(sn);
		if(selectedSchool==null) {
			System.out.println(sn + " is not a valid school.");
		} else if(thisUser.getSaved().contains(selectedSchool)) {
			System.out.println(sn + " was saved previously.");
		} else {
			dbHome.saveSchool(curUser, selectedSchool);
			thisUser.saveSchool(selectedSchool);
			System.out.println(sn + " has been saved.");
			return true;
		}
		return false;
	}

	/**
	 * Displays the users saved schools
	 */
	public ArrayList<School> viewSavedSchools(User thisUser) {
		//System.out.println("The User Has Saved: \n" +  thisUser.getSaved());
		if(dbHome.getAccount(thisUser.getUsername()).equals(null))
			throw new NullPointerException();
		else
			return thisUser.getSaved();
	}

	/**
	 * Method that removes a selected school from the users saved schools list
	 * 
	 * @param s selected school to be removed
	 */
	public boolean removeSchool(User thisUser, String sn) {
		School selectedSchool = dbHome.getSchool(sn);
		if(selectedSchool==null) {
			System.out.println(sn + " is not a valid school.");
		} else if(!(thisUser.getSaved().contains(selectedSchool))) {
			System.out.println(sn + " was not saved previously.");
		} else {
			dbHome.removeSavedSchools(thisUser, selectedSchool);
			thisUser.removeSavedSchool(selectedSchool);
			System.out.println(sn + " has been removed.");
			return true;
		}
		return false;
	}

	/**
	 * Method that displays the profile of the user
	 */
	public User viewProfile() {
		//System.out.println(curUser);
		return curUser;
	}

	/**
	 * Method to edit user's information
	 * 
	 * @return true if profile changes are valid
	 */
	public void editProfile(String f,String l,String p) {
		curUser.setFirst(f);
		curUser.setLast(l);
		curUser.setPassword(p);
	}
	
}
