package CMC;
import java.util.ArrayList;
import java.util.Collection;

/** 
 * AdminFunctionalityController connects the Admin Functionalities to the database
 * 
 * @author  Richard Morris
 * @version April 5, 2018
 */
public class AdminFunctionalityController {

	/**
	 * Instance of DBController
	 */
	private DBController dBController = new DBController();
	/**
	 * Instance of SchoolController
	 */
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
	 * @param name The name of the school
	 * @return The desired school
	 */
	public School viewSchool(String name) {

		return dBController.getSchool(name);
	}

	/**
	 * Adds a new school
	 * 
	 * @param school The school object that should be added to the database
	 * @return true if the school is added, false if not
	 */
	public boolean addNewSchool(School school) {
		if (school == null)
		{
			System.out.println("You cant pass an null object");
		}
		else if(school.equals(dBController.getSchool(school.getName())))
		{
			System.out.println("The school is already in the database");
		}
		

			boolean newSchool = dBController.addNewSchool(school);
			return newSchool;
		
	}
	/**
	 * Removes a given school
	 * 
	 * @param school The school object that should be removed from the database
	 * @return true if school is removed, false if not
	 */
	public boolean removeSchool(School school)
	{
		try {
		boolean removedSchool = dBController.deleteSchool(school);
		return removedSchool;
		}
		catch(IllegalArgumentException illArg) {
			//System.out.println(illArg.getMessage());
			return false;

		}
	}
	/**
	 * Returns an array of accounts
	 * 
	 * @return An array list of schools from the database
	 */
	public ArrayList<Account> viewAccounts() {
		return dBController.getAccounts();
	}

	/**
	 * Creates a new account
	 * 
	 * @param account The account object which should be added to the database
	 * @return true if the account is added, false if not
	 */
	public boolean addNewAccount(Account account) {
		if (account == null)
		{
			System.out.println("You cant pass an null object");
		}
		else if(account.equals(dBController.getAccount(account.getUsername())))
		{
			System.out.println("The account is already in the database");
		}
		return dBController.addAccount(account);
	}

	/**
	 * Deactivates the given user
	 * 
	 * @param user The user that should be deactivated
	 * @return the user object with their status changed
	 * 
	 */
	public char toggleActivation(User activeUser) {
		if (activeUser == null)
		{
			System.out.println("You cant pass an null object");
		}
		char activation = dBController.toggleActivaton(activeUser);
		return activation;
	}

	/**
	 * Views an account
	 * 
	 * @param username THe user name of the account that is desired
	 * @return the account that was given
	 */
	public Account viewAccount(String userName) {
		return dBController.getAccount(userName);
	}
	
	/**
	 * Edits a Schools information
	 * @param name 
	 * @param state
	 * @param location
	 * @param control
	 * @param numStudents
	 * @param percentFemale
	 * @param verbalSAT
	 * @param mathSAT
	 * @param expense
	 * @param percentFinAid
	 * @param numApplicants
	 * @param percentAdmit
	 * @param percentEnroll
	 * @param academicScale
	 * @param socialScale
	 * @param qualityLifeScale
	 * @param areasOfStudy
	 * @return true if the school was edited, false if not
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
	 * 
	 * @param account The account that should be removed
	 * @return true if the account was deleted, false if not
	 */
	public boolean deleteAccount(Account account) {
		if (account == null)
		{
			System.out.println("You cant pass an null object");
		}
		boolean deletedAccount = dBController.deleteAccount(account);
		return deletedAccount;
	}
	
	/**
	 * Edits an Account
	 * 
	 * @param username The user name associated with the account
	 * @param password The password associated with the account
	 * @param firstName The first name associated with the account
	 * @param lastName The last name associated with the account
	 * @param type The type associated with the account
	 * @param status The status associated with the account
	 * @return true if the account is edited, false if not
	 */
	public boolean editAccount(String username, String password, String firstName, String lastName, char type, char status ) {
		boolean editedAccount = dBController.editAccount(username, password, firstName, lastName, type, status);
		return editedAccount;
	}
}