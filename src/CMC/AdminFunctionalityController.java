package CMC;
import java.util.ArrayList;
import java.util.Collection;

/**
 * AdminFunctionalityController
 * 
 * @Version February 27, 2018
 */
public class AdminFunctionalityController {

	/**
	 * @return schools
	 */
	DBController dBController = new DBController();
	//AccountController accountController = new AccountController();

	public ArrayList<School> viewSchools() {
		return dBController.getAllSchools();
	}

	/**
	 * returns a school
	 * 
	 * @param name: String
	 * @return school
	 */
	public School viewSchool(String name) {

		return dBController.getSchool(name);
	}

	/**
	 * Adds a new school
	 * 
	 * @param school
	 * @return newSchool
	 */
	public boolean addNewSchool(String schoolName, String state, String location, String control, int numStudents,
			double percentFemale, int verbalSAT, int mathSAT, double expense, double percentFinancialAid,
			int numApplicants, double percentAdmit, double percentEnroll, int academicScale, int socialScale,
			int qualityOfLifeScale, Collection<String> areaOfStudy, String emphasis) {
		boolean newSchool = dBController.addNewSchool(schoolName, state, location, control, numStudents, percentFemale,
				verbalSAT, mathSAT, expense, percentFinancialAid, numApplicants, percentAdmit, percentEnroll,
				academicScale, socialScale, qualityOfLifeScale, areaOfStudy, emphasis);
		return newSchool;
	}

	/**
	 * Returns an array of accounts
	 * 
	 * @return user
	 */
	public ArrayList<Account> viewAccounts() {
		return dBController.getAccounts();
	}

	/**
	 * Creates a new user
	 * 
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param type
	 * 
	 */
	public void addNewUser(String firstName, String lastName, String username, String password, char type) {
		//accountController.createUser(firstName,lastName,username, password,type);
	}

	/**
	 * Deactivates a user with a given user
	 * 
	 * @param user
	 * 
	 */
	public void deactivateUser(Account user) {
		//user.accountController.deactivate();
	}

	/**
	 * Views an account
	 * 
	 * @param user
	 */
	public Account viewAccount(String name) {
		return dBController.getAccount(name);
	}
}