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
	private AccountController testAccountControlller = new AccountController();
	private AdminFunctionalityController testAdminFunctionalityController = new AdminFunctionalityController();
	private static DBController testDBController = new DBController();
	private static LogOn testLogOn;
	private School testSchool = new School("SCHOOLNAME", "SCHOOLSTATE", "STATELOCATION", "STATECONTROLLER", 1000,
									.5, 720, 790, 10000.1, .1, 2000, .25, .15, 5, 4, 3, new ArrayList<String>());
	private SchoolController testSchoolController = new SchoolController();
	private SearchController testSearchController = new SearchController();
	private static User testUser = new User("USERNAME", "USERPASSWORD", "FIRST", "LAST", 'u', 'Y', new ArrayList<School>());
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
		//Add Test Account
		testDBController.addAccount(testAccount);
		userDriver();
		adminDriver();
		
		
		
		
		
	}

	public static void userDriver() {
		  testLogOn.run("username", "password");
		  System.out.println("*************User View School**********");
		  testUserInteraction.viewSchool("YALE");
		  
		  System.out.println("\n**************User Save School**********");
		  testUserInteraction.saveSchool(testUser,"YALE");
		  testUserInteraction.displaySavedSchools(testUser);
		  
		  System.out.println("\n**************User Remove School**********");
		  testUserInteraction.removeSchool(testUser, "YALE");
		  testUserInteraction.displaySavedSchools(testUser);
	}
	
	public static void adminDriver(){
		AdminFunctionalityController adminFC = new AdminFunctionalityController();
		DBController dbController = new DBController();
		ArrayList<School> schools = new ArrayList<School>();
		ArrayList<Account> accounts = new ArrayList<Account>();
		ArrayList<School> allSchools = dbController.getAllSchools();



		for (School mySchool : allSchools){
			System.out.println(mySchool.getName());
		}

		/**
		 * Add a school
		 */
		ArrayList<String> myEmphasis = new ArrayList<String>();
		myEmphasis.add("MATH");
		School newSchool = new School("test", "null1", "null2", "null3", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, myEmphasis);
		Boolean addSchool = adminFC.addNewSchool(newSchool);
		System.out.println(addSchool);
		System.out.println("----------------------------");
		/**
		 * Removes a school
		 */
//		System.out.println("----------------------------");
//		School test = dbController.getSchool("test");
//		Boolean removedSchool = adminFC.removeSchool(test);
//		System.out.println(removedSchool);
//		
		/**
		 * Views all the schools
		 */
		System.out.println("------------View all the schools----------------");
		schools = adminFC.viewSchools();
		System.out.println(schools);
		
		
		System.out.println("------ U17: Add Account-------");
		
		adminFC.addNewAccount(testAccount);
		System.out.println(testAccount.getUsername());
		System.out.println("--------View the school 'YALE'----------");
		School school = adminFC.viewSchool("YALE");
		System.out.println(school);

		/**
		 * Views all the accounts		
		 */
		System.out.println("-----View all the accounts----------");
		accounts = adminFC.viewAccounts();
		System.out.println(accounts);

		/**
		 * Views a specific account		
		 */
		System.out.println("------View John account-------");
		Account account = adminFC.viewAccount("John");
		System.out.println(account.getUsername());
		
		/**
		 * Add New Account
		 */
		System.out.println("------ U17: Add Account-------");
		
		boolean test1 = adminFC.addNewAccount(testAccount);
		System.out.println(test1);
		/**
		 * Toggle Account Activation
		 */
		System.out.println("------ U16: Toggle Account Activation-------");
		
//		char test = adminFC.toggleActivation(testUser);
//		System.out.println(test);

		
		
		
	
		
	}

}
