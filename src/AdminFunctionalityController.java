/*
* AdminFunctionalityController 
* @Version February 27, 2018
*/
public class AdminFunctionalityController {

	/**
	 * Method called when user selects to display schools
	 */
	public void viewSchools() {
		School[] schools = DBController.getAllSchools();
		System.out.println(schools);
	}

	/**
	 * Method used to display a certain school
	 * 
	 * @param name name of the school to be displayed
	 */
	public void viewSchool(String name) {
		school = DBController.getSchool(name);
		System.out.println(school);
	}

	/**
	 * Method used to add a new school to the list
	 * 
	 * @param name name of the school
	 */
	public void addNewSchool(String name) {
		newSchool = DBController.addNewSchool(name);
		System.out.println(newSchool);
	}

	/**
	 * Method that displays the accounts currently saved in the database
	 */
	public void viewAccounts() {
		User[] users = DBController.getUsers();
		System.out.println(users);
	}

	/**
	 * Method used to add a new user to the database
	 * 
	 * @param name first name
	 * @param last last name
	 * @param pass password
	 * @param type acount type
	 */
	public void addNewUser(String name, String last, String pass, char type)  {
		AccountController.createUser(name,password,type);
	}	

	/**
	 * Method used to deactivate an account
	 * 
	 * @param user user to be deactivated
	 */
	public void deactivateUser(Account user) {
		user.AccountController.deactivate();
	}

	/**
	 * method used to view a selected account
	 * 
	 * @param user name ofthe user to be displayed
	 */
	public void viewAccount(String user) {
		account = DBController.getUser(user);
		System.out.println(account);
	}
}