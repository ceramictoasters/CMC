package CMC;

import java.util.ArrayList;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * DBController.java Connection to the database
 * @author Wilmot Osei-Bonsu
 * @version 2/25/18
 */
public class DBController {
	/**
	 * Database connection instance variable
	 */
	UniversityDBLibrary DBConnection;
	/**
	 * Array off all schools in the database
	 */
	ArrayList<School> allSchoolsArray;
	ArrayList<Account> allAccountsArray;
	ArrayList<User> allUsersArray;
	ArrayList<Account> allAdminsArray;
	ArrayList<String> savedSchoolsArray;

	/**
	 * Constructor for DBController. Connects to database
	 */
	public DBController() {
		DBConnection = new UniversityDBLibrary("cerami", "cerami", "csci230");
		this.allSchoolsArray = this.getAllSchoolsForConstructor();
		this.createArrayOfStudyForConstructor();
		this.allAccountsArray = this.getAccountsForConstructor();
		this.allUsersArray = new ArrayList<User>();
		this.allAdminsArray = new ArrayList<Account>();
		this.seperateUsersFromAdmins();
		this.getUsersSavedSchoolsForConstructor();
	}

	// Constructor-Methods****************************************************************************************************************************************************************************
	//************************************************************************************************************************************************************************************************
	/**
	 * Accesses database and converts array of school information to a collection of
	 * school objects
	 * 
	 * @return arrayList of school objects
	 */
	private ArrayList<School> getAllSchoolsForConstructor() {
		// call to the external database
		String[][] allSchoolsFromDB = DBConnection.university_getUniversities();
		// convert database information to an arraylist of school objects
		ArrayList<School> listOfSchools = new ArrayList<School>();
		for (int schoolNameIndex = 0; schoolNameIndex < allSchoolsFromDB.length; schoolNameIndex++) {
			School currentSchool = null;
			for (int schoolInfo = 0; schoolInfo < allSchoolsFromDB[0].length; schoolInfo++) {
				currentSchool = new School(allSchoolsFromDB[schoolNameIndex][0], // School name
						allSchoolsFromDB[schoolNameIndex][1], // State
						allSchoolsFromDB[schoolNameIndex][2], // Location
						allSchoolsFromDB[schoolNameIndex][3], // Control
						Integer.parseInt(allSchoolsFromDB[schoolNameIndex][4]), // Number of Students
						Double.parseDouble(allSchoolsFromDB[schoolNameIndex][5]), // Percent Female
						Integer.parseInt(allSchoolsFromDB[schoolNameIndex][6]), // Verbal SAT
						Integer.parseInt(allSchoolsFromDB[schoolNameIndex][7]), // Math SAT
						Double.parseDouble(allSchoolsFromDB[schoolNameIndex][8]), // Expense
						Double.parseDouble(allSchoolsFromDB[schoolNameIndex][9]), // Percent Financial Aid
						Integer.parseInt(allSchoolsFromDB[schoolNameIndex][10]), // Number Of Applicants
						Double.parseDouble(allSchoolsFromDB[schoolNameIndex][11]), // Percent Admitted
						Double.parseDouble(allSchoolsFromDB[schoolNameIndex][12]), // Percent Enrolled
						Integer.parseInt(allSchoolsFromDB[schoolNameIndex][13]), // Academic Scale
						Integer.parseInt(allSchoolsFromDB[schoolNameIndex][14]), // Social Scale
						Integer.parseInt(allSchoolsFromDB[schoolNameIndex][15]), // Quality Of Life Scale
						(null)); // Area's of Study

			}
			listOfSchools.add(currentSchool);
		}
		return listOfSchools;
	}

	/**
	 * Accesses database and converts array of user information to a collection of
	 * user objects this method is for the use of the constructor and is used only
	 * when instance is created. Method also seperated betweeen general Users and
	 * Administrators.
	 * 
	 * @return arrayList of user objects
	 */
	private ArrayList<Account> getAccountsForConstructor() {
		String[][] allUsersFromDB = DBConnection.user_getUsers();

		ArrayList<Account> listOfUser = new ArrayList<Account>();
		for (int userNum = 0; userNum < allUsersFromDB.length; userNum++) {

			Account currentAccount = new Account(allUsersFromDB[userNum][2], // first name
					allUsersFromDB[userNum][3], // last name
					allUsersFromDB[userNum][0], // user name
					allUsersFromDB[userNum][1], // password
					allUsersFromDB[userNum][4].charAt(0), // type
					allUsersFromDB[userNum][5].charAt(0) // status
			);
			listOfUser.add(currentAccount);
		}

		return listOfUser;
	}

