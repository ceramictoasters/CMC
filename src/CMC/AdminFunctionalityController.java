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
	public boolean addNewSchool(School school) {
		boolean newSchool = dBController.addNewSchool(school);
		return newSchool;
	}
	
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