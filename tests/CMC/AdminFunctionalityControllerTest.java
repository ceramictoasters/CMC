/**
 * 
 */
package CMC;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author rmorris001
 *
 */
public class AdminFunctionalityControllerTest {
	private AdminFunctionalityController AFC;
	private DBController dbController;
	private ArrayList<School> schools;
	private ArrayList<Account> accounts;
	private ArrayList<Account> dBAccounts;
	private ArrayList<School> allSchools;
	private School testSchool;
	private static Account testAccount;
	private ArrayList<String> myEmphasis;
	private static User testUser;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		AFC = new AdminFunctionalityController();
		dbController = new DBController();
		schools = new ArrayList<School>();
		accounts = new ArrayList<Account>();
		dBAccounts = dbController.getAccounts();
		allSchools = dbController.getAllSchools();
		myEmphasis = new ArrayList<String>();
		myEmphasis.add("MATH");
		testSchool = new School("SCHOOLNAME", "SCHOOLSTATE", "STATELOCATION", "STATECONTROLLER", 1000,
				.5, 720, 790, 10000.1, .1, 2000, .25, .15, 5, 4, 3, myEmphasis );
		testAccount = new Account("ACCOUNTUSERNAME", "ACCOUNTPASSWORD", "ACCOUNTFIRSTNAME",
				"ACCOUNTLASTNAME", 'a', 'Y');
		testUser = new User("USERNAME", "USERPASSWORD", "FIRST", "LAST", 'u', 'Y', new ArrayList<School>());
		
		
	}

	/**
	 * Test method for {@link CMC.AdminFunctionalityController#viewSchools()}.
	 */
	@Test
	public void testViewSchools() {
		schools = AFC.viewSchools();
		assertEquals("The number should be 181 ", allSchools.size() ,schools.size());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link CMC.AdminFunctionalityController#viewSchool(java.lang.String)}.
	 */
	@Test
	public void testViewSchool() {
		School yale = AFC.viewSchool("Yale");
		assertEquals("The school should be Yale", dbController.getSchool("Yale"), yale);
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link CMC.AdminFunctionalityController#addNewSchool(CMC.School)}.
	 */
	@Test
	public void testAddNewSchool() {
		assertTrue("TestSchool should be added", AFC.addNewSchool(testSchool));
		
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link CMC.AdminFunctionalityController#removeSchool(CMC.School)}.
	 */
	@Test
	public void testRemoveSchool() {
		School schoolName = dbController.getSchool("SCHOOLNAME");
		
		boolean deletedSchool = AFC.removeSchool(schoolName);
		
		assertTrue("TestSchool Should be Deleted", deletedSchool);
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link CMC.AdminFunctionalityController#viewAccounts()}.
	 */
	@Test
	public void testViewAccounts() {
		accounts = AFC.viewAccounts();
		assertEquals("The number should be 10 ", dBAccounts.size() ,accounts.size());
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link CMC.AdminFunctionalityController#addNewAccount(CMC.Account)}.
	 */
	@Test
	public void testAddNewAccount() {
		assertTrue("AccountUsername should be added", AFC.addNewAccount(testAccount));
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link CMC.AdminFunctionalityController#toggleActivation(CMC.User)}.
	 */
	@Test
	public void testToggleActivation() {
		char initialStatus = testUser.getStatus();
		testUser = AFC.toggleActivation(testUser);
		testUser = AFC.toggleActivation(testUser);
		char initialStatus2 = testUser.getStatus();
		assertEquals("The status should be Y ",initialStatus,initialStatus2);
		
		
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link CMC.AdminFunctionalityController#viewAccount(java.lang.String)}.
	 */
	@Test
	public void testViewAccount() {
		Account john = AFC.viewAccount("John");
		assertTrue("This should be John", dbController.getAccount("John").equals(john));
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link CMC.AdminFunctionalityController#editSchool(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, double, int, int, double, double, int, double, double, int, int, int, java.util.ArrayList)}.
	 */
	@Test
	public void testEditSchool() {
		boolean editedSchool = AFC.editSchool("PINEAPPLE", "SCHOOLSTATE", "STATELOCATION", "STATECONTROLLER", 1000,
				.5, 720, 790, 10000.1, .1, 2000, .25, .15, 5, 4, 3, myEmphasis );
		//System.out.println(editedSchool);
		assertTrue("SCHOOLNAME should be changed into PineApple",editedSchool);
		//fail("Not yet implemented");
	}
	/**
	 * Test method for {@link CMC.AdminFunctionalityController#editAccount(java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.String, char, status)}.
	 */ 
	@Test
	public void testEditAccount() {
		boolean editedAccount = AFC.editAccount("ACCOUNTUSERNAME","ACCOUNTPASSWORD", "RICHARD", "ACCOUNTLASTNAME", 'a', 'y');
		assertTrue("The first name on the account should be changed to Richard",editedAccount);
		//fail("Not yet implemented");
	}
	/**
	 * Test method for {@link CMC.AdminFunctionalityController#deleteAccount(CMC.Account)}.
	 */
	@Test
	public void testDeleteAccount() {
		
		//boolean deletedAccount = AFC.deleteAccount(testAccount);
		//assertTrue("TestSchool Should be Deleted", deletedAccount);
		fail("Not yet implemented");
	}
	
	@After
	public void deleteALL()
	{
		AFC.deleteAccount(testAccount);
		
		AFC.removeSchool(testSchool);
	}

	

}