	/**
	 * Creates a collection of 'areasOfStudy for a school. Method is used for
	 * constructor only
	 */
	private void createArrayOfStudyForConstructor() {
		String[][] emphasis2DArray = DBConnection.university_getNamesWithEmphases();
		for (School mySchool : this.allSchoolsArray) {
			ArrayList<String> tempEmphasisArray = new ArrayList<String>();
			for (int i = 0; i < emphasis2DArray.length; i++) {
				for (int j = 0; j < emphasis2DArray[i].length; j++) {
					if (emphasis2DArray[i][j].equals(mySchool.getName())) {
						tempEmphasisArray.add(emphasis2DArray[i][j + 1]);
					}
				}
			}
			mySchool.setAreasOfStudy(tempEmphasisArray);
		}
	}

	/**
	 * Used by constructor to add saved school information to all User objects
	 */
	private void getUsersSavedSchoolsForConstructor() {
		String[][] arrayOfUsersAndSavedSchools = DBConnection.user_getUsernamesWithSavedSchools();
		for (User myUser : this.allUsersArray) {
			ArrayList<School> tempSavedSchool = new ArrayList<School>();
			for (int i = 0; i < arrayOfUsersAndSavedSchools.length; i++) {
				for (int j = 0; j < arrayOfUsersAndSavedSchools[i].length; j++) {
					if (arrayOfUsersAndSavedSchools[i][j].equals(myUser.getUsername())
							&& !(tempSavedSchool.contains(this.getSchool(arrayOfUsersAndSavedSchools[i][j + 1])))) {
						tempSavedSchool.add(this.getSchool(arrayOfUsersAndSavedSchools[i][j + 1]));
					}
				}
			}
			myUser.savedSchools = tempSavedSchool;
		}
	}

	/**
	 * Used by constructor to create 2 collections. One collection contains only
	 * users the other contains only administrators
	 */
	private void seperateUsersFromAdmins() {
		for (Account unknownAccount : this.allAccountsArray) {
			if (unknownAccount.getType() == 'a') {
				this.allAdminsArray.add(unknownAccount);
			} else if (unknownAccount.getType() == 'u') {
				User unkownUser = new User(unknownAccount.getUsername(), unknownAccount.getPassword(),
						unknownAccount.getFirst(), unknownAccount.getLast(), unknownAccount.getType(),
						unknownAccount.getStatus(), null);
				unkownUser.savedSchools = this.viewSavedSchool(unkownUser);
				this.allUsersArray.add(unkownUser);

			}
		}
	}

	// School-Methods*********************************************************************************************************************************************************************************
	//************************************************************************************************************************************************************************************************
	/**
	 * get method for "allSchoolsArray" instance variable
	 * 
	 * @param schoolToTest
	 * @return
	 */
	public boolean getAllSchoosArray(School schoolToTest) {
		return this.allSchoolsArray.contains(schoolToTest);
	}

	/**
	 * returns a specific school from database list of schools
	 * 
	 * @param schoolName
	 * @return desired school from database
	 */
	public School getSchool(String schoolName) {
		School foundSchool = null;
		for (School s : this.allSchoolsArray) {
			if (s.getName().equals(schoolName)) {
				foundSchool = s;
			}
		}

		return foundSchool;
	}

