package CMC;
import java.util.ArrayList;
import java.util.Collection;

/** 
 * AdminFunctionalityController connects the Admin Functionalities to the database
 * 
 * @author  Richard Morris
 * @version February 26, 2018
 */
public class AdminFunctionalityController {

	/**
	 * Instance of DBController
	 */
	private DBController dBController = new DBController();
	private SchoolController schoolController = new SchoolController();
	/** 
	 * Views all the schools in the database
	 * 
	 * @return a list of schools
	 */
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
	public boolean addNewSchool(School school) {
		boolean newSchool = dBController.addNewSchool(school);
		return newSchool;
	}
	/**
	 * Removes a given school
	 * 
	 * @param school
	 * @return the removed school
	 */
	public boolean removeSchool(School school)
	{
		boolean removedSchool = dBController.deleteSchool(school);
		return removedSchool;
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
	 * @param account : Account
	 * 
	 */
	public boolean addNewAccount(Account account) {
		return dBController.addAccount(account);
	}

	/**
	 * Deactivates a user with a given user
	 * 
	 * @param user
	 * 
	 */
	public User toggleActivation(User activeUser) {
		dBController.toggleActivaton(activeUser);
		char currentStatus = activeUser.getStatus();
		if(currentStatus=='Y') {
			activeUser.setStatus('N');
		}
		else if(currentStatus=='N') {
			activeUser.setStatus('Y');

		}
		return activeUser;
	}

	/**
	 * Views an account
	 * 
	 * @param user
	 */
	public Account viewAccount(String name) {
		return dBController.getAccount(name);
	}
	/**
	 * EditSchool
	 * 
	 * @param TBD
	 */
	public boolean editSchool(String name, String state, String location, String control, int numStudents,
            double percentFemale, int verbalSAT, int mathSAT, double expense, double percentFinAid,
            int numApplicants, double percentAdmit, double percentEnroll, int academicScale, 
            int socialScale, int qualityLifeScale, ArrayList<String> areasOfStudy)
	{
		return schoolController.editSchool(name, state, location, control, numStudents,
            percentFemale, verbalSAT, mathSAT, expense, percentFinAid,
            numApplicants, percentAdmit, percentEnroll, academicScale, 
            socialScale, qualityLifeScale, areasOfStudy);
	}
	/**
	 * Deletes an Account
	 * @param account
	 * @return
	 */
	public boolean deleteAccount(Account account) {
		boolean deletedAccount = dBController.deleteUser(account);
		return deletedAccount;
	}
	/**
	 * Edits an Account
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param type
	 * @param status
	 * @return
	 */
	public boolean editAccount(String username, String password, String firstName, String lastName, char type, char status ) {
		boolean editedAccount = dBController.editAccount(username, password, firstName, lastName, type, status);
		return editedAccount;
	}
}