package CMC;
import java.util.*;

/** 
 * User is subclass of Account, although it contains similar variables,
 * the User entity has different functionalities
 * 
 * @author  Connor Smith
 * @version February 26, 2018
 */
public class User extends Account{
	
/**
 * savedSchools: list of schools saved by this user
 */
  private ArrayList<School> savedSchools;
  
  /**
   * Constructor that sets all initial values to those specified at creation of 
   * User object, loggedOn initialized to False
   * 
   * @param User's username
   * @param User's password
   * @param User's first name 
   * @param User's last name
   * @param Account type
   * @param Account status
   * @param list of User's saved schools
   */
  public User(String username, String password, String first, String last, char type, char status, ArrayList<School> savedSchools){
   super(username, password, first, last, type, status);
   this.savedSchools = savedSchools;
  }
  
  /**
   * Returns list of saved schools for this logged on user
   * 
   * @return list of saved schools
   */
  public ArrayList<School> getSaved(){  
   return savedSchools;
  }
  
  /**
   * Adds a particular school to the list of saved schools
   * 
   * post: new school is added to list of schools saved by this user
   */
  public void saveSchool(School newSchool){
    savedSchools.add(newSchool);
  }
  
  /**
   * This method ensures that User entity cannot change its own type
   * 
   * post: type of this account is set to new type
   */
  public void setType(char newType){
    return;
  }
  
  /**
   * This method ensures that User entity cannot change its own status
   * 
   * post: status of this account is set to new status
   */
  public void setStatus(char newStatus){
    return;
  }
}