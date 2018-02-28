 /*
 * AdminFunctionalityController 
 * @Version February 27, 2018
 */
public class AdminFunctionalityController
{
/*
 * 
 */
  public void viewSchools()
  {
    School [] schools = DBController.getAllSchools(); 
    return schools;
  }
  public void viewSchool(String name)
  {
    school = DBController.getSchool(name);
    return school;
  }
  public void addNewSchool(String name)
  {
     newSchool = DBController.addNewSchool(name);
     return newSchool;
  }
  public void viewAccounts()
  {
    User [] users = DBController.getUsers();
    return users
  }
  public void addNewUser(String name, String pass, String type, String, char)
  {
    AccountController.createUser(name,password,type)
  }
  public void deactivateUser(Account user)
  {
    user.AccountController.deactivate();
  }
  public void viewAccount(String user )
  {
    account = DBController.getUser(user);
    return account;
  }
}