	/**
	 * Adds a school to the database along with an emphasis
	 * 
	 * @param mySchool
	 *            school that will be added to the database
	 * @return true if addition is made false if school already exists
	 */
	public boolean addNewSchool(School mySchool) {

		int emphasisAdded = -10;
		int schoolAdded = DBConnection.university_addUniversity(mySchool.getName(), mySchool.getState(),
				mySchool.getLocation(), mySchool.getControl(), mySchool.getNumStudents(), mySchool.getPercentFemale(),
				mySchool.getVerbalSAT(), mySchool.getMathSAT(), mySchool.getExpense(), mySchool.getPercentFinAid(),
				mySchool.getNumApplicants(), mySchool.getPercentAdmit(), mySchool.getPercentEnroll(),
				mySchool.getAcademicScale(), mySchool.getSocialScale(), mySchool.getQualityLifeScale());

		for (String areaOfStudy : mySchool.getAreasOfStudy()) {
			emphasisAdded = this.DBConnection.university_addUniversityEmphasis(mySchool.getName(), areaOfStudy);
		}
		this.allSchoolsArray.add(mySchool);
		if (schoolAdded < 0 || emphasisAdded < 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * returns array of schools stored in the class
	 * 
	 * @return array of schools instance variable
	 */
	public ArrayList<School> getAllSchools() {
		return this.allSchoolsArray;
	}

	/**
	 * Edits information for a school within the database
	 * 
	 * @param mySchool
	 *            School object that holds the information that will be updated in
	 *            the database
	 * @return
	 */
	public boolean editSchool(School mySchool) {
		int schoolEdited = DBConnection.university_editUniversity(mySchool.getName(), mySchool.getState(),
				mySchool.getLocation(), mySchool.getControl(), mySchool.getNumStudents(), mySchool.getPercentFemale(),
				mySchool.getVerbalSAT(), mySchool.getMathSAT(), mySchool.getExpense(), mySchool.getPercentFinAid(),
				mySchool.getNumApplicants(), mySchool.getPercentAdmit(), mySchool.getPercentEnroll(),
				mySchool.getAcademicScale(), mySchool.getSocialScale(), mySchool.getQualityLifeScale());
		if (schoolEdited < 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Removes a school and its corresponding emphasis from the database
	 * 
	 * @param schoolToBeRemoved
	 *            the school that will be removed from the database
	 * @return true if the school was successfully removed from database and false
	 *         if it was not
	 */
	public boolean deleteSchool(School schoolToBeRemoved) {
		if (!this.getAllSchoosArray(schoolToBeRemoved)) {
			throw new IllegalArgumentException("School Could Not Be Found In Database");
		} else if (this.savedSchoolsArray.contains(schoolToBeRemoved.getName())) {
			throw new IllegalArgumentException(
					"The School is saved by user and cand not be removed while it is saved ");
		} else {
			int emphasisRemoved = 0;
			DBConnection.university_removeUniversityEmphasis(schoolToBeRemoved.getName(), "emphasis");
			for (String areasOfStudy : schoolToBeRemoved.getAreasOfStudy()) {
				emphasisRemoved = emphasisRemoved
						+ DBConnection.university_removeUniversityEmphasis(schoolToBeRemoved.getName(), areasOfStudy);
			}
			int successfullyRemoved = DBConnection.university_deleteUniversity(schoolToBeRemoved.getName());
			this.allSchoolsArray.remove(schoolToBeRemoved);
			if (successfullyRemoved < 0) {
				return false;
			} else {
				return true;
			}
		}
	}

	// General-Accounts********************************************************************************************************************************************************************************
	//*************************************************************************************************************************************************************************************************
	/**
	 * With a given set of user name and password this method will search the
	 * database and confirm that a user with those credential exists
	 * 
	 * @param trialUserName
	 *            proposed user name
	 * @param trialPassword
	 *            proposed password
	 * @return true is a user with input credentials exists and false if it doesn't
	 */
	public boolean credentialValidation(String trialUserName, String trialPassword) {
		Account foundAccount = null;
		for (Account myAccount : this.allAccountsArray) {
			if (myAccount.getUsername().equals(trialUserName)) {
				foundAccount = myAccount;
			}
		}
		if (foundAccount == null || !foundAccount.getPassword().equals(trialPassword)) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * returns instance variable for array of accounts. Users and Administrator
	 * 
	 * @return array of all accounts
	 */
	public ArrayList<Account> getAccounts() {
		return this.allAccountsArray;
	}

	/**
	 * returns a specific account from database list of user
	 * 
	 * @param accountName
	 *            user name of the account to return.
	 * @return desired user from database
	 */
	public Account getAccount(String accountName) {
		Account foundAccount = null;
		for (Account myAccount : this.allAccountsArray) {
			if (myAccount.getUsername().equals(accountName)) {
				foundAccount = myAccount;
			}
		}
		return foundAccount;
	}

	/**
	 * Removes an account from the database
	 * 
	 * @param accountToBeRemoved
	 *            the account that will be removed from the database
	 * @return true if the account was successfully removed from database and false
	 *         if it was not
	 */
	public boolean deleteAccount(Account accountToBeRemoved) {
		int userRemoved = DBConnection.user_deleteUser(accountToBeRemoved.getUsername());
		if (accountToBeRemoved.getType() == 'u') {
			this.allUsersArray.remove(accountToBeRemoved);
			this.allAccountsArray.remove(accountToBeRemoved);
		} else if (accountToBeRemoved.getType() == 'a') {
			this.allAdminsArray.remove(accountToBeRemoved);
			this.allAccountsArray.remove(accountToBeRemoved);
		} else {
			throw new IllegalArgumentException("The accunt does not have a valid type");
		}
		if (userRemoved < 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * adds a user to the database
	 * 
	 * @param activeUser
	 *            user to be added to database
	 * @return true if user was added to database; false if not
	 */
	public boolean addAccount(Account activeUser) {
		int accountAdded = DBConnection.user_addUser(activeUser.getFirst(), activeUser.getLast(),
				activeUser.getUsername(), activeUser.getPassword(), activeUser.getType());
		this.allAccountsArray.add(activeUser);
		if (activeUser.getType() == 'a') {
			this.allAdminsArray.add(activeUser);
		} else if (activeUser.getType() == 'u') {
			User unkownUser = new User(activeUser.getUsername(), activeUser.getPassword(), activeUser.getFirst(),
					activeUser.getLast(), activeUser.getType(), activeUser.getStatus(), null);
			unkownUser.savedSchools = this.viewSavedSchool(unkownUser);
			this.allUsersArray.add(unkownUser);
		} else {
			throw new IllegalArgumentException("This Account has type not 'u' or 'a' ");
		}
		if (accountAdded < 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Searched users in database and compares given user name to stored user names
	 * to see if user name is being used
	 * 
	 * @param userName
	 * @return true is the user name is available and false if it is being used
	 */
	public boolean checkUsernameAvailability(String userName) {
		boolean UsernameAvailabile = true;
		for (Account myAccount : this.allAccountsArray) {
			if (myAccount.getUsername().equals(userName)) {
				UsernameAvailabile = false;
			}
		}
		return UsernameAvailabile;
	}

	/**
	 * edits a user in the database
	 * 
	 * @param activeUser
	 *            account to be edited in database.
	 * @throws IllegalArgumentException
	 *             if account passed does not have a valid type.
	 * @return true if account was edited to database; false if not.
	 */
	public boolean editAccount(String username, String password, String firstName, String lastName, char type,
			char status) {
		int accountEdited = DBConnection.user_editUser(username, firstName, lastName, password, type, status);

		if (accountEdited < 0) {
			return false;
		} else {
			this.allAccountsArray.remove(this.getUser(username));
			this.allAccountsArray.add(new Account(username, firstName, lastName, password, type, status));
			if (type == 'u') {
				ArrayList<School> tempCollectionOfSavedSchools = this.getUser(username).getSaved();
				this.allUsersArray.remove(this.getUser(username));
				this.allUsersArray.add(
						new User(username, firstName, lastName, password, type, status, tempCollectionOfSavedSchools));
				return true;
			} else if (type == 'a') {
				this.allAdminsArray.remove(this.getUser(username));
				this.allAdminsArray.add(new Account(username, firstName, lastName, password, type, status));
				return true;
			} else {
				throw new IllegalArgumentException("Invalid account type");
			}
		}
	}
	// Admin-Accounts**********************************************************************************************************************************************************************************
	//*************************************************************************************************************************************************************************************************

	/**
	 * Creates an Account object using input information and returns the Account.
	 * This method should be used to find an administrator
	 * 
	 * @param adminName
	 *            user name of the requested admin
	 * @return User object created using input information. Will return null if the
	 *         admin can not be found
	 */
	public Account getAdmin(String adminName) {
		Account foundAdmin = null;
		for (Account myAdmin : this.allAdminsArray) {
			if (myAdmin.getUsername().equals(adminName)) {
				foundAdmin = myAdmin;
			}
		}
		return foundAdmin;
	}

	/**
	 * Return class instance variable containing all administrator accounts
	 * 
	 * @return collection of all administrator accounts
	 */
	public ArrayList<Account> getAllAdmins() {
		return this.allAdminsArray;
	}

	// User-Accounts***********************************************************************************************************************************************************************************
	//*************************************************************************************************************************************************************************************************

	/**
	 * Changes a users activation status in the database. NOTE that it does not
	 * effect the User account passed.
	 * 
	 * @param activeUser
	 *            User whose activation will be change
	 * @throws IllegalArgumentException
	 *             if Administrator account is passed
	 * @throws IllegalArgumentException
	 *             If the user passed does not have a valid status. Status must be
	 *             either 'N' or 'Y'.
	 * @return The users new status in the database.
	 */
	public char toggleActivaton(User activeUser) {
		if (activeUser.getType() == 'a') {
			throw new IllegalArgumentException("Can Not Deactivate An Admin ");
		}
		char currentStatus = activeUser.getStatus();
		if (currentStatus == 'Y') {
			this.editAccount(activeUser.getUsername(), activeUser.getPassword(), activeUser.getFirst(),
					activeUser.getLast(), activeUser.getType(), 'N');
			return 'N';
		} else if (currentStatus == 'N') {
			this.editAccount(activeUser.getUsername(), activeUser.getPassword(), activeUser.getFirst(),
					activeUser.getLast(), activeUser.getType(), 'Y');
			return 'Y';
		} else {
			throw new IllegalArgumentException("the user passed does not have a valid status");
		}

	}

	/**
	 * Creates a User object using input information and returns the User.
	 * 
	 * @param UserName
	 *            user name of the requested user
	 * @return User object created using input information. Will return null if the
	 *         user can not be found
	 */
	public User getUser(String UserName) {
		User foundUser = null;
		for (User myUser : this.allUsersArray) {
			if (myUser.getUsername().equals(UserName)) {
				foundUser = myUser;
			}
		}
		return foundUser;
	}

	/**
	 * removes a saved school of a user if that school is saved
	 * 
	 * @param activeUser
	 *            user who's saved schools will be changed
	 * @param userSchool
	 *            school to be saved
	 * @return true if school was successfully saved false if it was not
	 */
	public boolean saveSchool(User activeUser, School schoolToSave) {
		if (!this.allUsersArray.contains(activeUser)) {
			throw new IllegalArgumentException("The User Is Not In The Database");
		} else {
			int savedSchool = DBConnection.user_saveSchool(activeUser.getUsername(), schoolToSave.getName());
			if (savedSchool < 0) {
				return false;
			} else {
				this.savedSchoolsArray.add(schoolToSave.getName());
				return true;
			}
		}
	}

	/**
	 * removes a remove school of a user if that school is saved
	 * 
	 * @param activeUser
	 *            user who's remove schools will be changed
	 * @param userSchool
	 *            school to be deleted
	 * @return true if school was successfully removed false if it was not
	 */
	public boolean removeSavedSchools(User activeUser, School userSchool) {
		int removedSchool = DBConnection.user_removeSchool(activeUser.getUsername(), userSchool.getName());
		if (removedSchool < 0) {
			return false;
		} else {
			this.savedSchoolsArray.remove(userSchool.getName());
			return true;
		}
	}

	/**
	 * Method will collect saved schools of the input user and return it in a
	 * collection
	 * 
	 * @param activeUser
	 *            User accounts who's saved school information will be returned
	 * @return collection of schools that the user has saved
	 */
	public ArrayList<School> viewSavedSchool(User activeUser) {
		ArrayList<School> userArrayOfSchools = new ArrayList<School>();
		String[][] listOfUserSchools = DBConnection.user_getUsernamesWithSavedSchools();
		for (int i = 0; i < listOfUserSchools.length; i++) {
			for (int j = 0; j < listOfUserSchools[i].length; j++) {
				if (listOfUserSchools[i][j].equals(activeUser.getUsername())) {
					userArrayOfSchools.add(this.getSchool(listOfUserSchools[i][j + 1]));
				}
			}
		}
		return userArrayOfSchools;
	}
	
	/**
	 * Method returns a collection of all User objects stored by the class
	 * @return collection of User objects 
	 */
	public ArrayList<User> getAllUsers() {
		return this.allUsersArray;
	}
	
	// End*********************************************************************************************************************************************************************************************





}

	//*************************************************************************************************************************************************************************************************
