import java.util.ArrayList;
import java.util.Collection;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * 
 */

/**
 * @author woseibons001
 *
 */

public class DBController{
	/**
	Database connection instance variable
	*/
	UniversityDBLibrary DBConnection;
	
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
				School currentSchool = new School(allSchoolsFromDB[schoolName][0], allSchoolsFromDB[schoolName][1], allSchoolsFromDB[schoolName][2], 
						allSchoolsFromDB[schoolName][3], allSchoolsFromDB[schoolName][4], allSchoolsFromDB[schoolName][5], allSchoolsFromDB[schoolName][6], 
						allSchoolsFromDB[schoolName][7], allSchoolsFromDB[schoolName][8], allSchoolsFromDB[schoolName][9], allSchoolsFromDB[schoolName][10], 
						allSchoolsFromDB[schoolName][11], allSchoolsFromDB[schoolName][11], allSchoolsFromDB[schoolName][12], allSchoolsFromDB[schoolName][13], allSchoolsFromDB[schoolName][14]);
				
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
	
	public boolean credentialValidation(String trialUserName, String trialPassword)
	{
		
		return false;
	}
	
	public void setSession(String userName)
	{
		
	}
	
	/**
	 * Accesses database and converts array of user information to a collection of user objects
	 * @return arrayList of user objects 
	 */
	public ArrayList<User> getUsers(){
		String[][] allUsersFromDB = DBConnection.user_getUsers();
		
		ArrayList<User> listOfUser = new ArrayList<User>();
		for(int userNum = 0; userNum < allUsersFromDB[0].length; userNum++){
			User currentUser = new User(allUsersFromDB[userNum][0], 
										allUsersFromDB[userNum][1],
										allUsersFromDB[userNum][2], 
										allUsersFromDB[userNum][3], 
										allUsersFromDB[userNum][4], 
										allUsersFromDB[userNum][5] );
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
			if(u.getName() == UserName) {
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
	 * Saves a school to the input users list of saved schools
	 * @param user 
	 * @param school
	 */
	public void saveSchool(User user, School school){
		DBConnection.user_saveSchool(user.getName(), school.getName());
		
	}

	public void removeSavedSchools(User activeUser, School userSchool){
	
	}

	public void addUser(User activeUser){
		
	}

	public boolean checkUsernameAvailability(User activeUser){
		return false;
	}

}


