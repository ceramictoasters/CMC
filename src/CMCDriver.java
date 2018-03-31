//import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import CMC.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * CMCDriver.java text based driver for CMC
 * 
 * @author Wilmot Osei-Bonsu
 * @version 3/3/18
 */
public class CMCDriver {

	/*A simple driver class which 
	 * demos each of the functionalities in CMC (from your updated use case diagram)
	 * Must include an instance of each of your interaction classes
	 * Must use your interaction classes to demo each functionality by showing sample input and output
	 * Must show that all scenarios for all use cases (i.e. functionalities) work for some sample input
	 * Does not have to be interactive
	 * Output should be clear and easy for me to read and match to the required functionalities in CMC
	*/
	
	
	private static Account testAccount = new Account("ACCOUNTUSERNAME", "ACCOUNTPASSWORD", "ACCOUNTFIRSTNAME", "ACCOUNTLASTNAME", 'a', 'Y');
	private static AdminFunctionalityController testAdminFunctionalityController = new AdminFunctionalityController();
	private static DBController testDBController = new DBController();
	private static LogOn testLogOn;
	private School testSchool = new School("SCHOOLNAME", "SCHOOLSTATE", "STATELOCATION", "STATECONTROLLER", 1000,
									.5, 720, 790, 10000.1, .1, 2000, .25, .15, 5, 4, 3, new ArrayList<String>());
	private SchoolController testSchoolController = new SchoolController();
	private SearchControllerV2 testSearchController = new SearchControllerV2();
	private static User testUser = new User("USERNAME", "USERPASSWORD", "FIRST", "LAST", 'u', 'Y', new ArrayList<School>());
	private static User testDeactivatedUser = new User("DeactiveUser", "DeactivePassword", "deactive", "user", 'u', 'N', new ArrayList<School>());

	private UserFunctionalityController testUserFunctionalityController = new UserFunctionalityController();
	private static UserInteractions testUserInteraction = new UserInteractions();
	

	
	//******************************User*****************************
	//TODO: U1-Log in
	//TODO: U2-View User Menu
	//TODO: U3-Search
	//TODO: U4-View Search Results
	//TODO: U5-View Recommended
	//TODO: U6-View School
	//TODO: U7-SaveSchool
	//TODO: U8-View Saved Schools
	//TODO: U9-Remove
	//*******************ADMIN***********************
	//TODO: U10-Edit Account
	//TODO: U11-Apply Account Changes
	//TODO: U13-View Admin Menu
	//TODO:	U14-View Accounts ***DONE
	//TODO: U15-View Account ***DONE
	//TODO: U16-ToggleActivation ***TESTED
	//TODO: U17-Add New Account ***DONE
	//TODO: U18-View Schools ***DONE
	//TODO: U19-View School ***DONE
	//TODO: U20-Edit Schools
	//TODO: U21-Apply School Changes
	//TODO: U22-Add New School ***DONE
	 
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		System.out.println("Enter Username:");
//		String username = scan.next();
//		System.out.println("\nEnter Password: ");
//		String password = scan.next();
//		LogOn.run(username, password);
	
