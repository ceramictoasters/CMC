import java.util.ArrayList;

/**
 * AdminFunctionalityController 
 * @Version February 27, 2018
 */
public class AdminFunctionalityController
{
/**
 * @return schools
 */
  public ArrayList<School> viewSchools()
  {
    return DBController.getAllSchools();
  }
  /**
   * returns a school 
   * @param name: String
   * @return school
   */
  public School viewSchool(String name)
  {
   
    return DBController.getSchool(name);
  }
  /**
   * Adds a new school 
   * @param school
   * @return newSchool
   */
  public School addNewSchool(School school)
  {
     School newSchool = DBController.addNewSchool(school);
     return newSchool;
  }
  /**
   * Returns an array of accounts
   * @return user
   */
  public ArrayList<User> viewAccounts()
  {
	 return DBController.getAccount();
  }
  /**
   * Creates a new user 
   * @param firstName
   * @param lastName
   * @param username
   * @param password
   * @param type
   * 
   */
  public void addNewUser(String firstName, String lastName, String username, String password, char type)
  {
    AccountController.createUser(firstName,lastName,username, password,type);
  }
  /**
   * Deactivates a user with a given user
   * @param user
   * 
   */
  public void deactivateUser(Account user)
  {
    user.AccountController.deactivate();
  }
  /**
   * Views an account
   * @param user
   */
  public User viewAccount(String name )
  {
    return DBController.getAccount(name);
  }
}