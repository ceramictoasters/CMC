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
 
 private String username;
 private String password;
 private String first;
 private String last;
 private char type;
 private char status;
 private boolean loggedOn;
   
 /**
  * Constructor that sets all initial values to those specified at creation of 
  * Account object, loggedOn initialized to False
  */
 public Account(String username, String password, String first, String last, char type, char status){ 
    this.username = username;
    this.password = password;
    this.first = first;
    this.last = last;
    this.type = type;
    this.status = status;
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
    * Sets type to type (a or u) entered by user
    * 
    * post: type of this account is set to new type
    */
   public void setType(char newType){
     this.type = newType;
   }
   
   /**
    * Sets status to value (Y or N) entered by user
    * 
    * post: status of this account is set to new status
    */
   public void setStatus(char newStatus){
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

}
