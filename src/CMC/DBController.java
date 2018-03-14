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
public class DBController{
	/**
	Database connection instance variable
	*/
	UniversityDBLibrary DBConnection;
	/**
	 * Constructor for DBController. Connects to database
	 */
	public DBController()
	{
		DBConnection = new UniversityDBLibrary("cerami", "cerami", "csci230");
	}
	
	/**
	 * Accesses database and converts array of school information to a collection of school objects
	 * @return arrayList of school objects 
	 */
	public ArrayList<School> getAllSchools()
	{
		//call to the external database
		String[][] allSchoolsFromDB = DBConnection.university_getUniversities();
		
		//convert database information to an arraylist of school objects
		ArrayList<School> listOfSchools = new ArrayList<School>();
		for(int schoolName = 0; schoolName < allSchoolsFromDB.length; schoolName++){
			School currentSchool = null;
			for(int schoolInfo = 0; schoolInfo < allSchoolsFromDB[0].length; schoolInfo++) {
				currentSchool = new School(allSchoolsFromDB[schoolName][0],  				  	//School name
												allSchoolsFromDB[schoolName][1],					  	//State
												allSchoolsFromDB[schoolName][2],						//Location
												allSchoolsFromDB[schoolName][3], 						//Control
												Integer.parseInt(allSchoolsFromDB[schoolName][4]), 		//Number of Students
												Double.parseDouble(allSchoolsFromDB[schoolName][5]), 	//Percent Female
												Integer.parseInt(allSchoolsFromDB[schoolName][6]), 		//Verbal SAT
												Integer.parseInt(allSchoolsFromDB[schoolName][7]), 		//Math SAT
												Double.parseDouble(allSchoolsFromDB[schoolName][8]), 	//Expense
												Double.parseDouble(allSchoolsFromDB[schoolName][9]), 	//Percent Financial Aid
												Integer.parseInt(allSchoolsFromDB[schoolName][10]), 	//Number Of Applicants
												Double.parseDouble(allSchoolsFromDB[schoolName][11]), 	//Percent Admitted
												Double.parseDouble(allSchoolsFromDB[schoolName][11]), 	//Percent Enrolled
												Integer.parseInt(allSchoolsFromDB[schoolName][12]), 	//Academic Scale
												Integer.parseInt(allSchoolsFromDB[schoolName][13]), 	//Social Scale
												Integer.parseInt(allSchoolsFromDB[schoolName][14]), 	//Quality Of Life Scale
												(null));												//Area's of Study
				}
			listOfSchools.add(currentSchool);

		}
		
		return listOfSchools;
	}
	
	/**
	 * returns a specific school from database list of schools
	 * @param schoolName
	 * @return desired school from database
	 */
	public School getSchool(String schoolName){
		ArrayList<School> listOfSchools = new ArrayList<School>();
		School foundSchool = null;
		for(School s : listOfSchools){
			if(s.getName() == schoolName) {
				foundSchool = s;
			}
		}
				
		return foundSchool;
	}
	
	/**
	 * With a given set of user name and password this method will search the database and confirm that
	 * a user with those credential exists 
	 * @param trialUserName proposed user name
	 * @param trialPassword proposed password
	 * @return true is a user with input credentials exists and false if it doesn't
	 */
	public boolean credentialValidation(String trialUserName, String trialPassword)
	{
		ArrayList<Account> accountArray = this.getAccounts();
		Account foundAccount = null;
		for(Account myAccount: accountArray) {
			if(myAccount.getUsername().equals(trialUserName)) {
				foundAccount = myAccount;
			}
		}
		if(foundAccount.equals(null) || !foundAccount.getPassword().equals(trialPassword) ){
			return false;
		}
		else
		{
			return true;	
		}

	}
	
		/**
	 * Accesses database and converts array of user information to a collection of user objects
	 * @return arrayList of user objects 
	 */
	public ArrayList<Account> getAccounts(){
		String[][] allUsersFromDB = DBConnection.user_getUsers();
		
		ArrayList<Account> listOfUser = new ArrayList<Account>();
		//System.out.println("works1");
		for(int userNum = 0; userNum < allUsersFromDB.length; userNum++){

			Account currentAccount = new Account(allUsersFromDB[userNum][0],  			//first name
										allUsersFromDB[userNum][1],				//last name
										allUsersFromDB[userNum][2], 			//user name
										allUsersFromDB[userNum][3], 			//password
										allUsersFromDB[userNum][4].charAt(0),	//type
										allUsersFromDB[userNum][5].charAt(0)	//status
										);	
			listOfUser.add(currentAccount);
		}
		
		return listOfUser;
	}
	
	/**
	 * returns a specific user from database list of user
	 * @param UserName
	 * @return desired user from database
	 */
	public Account getAccount(String UserName)
	{
		ArrayList<Account> listOfAccount = new ArrayList<Account>();
		Account foundAccount = null;
		for(Account myAccount : listOfAccount){
			if(myAccount.getUsername() == UserName) {
				foundAccount = myAccount;
			}
		}
				
		return foundAccount;
		
				
	}
	
