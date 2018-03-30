package CMC;

import java.util.ArrayList;
import java.util.Collection;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * DBController.java Connection to the database
 * 
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

	/**
	 * Constructor for DBController. Connects to database
	 */
	public DBController() {
		DBConnection = new UniversityDBLibrary("cerami", "cerami", "csci230");
		this.allSchoolsArray = this.getAllSchoolsForConstructor();
		this.createArrayOfStudy();
		this.allAccountsArray = this.getAccountsForConstructor();
		this.allUsersArray = new ArrayList<User>();
		this.allAdminsArray = new ArrayList<Account>();
		this.seperateUsersFromAdmins();
		this.getUserSavedSchools();

	}

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

	public ArrayList<School> getAllSchools() {
		return this.allSchoolsArray;
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

			Account currentAccount = new Account(
					allUsersFromDB[userNum][2], // user name
					allUsersFromDB[userNum][3], // password
					allUsersFromDB[userNum][0], // first name
					allUsersFromDB[userNum][1], // last name
					allUsersFromDB[userNum][4].charAt(0), // type
					allUsersFromDB[userNum][5].charAt(0) // status
			);
			listOfUser.add(currentAccount);
		}

		return listOfUser;
	}

	/**
	 * returns instance variable for array of accounts
	 * 
	 * @return
	 */
	public ArrayList<Account> getAccounts() {
		return this.allAccountsArray;
	}

	/**
	 * returns a specific user from database list of user
	 * 
	 * @param UserName
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

	public User getUser(String UserName) {
		User foundUser = null;
		for (User myUser : this.allUsersArray) {
			if (myUser.getUsername().equals(UserName)) {
				foundUser = myUser;
			}
		}
		return foundUser;
	}

	public boolean editSchool(School mySchool) {
		int schoolEdited = DBConnection.university_addUniversity(mySchool.getName(), mySchool.getState(),
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
	 * Adds a school to the database along with an emphasis
	 * 
	 * @param schoolName
	 *            The name of the school
	 * @param state
	 *            The state where the school is located
	 * @param location
	 *            URBAN, SUBURBAN, or RURAL
	 * @param control
	 * @param numStudents
	 *            number of students in school
	 * @param percentFemale
	 *            Percent of school population that is female
	 * @param verbalSAT
	 *            Verbal SAT score 1 - 800
	 * @param mathSAT
	 *            Math SAT score 1 - 800
	 * @param expense
	 *            Tuition at school
	 * @param percentFinancialAid
	 *            Percent of students with financial aid
	 * @param numApplicants
	 *            The number of students who apply each year
	 * @param percentAdmit
	 *            Of the applicant, the amount of students who are admitted
	 * @param percentEnroll
	 *            Of the admitted students, amount of students who enroll
	 * @param academicScale
	 *            School academic rating 1 - 5
	 * @param socialScale
	 *            School social rating 1 - 5
	 * @param qualityOfLifeScale
	 *            School quality of life rating 1 - 5
	 * @param areaOfStudy
	 *            Collection of all areas of study at school
	 * @return true if addition is made false if school already exists
	 */
	public boolean addNewSchool(School mySchool) {

		int schoolAdded = DBConnection.university_addUniversity(mySchool.getName(), mySchool.getState(),
				mySchool.getLocation(), mySchool.getControl(), mySchool.getNumStudents(), mySchool.getPercentFemale(),
				mySchool.getVerbalSAT(), mySchool.getMathSAT(), mySchool.getExpense(), mySchool.getPercentFinAid(),
				mySchool.getNumApplicants(), mySchool.getPercentAdmit(), mySchool.getPercentEnroll(),
				mySchool.getAcademicScale(), mySchool.getSocialScale(), mySchool.getQualityLifeScale());
		int emphasisAdded = this.DBConnection.university_addUniversityEmphasis(mySchool.getName(), "emphasis");

		if (schoolAdded < 0 || emphasisAdded < 0) {
			return false;
		} else {
			return true;
		}
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
	public boolean saveSchool(User user, School school) {
		int savedSchool = DBConnection.user_saveSchool(user.getUsername(), school.getName());
		if (savedSchool < 0) {
			return false;
		} else {
			return true;
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
		int accountAdded = DBConnection.user_addUser(activeUser.getUsername(), activeUser.getPassword(),
				activeUser.getFirst(), activeUser.getLast(), activeUser.getType());
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
	 * adds a user to the database
	 * 
	 * @param activeUser
	 *            account to be added to database
	 * @return true if account was edited to database; false if not
	 */
	public boolean editAccount(String username, String password, String firstName, String lastName, char type,
			char status) {
		int accountEdited = DBConnection.user_editUser(username, password, firstName, lastName, type, status);

		if (accountEdited < 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Removes an account from the database
	 * 
	 * @param accountToBeRemoved
	 *            the account that will be removed from the database
	 * @return true if the account was successfully removed from database and false
	 *         if it was not
	 */
	public boolean deleteUser(Account accountToBeRemoved) {
		int userRemoved = DBConnection.user_deleteUser(accountToBeRemoved.getUsername());

		if (userRemoved < 0) {
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
		int schoolEmphasisRemoved = DBConnection.university_removeUniversityEmphasis(schoolToBeRemoved.getName(),
				schoolToBeRemoved.getEmphasis());
		int schoolRemoved = DBConnection.university_deleteUniversity(schoolToBeRemoved.getName());

		if (schoolRemoved < 0 && schoolEmphasisRemoved < 0) {
			return false;
		} else {
			return true;
		}

	}

	public char toggleActivaton(User activeUser) {
		char currentStatus = activeUser.getStatus();
		if (currentStatus == 'Y') {
			this.editAccount(activeUser.getUsername(), activeUser.getPassword(), activeUser.getFirst(),
					activeUser.getLast(), activeUser.getType(), 'N');
			if (currentStatus == 'N') {
				this.editAccount(activeUser.getUsername(), activeUser.getPassword(), activeUser.getFirst(),
						activeUser.getLast(), activeUser.getType(), 'Y');
			}
		}
		return currentStatus;
	}

	public ArrayList<School> viewSavedSchool(User activeUser) {
		ArrayList<School> userArrayOfSchools = null;
		String[][] listOfUserSchools = DBConnection.university_getNamesWithEmphases();
		System.out.println(listOfUserSchools[4]);
		for (int i = 0; i < listOfUserSchools.length; i++) {
			System.out.println(listOfUserSchools[i] + " equals " + (activeUser.getUsername()));
			if (listOfUserSchools[i].equals(activeUser.getUsername())) {
				for (int j = 0; j < listOfUserSchools[i].length; j++) {
					System.out.println(listOfUserSchools[i][j]);
					userArrayOfSchools.add(this.getSchool(listOfUserSchools[i][j]));
				}
			}
		}
		return userArrayOfSchools;

	}

	public void createArrayOfStudy() {
		String[][] emphasis2DArray = DBConnection.university_getNamesWithEmphases();
		ArrayList<String> emphasisArrayList = new ArrayList<String>();
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

	public String getEmphasis() {

		return null;
	}

	private void getUserSavedSchools() {

		String[][] arrayOfUsersAndSavedSchools = DBConnection.user_getUsernamesWithSavedSchools();
		ArrayList<String> userSavedSchools = new ArrayList<String>();
		for (User myUser : this.allUsersArray) {
			ArrayList<School> tempSavedSchool = new ArrayList<School>();
			for (int i = 0; i < arrayOfUsersAndSavedSchools.length; i++) {
				for (int j = 0; j < arrayOfUsersAndSavedSchools[i].length; j++) {
					if (arrayOfUsersAndSavedSchools[i][j].equals(myUser.getUsername()) && !(tempSavedSchool.contains(this.getSchool(arrayOfUsersAndSavedSchools[i][j + 1])))) {
						tempSavedSchool.add(this.getSchool(arrayOfUsersAndSavedSchools[i][j + 1]));
						//System.out.println(arrayOfUsersAndSavedSchools[i][j]);
					}
				}
			}
			myUser.savedSchools = tempSavedSchool;
		}
	}

	public ArrayList<User> getAllUsers() {
		return this.allUsersArray;
	}

	public ArrayList<Account> getAllAdmins() {
		return this.allAdminsArray;
	}

	private void seperateUsersFromAdmins() {
		for (Account unknownAccount : this.allAccountsArray) {
			if (unknownAccount.getType() == 'a') {
				this.allAdminsArray.add(unknownAccount);
				;
			} else if (unknownAccount.getType() == 'u') {
				this.allUsersArray.add(
						new User(unknownAccount.getUsername(), unknownAccount.getPassword(), unknownAccount.getFirst(),
								unknownAccount.getLast(), unknownAccount.getType(), unknownAccount.getStatus(), null));

			}
		}
	}
}