		//Add Test User
		testDBController.addAccount(testUser);
		testDBController.addAccount(testDeactivatedUser);
		//Add Test Account
		testDBController.addAccount(testAccount);
		userDriver();
		adminDriver();
		
		
		
		
		
	}

	public static void userDriver() {
		  System.out.println("*************Log on**********");
		  System.out.println("Someone is logged in: " + testLogOn.getIsLoggedOn()+ " and current account is: " + testLogOn.getCurrentAccount() + "\n");
		  
		  System.out.println("Logging in with invalid information: 'Imad' , 'Rahal'");
		  testLogOn.run("Imad", "Rahal");
		  System.out.println("Someone is logged in: " + testLogOn.getIsLoggedOn()+ " and current account is: " + testLogOn.getCurrentAccount()+ "\n");
		  
//		  System.out.println("Logging in with while being deactivated");
//		  testLogOn.run(testDeactivatedUser.getUsername(), testDeactivatedUser.getPassword());
//		  System.out.println("Someone is logged in: " + testLogOn.getIsLoggedOn()+ " and current account is: " + testLogOn.getCurrentAccount()+ "\n");

		  System.out.println("Logging in regular");
		  testLogOn.run(testUser.getUsername(), testUser.getPassword());
		  System.out.println("Someone is logged in: " + testLogOn.getIsLoggedOn()+ " and current account is: " + testLogOn.getCurrentAccount()+ "\n");
		  testLogOn.run("username", "password");


		  //System.out.println("Is anyone logged in: " + testLogOn.getIsLoggedOn());//" and current account username is: " + testLogOn.getCurrentAccount().getUsername());
		  

		  System.out.println("*************User View School**********");
		  testUserInteraction.viewSchool("YALE");
		  
		  System.out.println("\n**************User Save School**********");
		  testUserInteraction.saveSchool(testUser,"YALE");
		  testUserInteraction.displaySavedSchools(testUser);
		  
		  System.out.println("\n**************User Remove School**********");
		  testUserInteraction.removeSchool(testUser, "YALE");
		  testUserInteraction.displaySavedSchools(testUser);
		  
		  System.out.println("***************Search**********************");
		  SearchControllerV2 sc = new SearchControllerV2();
		  ArrayList<String>emphasis = new ArrayList<String>();
		  emphasis.add("Something");
		  emphasis.add("Something");
		  System.out.println("Search input:\nschoolName - N/A\nstate - N/A\nlocation - N/A\ncontrol - N/A\n"
		  		+ "numberOfStudentsL - 20000\nnumberOfStudentsH - 41000\nfemaleL - 40\nfemaleH - 65\n"
		  		+ "verbalSATL - 400\nverbalSATH - 800\nmathSATL - 400\nmathSATH - 800\n"
		  		+ "expensesL - 1100\nexpensesH - 20000\naidL - 40\naidH - 90\napplicantsL - 1000 \napplicantsH - 7000\n"
		  		+ "perAdmittedL - N/A\nperAdmittedH - N/A\nperEnrolledL - 60\nperEnrolledH - 100\n"
		  		+ "academicScaleL - 1\nacademicScaleH - 60\nsocialScaleL - 1\nsocialScaleH - 5\n"
		  		+ "qualityScaleL - 1 \nqualityScaleH - 5\nemphasis - N/A\n");
		  ArrayList<School> searchedSchools = sc.search("", "", "", "", 20000, 41000, 40, 65, 400, 800, 400, 800, 1100, 20000, 40, 90, 1000, 7000, -1, -1,60, 100, 1, 60, 1, 5, 1, 5,emphasis);
		  System.out.println( searchedSchools.toString());
			
		  //ArrayList<School> recommended = new ArrayList<School>();
		  //if(!searchedSchools.isEmpty()){
		 		//ArrayList<School> recommended = sc.getRecommendations(searchedSchools.get(0));
			//		System.out.println("Recommended   " + recommended.toString());
			//}
		  DBController dbController = new DBController();
		  School recommendationsSchool = dbController.getSchool("YALE");
		  ArrayList<School> recommended = sc.getRecommendations(recommendationsSchool);
		  System.out.println("Recommended   " + recommended.toString());
	}
	
	public static void adminDriver(){
		AdminFunctionalityController testAdminFunctionalityController = new AdminFunctionalityController();
		DBController dbController = new DBController();
		ArrayList<School> schools = new ArrayList<School>();
		ArrayList<Account> accounts = new ArrayList<Account>();
		ArrayList<Account> allAccounts = dbController.getAccounts();
		ArrayList<School> allSchools = dbController.getAllSchools();



		for (School mySchool : allSchools){
			System.out.println(mySchool.getName());
		}

//		/**
//		 * Add a school
//		 */
//		ArrayList<String> myEmphasis = new ArrayList<String>();
//		myEmphasis.add("MATH");
//		School newSchool = new School("test", "null1", "null2", "null3", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, myEmphasis);
//		Boolean addSchool = testAdminFunctionalityController.addNewSchool(newSchool);
//		System.out.println(addSchool);
//		System.out.println("----------------------------");
//		/**
//		 * Removes a school
//		 */
//		System.out.println("----------------------------");
//		School test = dbController.getSchool("test");
//		Boolean removedSchool = testAdminFunctionalityController.removeSchool(test);
//		System.out.println(removedSchool);
//		
//		/**
//		 * Views all the schools
//		 */
//		System.out.println("------------View all the schools----------------");
//		schools = testAdminFunctionalityController.viewSchools();
//		System.out.println(schools);
		
		
		System.out.println("------ U17: Add Account-------");
		
		testAdminFunctionalityController.addNewAccount(testAccount);
		System.out.println(testAccount.getUsername());
		
		System.out.println("--------View the school 'YALE'----------");
		School school = testAdminFunctionalityController.viewSchool("YALE");
		System.out.println(school);

		/**
		 * Views all the accounts		
		 */
		System.out.println("-----View all the accounts----------");
		accounts = testAdminFunctionalityController.viewAccounts();
		System.out.println(accounts);

		/**
		 * Views a specific account		
		 */
		System.out.println("------View John account-------");
		Account account = testAdminFunctionalityController.viewAccount("John");
		System.out.println(account);
		
		/**
		 * Add New Account
		 */
		System.out.println("------ U17: Add Account-------");
		//Account myAccount = new Account("AUN", "AP", "AFN", "ALN", 'a', 'Y');
		//boolean test1 = testAdminFunctionalityController.addNewAccount(myAccount);
		//System.out.println(test1);
		/**
		 * Toggle Account Activation
		 */
		System.out.println("------ U16: Toggle Account Activation--------------------------------------------");
		
		System.out.println(testUser);
		char initialStatus = testUser.getStatus();
		testUser = testAdminFunctionalityController.toggleActivation(testUser);
		System.out.println(testUser.getUsername()+ " was changed from " + initialStatus+ " to " + testUser.getStatus() + "\n\n");
		System.out.println(testUser+ "\n\n");
		
		initialStatus = testUser.getStatus();
		testUser = testAdminFunctionalityController.toggleActivation(testUser);
		System.out.println(testUser.getUsername()+ " was changed from " + initialStatus+ " to " + testUser.getStatus() + "\n\n");
		System.out.println(testUser+ "\n");
		
		System.out.println("------ UXX: DeleteAccount--------------------------------------------");

		Account test = dbController.getAccount("AUN");
		Boolean removedSchool = testAdminFunctionalityController.deleteAccount(test);
		System.out.println(removedSchool);
		
		
		System.out.println("------ size of schools in database--------------------------------------------");
		System.out.println(allSchools.size());
		System.out.println("------ size of accounts in database--------------------------------------------");
		System.out.println(allAccounts.size());
		
		
	}

}
