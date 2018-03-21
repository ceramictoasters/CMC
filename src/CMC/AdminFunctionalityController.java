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
	 * 
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param type
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
	//public char toggleActivation(User user) {
		//return dBController.toggleActivaton(user);
	//}

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
	public void editSchool(String name, String state, String location, String control, int numStudents,
            double percentFemale, int verbalSAT, int mathSAT, double expense, double percentFinAid,
            int numApplicants, double percentAdmit, double percentEnroll, int academicScale, 
            int socialScale, int qualityLifeScale, ArrayList<String> areasOfStudy)
	{
		schoolController.editSchool(name, state, location, control, numStudents,
            percentFemale, verbalSAT, mathSAT, expense, percentFinAid,
            numApplicants, percentAdmit, percentEnroll, academicScale, 
            socialScale, qualityLifeScale, areasOfStudy);
	}
}