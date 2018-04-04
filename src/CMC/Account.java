/**Account.java
 */
package CMC;
/** 
 * Account is a super class for the User entity, and also represents
 * the Admin accounts with its own functionalities
 * 
 * @author  Connor Smith
 * @version February 26, 2018
 */
public class Account {
 
/**
 * username: the account's unique username
 */
 private String username;
 
 /**
  * password: the account's password
  */
 private String password;
 
 /**
  * first: the first name of the owner of this account
  */
 private String first;
 
 /**
  * last: the last name of this account
  */
 private String last;
 
 /**
  * type: the account's type 
  */
 private char type;
 
 /**
  * status: the current status of the account
  */
 private char status;
 
 /**
  * loggedOn: true if this account is logged on
  */
 private boolean loggedOn;
   
 /**
  * Constructor that sets all initial values to those specified at creation of 
  * Account object, loggedOn initialized to False
  * 
  * @param Account's username
  * @param Account's password
  * @param Account's first name 
  * @param Account's last name
  * @param Account type
  * @param account status
  */
 public Account(String username, String password, String first, String last, char type, char status){ 
    this.username = username;
    this.password = password;
    this.first = first;
    this.last = last;
    this.type = type;
    if (!(type == 'a' || type == 'u')) throw new IllegalArgumentException("INVALID TYPE");
    this.status = status;
    if (!(status == 'Y' || status == 'Y')) throw new IllegalArgumentException("INVALID STATUS");
    this.loggedOn = false;
   }
   
  /**
    * Returns the username of this account
    * 
    * @return logged in account's username
    */
   public String getUsername(){
     return this.username;
   }
   
   /**
    * Returns the password of this account
    * 
    * @return logged in account's password
    */
   public String getPassword(){
     return this.password;
   }
   
   /**
    * Returns the first name of this account
    * 
    * @return logged in account's first name
    */
   public String getFirst(){
     return this.first;
   }
   
   /**
    * Returns the last name of this account
    * 
    * @return logged in account's last name
    */
   public String getLast(){
     return this.last;
   }
   
   /**
    * Returns the account type of this account
    * 
    * @return logged in account's type
    */
   public char getType(){
     return this.type;
   }
   
   /**
    * Returns the status (active or inactive) of this account
    * 
    * @return logged in account's status
    */
   public char getStatus(){
     return this.status;
   }
   
   /**
    * Returns whether or not this account is logged in
    * 
    * @return boolean determining whether or not this account is logged in
    */
   public boolean isLoggedOn(){
     return this.loggedOn;
   }
   
   /**
    * Sets password to new password entered by user
    * 
    * post: password of this account is set to new password
    */
   public void setPassword(String newPassword){
     this.password = newPassword;
   }
   
   /**
    * Sets first name to new name entered by user
    * 
    * post: first name of this account is set to new first name
    */
   public void setFirst(String newFirst){
     this.first = newFirst;
   }
   
   /**
    * Sets last name to new name entered by user
    * 
    * post: last name of this account is set to new last name
    */
   public void setLast(String newLast){
     this.last = newLast;
   }
   
   /**
    * This method changes the account's type
    * 
    * post: type of this account is set to new type
    */
   public void setType(char newType){
 	  if (!(newType == 'a' || newType == 'u')) throw new IllegalArgumentException();
 	  this.type = newType;
   }
   
   /**
    * This method changes the account's type
    * 
    * post: status of this account is set to new status
    */
   public void setStatus(char newStatus){
 	  if (!(newStatus == 'Y' || newStatus == 'N')) throw new IllegalArgumentException();
 	  this.status = newStatus;
   }
   
   /**
    * Sets login status (logged in or not)
    * 
    * post: login status is changed
    */
   public void setLoggedOn(boolean newLoggedOn){
     this.loggedOn = newLoggedOn;
   }
   
   public String toString() {
	   return ("Username: " + this.username + "\nPassword: " +  this.password + "\nFirst Name: " + this.first + "\nLast Name: " + this.last + "\nType: " + this.type + "\nStatus: " + this.status);
   }

   public User toUser() {
	    return new User(this.getUsername(), this.getPassword(), this.getFirst(), this.getLast(), 'u', this.getStatus(), null);
	   }

}
