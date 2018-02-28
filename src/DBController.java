import java.util.ArrayList;
import java.util.Collection;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * @author Wilmot Osei-Bonsu
 *
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
	public ArrayList<School> getAllSchool()
	{
		//call to the external database
		String[][] allSchoolsFromDB = DBConnection.university_getUniversities();
		
		//convert database information to an arraylist of school objects
		ArrayList<School> listOfSchools = new ArrayList<School>();
		for(int schoolName = 0; schoolName < allSchoolsFromDB.length; schoolName++){
			for(int schoolInfo = 0; schoolInfo < allSchoolsFromDB[0].length; schoolInfo++) {
				School currentSchool = new School(allSchoolsFromDB[schoolName][0],  				  	//School name
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
				
				listOfSchools.add(currentSchool);
			}
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
		ArrayList<User> userArray = this.getUsers();
		User foundUser = null;
		for(User u: userArray) {
			if(u.getUsername().equals(trialUserName)) {
				foundUser = u;
			}
		}
		if(foundUser.equals(null) || !foundUser.getPassword().equals(trialPassword) ){
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
	public ArrayList<User> getUsers(){
		String[][] allUsersFromDB = DBConnection.user_getUsers();
		
		ArrayList<User> listOfUser = new ArrayList<User>();
		for(int userNum = 0; userNum < allUsersFromDB[0].length; userNum++){
			User currentUser = new User(allUsersFromDB[userNum][0],  			//first name
										allUsersFromDB[userNum][1],				//last name
										allUsersFromDB[userNum][2], 			//user name
										allUsersFromDB[userNum][3], 			//password
										allUsersFromDB[userNum][4].charAt(0),	//type
										allUsersFromDB[userNum][5].charAt(0),	//status
										null);									//array of schools
			listOfUser.add(currentUser);
		}
		
		return listOfUser;
	}
	
	/**
	 * returns a specific user from database list of user
	 * @param UserName
	 * @return desired user from database
	 */
	public User getUser(String UserName)
	{
		ArrayList<User> listOfUsers = new ArrayList<User>();
		User foundUser = null;
		for(User u : listOfUsers){
			if(u.getUsername() == UserName) {
				foundUser = u;
			}
		}
				
		return foundUser;
		
				
	}
	
	public void editSchool(String schoolName, String state, String location, String control, int numStudents, double percentFemale, int verbalSAT, int mathSAT, double expense, double percentFinancialAid, int numApplicants, double percentAdmit, double percentEnroll, int academicScale, int socialScale, int qualityOfLifeScale, Collection<String> areaOfStudy){
		
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
	public boolean addNewSchool(String schoolName, String state, String location, String control, int numStudents, double percentFemale, int verbalSAT, int mathSAT, double expense, double percentFinancialAid, int numApplicants, double percentAdmit, double percentEnroll, int academicScale, int socialScale, int qualityOfLifeScale, Collection<String> areaOfStudy, String emphasis)
	{
		int schoolAdded = DBConnection.university_addUniversity(schoolName, state, location, control,
													numStudents,percentFemale, verbalSAT, mathSAT, 
													expense, percentFinancialAid, numApplicants, 
													percentAdmit, percentEnroll, academicScale, 
													socialScale, qualityOfLifeScale);
		int emphasisAdded = this.DBConnection.university_addUniversityEmphasis(schoolName, emphasis);

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
	public boolean addUser(User activeUser){
		int useAdded = DBConnection.user_addUser(activeUser.getFirst(),
												activeUser.getLast(),
												activeUser.getUsername(),
												activeUser.getPassword(),
												activeUser.getType());
		if(useAdded < 0){
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
		ArrayList<User> userArray = this.getUsers();
		boolean UsernameAvailabile = true;
		for(User user : userArray )
		{
			if(user.getUsername().equals(userName)) {
				UsernameAvailabile = false;
			}
				
			
		}
		return UsernameAvailabile;
	}

}


