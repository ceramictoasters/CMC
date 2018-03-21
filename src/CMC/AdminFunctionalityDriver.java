package CMC;

import java.util.ArrayList;

/**
 * @author rmorris001
 *
 */
public class AdminFunctionalityDriver extends AdminFunctionalityController {
	public static void main(String[] args)
	{
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
}
