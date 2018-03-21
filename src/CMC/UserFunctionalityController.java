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
	private ArrayList<School> results = new ArrayList<School>();
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
		String name = null;
		String state = null;
		String loc = null;
		String con = null;
		int nsl = -1;
		int nsh = -1;
		double fpl = -1;
		double fph = -1;
		int svl = -1;
		int svh = -1;
		int sml = -1;
		int smh = -1;
		int exl = -1;
		int exh = -1;
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

//		results = SearchController.search(name, state, loc, con, nsl, nsh, fpl, fph, svl, svh, sml, smh, exl, exh, fal, fah, nal, nah,
//				al, ah, el, eh, asl, ash, ssl, ssh, qll, qlh);
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
	 * @param sn selected school to view
	 */
	public void viewSchool(String sn) {
		System.out.println(dbHome.getSchool(sn));
//		School selectedSchool = dbHome.getSchool(sn);
//		
//		if(selectedSchool.equals(null))
//			System.out.println("Invalid school name:(");
//		else {
//			if(curUser.getSaved().contains(selectedSchool)) {
//				System.out.println(selectedSchool.toString()); //leave repetition till later
//			} else {
//				System.out.println(selectedSchool.toString()+"\n<>===RECOMENDATIONS===<>\n");
//				School[] rec = SearchController.getRecommendations(selectedSchool);
//				
//				int count = 0;
//				for(School s : rec)
//					System.out.println(count+". "+rec[count].toString());
//					count ++;
//			}
//		}
	}

	/**
	 * Method that add a school to the users save list Pre: Selected school cannot
	 * already be saved
	 * 
	 * @param s selected school to be saved
	 */
	public void saveSchool(User thisUser, String sn) {
		School selectedSchool = dbHome.getSchool(sn);
		dbHome.saveSchool(thisUser, selectedSchool);
		if(thisUser.getSaved().contains(selectedSchool))
			System.out.println(sn + " was saved previously.");
		else
			thisUser.saveSchool(selectedSchool);
			System.out.println(sn + " has been saved.");
	}

	/**
	 * Displays the users saved schools
	 */
	public void viewSavedSchools(User thisUser) {
		System.out.println("The User Has Saved: \n" +  thisUser.getSaved());
	}

	/**
	 * Method that removes a selected school from the users saved schools list
	 * 
	 * @param s selected school to be removed
	 */
	public void removeSchool(User thisUser, String sn) {
		School selectedSchool = dbHome.getSchool(sn);
		dbHome.removeSavedSchools(thisUser, selectedSchool);
		thisUser.removeSavedSchool(selectedSchool);
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
	public void editProfile(String f,String l,String p) {
		curUser.setFirst(f);
		curUser.setLast(l);
		curUser.setPassword(p);
	}
	
}