	public boolean editSchool(School mySchool){
		int schoolEdited = DBConnection.university_addUniversity(mySchool.getName(), mySchool.getState(), mySchool.getLocation(), 
																mySchool.getControl(),mySchool.getNumStudents(),mySchool.getPercentFemale(),
																mySchool.getVerbalSAT(), mySchool.getMathSAT(),mySchool.getExpense(), 
																mySchool.getPercentFinAid(), mySchool.getNumApplicants(), mySchool.getPercentAdmit(), 
																mySchool.getPercentEnroll(), mySchool.getAcademicScale(),mySchool.getSocialScale(), mySchool.getQualityLifeScale());
		if(schoolEdited < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * Adds a school to the database along with an emphasis 
	 * @param schoolName The name of the school
	 * @param state The state where the school is located
	 * @param location URBAN, SUBURBAN, or RURAL
	 * @param control 
	 * @param numStudents number of students in school
	 * @param percentFemale Percent of school population that is female
	 * @param verbalSAT Verbal SAT score 1 - 800
	 * @param mathSAT Math SAT score 1 - 800
	 * @param expense Tuition at school
	 * @param percentFinancialAid Percent of students with financial aid
	 * @param numApplicants The number of students who apply each year
	 * @param percentAdmit Of the applicant, the amount of students who are admitted
	 * @param percentEnroll Of the admitted students, amount of students who enroll
	 * @param academicScale School academic rating 1 - 5
	 * @param socialScale School social rating 1 - 5
	 * @param qualityOfLifeScale School quality of life rating 1 - 5
	 * @param areaOfStudy Collection of all areas of study at school
	 * @return true if addition is made false if school already exists
	 */
	public boolean addNewSchool(School mySchool)
	{
		
		int schoolAdded = DBConnection.university_addUniversity(mySchool.getName(), mySchool.getState(), mySchool.getLocation(), 
																mySchool.getControl(),mySchool.getNumStudents(),mySchool.getPercentFemale(),
																mySchool.getVerbalSAT(), mySchool.getMathSAT(),mySchool.getExpense(), 
																mySchool.getPercentFinAid(), mySchool.getNumApplicants(), mySchool.getPercentAdmit(), 
																mySchool.getPercentEnroll(), mySchool.getAcademicScale(),mySchool.getSocialScale(), mySchool.getQualityLifeScale());
		int emphasisAdded = this.DBConnection.university_addUniversityEmphasis(mySchool.getName(), "emphasis");

		if(schoolAdded < 0 || emphasisAdded < 0 ) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * removes a saved school of a user if that school is saved
	 * @param activeUser user who's saved schools will be changed
	 * @param userSchool school to be saved
	 * @return true if school was successfully saved false if it was not
	 */
	public boolean saveSchool(User user, School school){
		int savedSchool = DBConnection.user_saveSchool(user.getUsername(), school.getName());
		if(savedSchool < 0) {
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * removes a remove school of a user if that school is saved
	 * @param activeUser user who's remove schools will be changed
	 * @param userSchool school to be deleted
	 * @return true if school was successfully removed false if it was not
	 */
	public boolean removeSavedSchools(User activeUser, School userSchool){
		int removedSchool = DBConnection.user_removeSchool(activeUser.getUsername(), userSchool.getName());
		if(removedSchool < 0){
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * adds a user to the database 
	 * @param activeUser user to be added to database
	 * @return true if user was added to database; false if not
	 */
	public boolean addAccount(Account activeUser){
		int accountAdded = DBConnection.user_addUser(activeUser.getFirst(),
												activeUser.getLast(),
												activeUser.getUsername(),
												activeUser.getPassword(),
												activeUser.getType());
		if(accountAdded < 0){
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * Searched users in database and compares given user name to stored user names to see if user name is being used
	 * @param userName
	 * @return true is the user name is available and false if it is being used
	 */
	public boolean checkUsernameAvailability(String userName){
		ArrayList<Account> accountArray = this.getAccounts();
		boolean UsernameAvailabile = true;
		for(Account myAccount : accountArray )
		{
			if(myAccount.getUsername().equals(userName)) {
				UsernameAvailabile = false;
			}
				
			
		}
		return UsernameAvailabile;
	}

	/**
	 * adds a user to the database 
	 * @param activeUser account to be added to database
	 * @return true if account was edited to database; false if not
	 */
	public boolean editAccount(User activeUser) {
		int accountEdited = DBConnection.user_addUser(activeUser.getFirst(),
				activeUser.getLast(),
				activeUser.getUsername(),
				activeUser.getPassword(),
				activeUser.getType());
		
		if(accountEdited < 0){
			return false;
		}
		else {
			return true;
		}
	}
}


