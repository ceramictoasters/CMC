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
	
	private Account testAccount;
	private AccountController testAccountControlller;
	private AdminFunctionalityController testAdminFunctionalityController;
	private DBController testDBController;
	private LogOn testLogOn;
	private School testSchool;
	private SchoolController testSchoolController;
	private SearchController testSearchController;
	private User testUser;
	private UserFunctionalityController testUserFunctionalityController;
	private UserInteractions testUserInteraction;
	
	
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
	//TODO:	U14-View Accounts
	//TODO: U15-Deactivate Account
	//TODO: U16-Add New Account
	//TODO: U17-View Schools
	//TODO: U18-Edit Schools
	//TODO: U19-Apply School Changes
	//TODO: U20-Create New School
	//TODO: U22-Add School
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		System.out.println("Enter Username:");
//		String username = scan.next();
//		System.out.println("\nEnter Password: ");
//		String password = scan.next();
//		LogOn.run(username, password);
		
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
//		School newSchool = new School("verbum", "null1", "null2", "null3", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null);
//		Boolean addSchool = adminFC.addNewSchool(newSchool);
//		System.out.println(addSchool);
//		System.out.println("----------------------------");
		/**
		 * Removes a school
		 */
//		School verbum = dbController.getSchool("verbum");
//		Boolean removedSchool = adminFC.removeSchool(verbum);
//		System.out.println(removedSchool);
//		System.out.println("----------------------------");
		/**
		 * Views all the schools
		 */
		System.out.println("------------View all the schools----------------");
		schools = adminFC.viewSchools();
		System.out.println(schools);
		/**
		 * Views a specific school
		 */
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
	}

	public void userLogin() {
	
	}
}
