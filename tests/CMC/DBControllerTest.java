/**
 * 
 */
package CMC;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * @author woseibons001
 *
 */ 
public class DBControllerTest {
	/**
	 * @throws java.lang.Exception
	 */

	DBController DBTest = new DBController();
	User testUser;
	Account testAdmin;
	School testSchool;

	@Before
	public void setUp() throws Exception {
		testUser = new User("testUsername", "testPassword", "testFirstName", "testLastName", 'u', 'Y',
				new ArrayList<School>());
		testAdmin = new Account("testAdminUsername", "testAdminPassword", "testAdminFirstName", "testAdminLastName",
				'a', 'Y');
		testSchool = new School("SchoolName", "SchoolState", "SchoolLocation", "SchoolControl", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, new ArrayList<String>());
	}

	// Usual-Testing**************************************************************************************************************************************************************************************
	// ************************************************************************************************************************************************************************************************

	// Finished
	@Test
	public void testAddNewSchoolSuccessfullyAdded() {
		DBTest.addNewSchool(testSchool);
		assertTrue("testAdmin Should Be Added To The Database", DBTest.getAllSchools().contains(testSchool));
		DBTest.deleteSchool(testSchool);
	}

	// Finished
	@Test(expected = IllegalArgumentException.class)
	public void testAddNewSchoolFailsForDatabaseError() {
		// adding school already in database
		DBTest.addNewSchool(testSchool);
		assertFalse("The School Should Not Be Added To The Database", DBTest.addNewSchool(testSchool));
		DBTest.deleteSchool(testSchool);
	}

	// Finished
	@Test
	public void testEditSchoolSuccessfull() {
		//DBTest.addNewSchool(testSchool);
		testSchool.setName("EditedSchool");
		DBTest.editSchool(testSchool);
		assertTrue("School in the database should now have a name of 'editedSchool'",
				DBTest.getSchool("EditedSchool").getName().equals("EditedSchool"));
		DBTest.deleteSchool(testSchool);
	}

	// Finished
	@Test
	public void testCheckUsernameAvailabilitySuccessForAvailibleUserName() {
		assertTrue("IMAD is not username currently being used", DBTest.checkUsernameAvailability("IMAD"));
	}

	// Finished
	@Test
	public void testCheckUsernameAvailabilityFailsForTakenUserName() {
		assertFalse("juser is  username currently being used", DBTest.checkUsernameAvailability("juser"));
	}

	//Finished
	@Test
	public void testGetAdminPassesForAdminInDatabase() {
		DBTest.addAccount(testAdmin);
		assertTrue("testAdmin Should be returned because it is an admin", DBTest.getAdmin(this.testAdmin.getUsername()).equals(this.testAdmin));
	}
	
	//Finished
	@Test
	public void testGetAdminFailsForNotAnAdminInDatabase() {
		DBTest.addAccount(testUser);
		assertTrue("Should return null because testUser is not an valid admin in the database", DBTest.getAdmin(this.testUser.getUsername()) == null);
	}
	
	//Finished
	@Test
	public void testGetUserPassesForUserInDatabase() {
		DBTest.addAccount(testUser);
		assertTrue("testAdmin Should be returned because it is an user", DBTest.getUser(this.testUser.getUsername()).equals(this.testUser));
	}
	 
	//Finished
	@Test
	public void testGetUserFailsForNotAnUserInDatabase() {
		DBTest.addAccount(testAdmin);
		assertTrue("Should return null because testUser is not an valid user in the database", DBTest.getUser(this.testAdmin.getUsername()) == null);
	}
	
	//Finished
	@Test
	public void testGetAccountPassesForAccountInDatabase() {
		DBTest.addAccount(testAdmin);
		assertTrue("Should return testUser because its in the database", DBTest.getAccount(this.testAdmin.getUsername()).equals(testAdmin));
	}
	
	//Finished
	@Test
	public void testGetAccountFailsForAccountNotInDatabase() {
		assertTrue("Should return null because testAdmin is not an valid user in the database but instead returns " + DBTest.getAccount(this.testAdmin.getUsername()), DBTest.getAccount(this.testAdmin.getUsername()) == null);
	}
	
	// Blackbox-Testing**************************************************************************************************************************************************************************************
	// ************************************************************************************************************************************************************************************************

	public void testCredentialValidation() {
		fail("Not yet implemented");
	}

	public void testRemoveSavedSchools() {
		fail("Not yet implemented");
	}

	public void testSaveSchool() {
		fail("Not yet implemented");
	}

	public void testViewSavedSchooSuccessfulForUserInDatabase() {
		fail("Not yet implemented"); 
	}

	// Whitebox-Testing**************************************************************************************************************************************************************************************
	// ************************************************************************************************************************************************************************************************
	
	// Finished
	@Test(expected = IllegalArgumentException.class)
	public void testDeleteSchoolFailsForInvalidSchoolNotInTheDatabase() {
		DBTest.deleteSchool(new School("CUP UNIVERSITY", null, null, null, -1, -2, -3, -4, -5, -6, -7, -8, -9, 10, 11,
				12, new ArrayList<String>()));
	}

	
	// Finished - However it doesnt go through this path consider removing this check
	@Test(expected = IllegalArgumentException.class)
	public void testDeleteSchoolFailsForSchoolSavedByUser() {
		DBTest.addAccount(testUser);
		DBTest.saveSchool(testUser, testSchool);
		DBTest.deleteSchool(DBTest.getSchool("SchoolName"));
	}


	//Finished
	@Test
	public void testDeleteSchoolValidCase() {
		System.out.println(DBTest.getSchool(testSchool.getName()));
		DBTest.addNewSchool(testSchool);
		assertTrue("SchoolName Should be removed", DBTest.deleteSchool(testSchool));
	}

	
	//Finished
//	@Test
	public void testDeleteSchoolRemovesASchoolWithEmphasisValues() {
		testSchool.getAreasOfStudy().add("TestEmphasis");
		DBTest.addNewSchool(testSchool);
		assertTrue("School is not deleted ", DBTest.deleteSchool(testSchool));
	}
	
	
	//Dont Think i need this anymore
	public void testDeleteAccountAdminDatabaseError() {
		fail("Not yet implemented");
	}

	
	//Finish
	@Test
	public void testDeleteAccountAdminDeletedFromTheDatabase() {
		System.out.println(DBTest.getAccount(testAdmin.getUsername()));
		DBTest.addAccount(testAdmin);
		assertTrue("Admin deleted from database", DBTest.deleteAccount(testAdmin));
	}

	
	//Finished
	@Test
	public void testDeleteAccountUserDeletedFromDatabaseError() {
		DBTest.addAccount(testUser);
		assertTrue("User deleted from database", DBTest.deleteAccount(testUser));
	}

	
	//Finsished
	@Test(expected = IllegalArgumentException.class)
	public void testAddAccountAdminDatabaseError() {
		DBTest.addAccount(testAdmin);
		DBTest.addAccount(testAdmin);
	}
	
	
	//Finished
	@Test 
	public void testAddAccountAdminAddedToTheDatabase() {
		assertTrue("Account of type admin has been added to the database", DBTest.addAccount(testAdmin));
	}

	
	//Finished
	@Test(expected = IllegalArgumentException.class)
	public void testAddAccountUserDatabaseError() {
		DBTest.addAccount(testUser);
		assertFalse("fails for adding a user with the same username", DBTest.addAccount(testUser));	}

	
	//Finished
	@Test
	public void testAddAccountUserAddedToDatabase() {
		assertTrue("Account of type user has been added to the database", DBTest.addAccount(testUser));
	}

	
	//Finished
	@Test (expected = IllegalArgumentException.class)
	public void testAddAccountUserInvalidType() {
		testUser.setType('e');
		assertTrue("Account of type user has been added to the database", DBTest.addAccount(testUser));
	}

	//Finished
	@Test 
	public void testEditAccountValidAccount() {
		DBTest.addAccount(testAdmin);
		testAdmin.setLast("ADMIN");
		assertTrue("testAdmin should be edited in the database", DBTest.editAccount(testAdmin.getUsername(), testAdmin.getPassword(), testAdmin.getFirst(), testAdmin.getLast(), testAdmin.getType(), testAdmin.getStatus()));
		DBTest.deleteAccount(testAdmin);
	}

	//Finished
	@Test
	public void testEditAccountValidUser() {
		DBTest.addAccount(testUser);
		testUser.setLast("USER");
		assertTrue("testUser should be edited in the databse",  DBTest.editAccount(testUser.getUsername(), testUser.getPassword(), testUser.getFirst(), testUser.getLast(), testUser.getType(), testUser.getStatus()) );
		DBTest.deleteAccount(testUser);

	}
	
	//Finished
	@Test(expected = IllegalArgumentException.class)
	public void testEditAccountFalisForInvalidType() {
		DBTest.addAccount(testUser);
		testUser.setType('i');
		DBTest.editAccount(testUser.getUsername(), testUser.getPassword(), testUser.getFirst(), testUser.getLast(), testUser.getType(), testUser.getStatus());
	}

	
	//Finished
	@Test(expected = IllegalArgumentException.class)
	public void testToggleActivatonInvalidType() {
		testUser.setType('a');
		DBTest.toggleActivaton(testUser);
	}

	
	//Finished
	@Test
	public void testToggleActivatonDeactivateUserToActiveUser() {
		testUser.setStatus('N');
		DBTest.addAccount(this.testUser);
		DBTest.toggleActivaton(this.testUser);
		assertTrue("User should be active now", DBTest.getUser(testUser.getUsername()).getStatus() == 'Y');
	}

	
	//Finished
	@Test
	public void testToggleActivatonActiveUserToDeactivatedUser() {
		testUser.setStatus('Y');
		DBTest.addAccount(this.testUser);
		DBTest.toggleActivaton(this.testUser);
		assertTrue("User should be de-active now", DBTest.getUser(testUser.getUsername()).getStatus() == 'N');	}

	
	//Finished
	@Test(expected = IllegalArgumentException.class)
	public void testToggleActivatonInvalidStatus() {
		testUser.setStatus('W');
		DBTest.addAccount(this.testUser);
		DBTest.toggleActivaton(this.testUser);
	} 

	// JUnit-Methods*************************************************************************************************************************************************************************************
	// ******************************************************************************************************************************************************************************************************
	@After
	public void reset() {
		try {
			UniversityDBLibrary DBConnection = new UniversityDBLibrary("cerami", "cerami", "csci230");
			DBTest.removeSavedSchools(testUser, testSchool);
			DBConnection.university_deleteUniversity("SchoolName");
			DBConnection.user_deleteUser("testUsername");
			DBConnection.user_deleteUser("testAdminUsername");
		} catch (IllegalArgumentException e) {
		}
	}

	@BeforeClass
	public static void DatabaseResetBefore() {
	UniversityDBLibrary DBConnection = new UniversityDBLibrary("cerami", "cerami", "csci230");
	DBConnection.university_deleteUniversity("SchoolTest");
	DBConnection.user_deleteUser("testUser");
	DBConnection.user_deleteUser("testadmin");
	}

	@AfterClass
	public static void DatabaseResetAfter() {
		UniversityDBLibrary DBConnection = new UniversityDBLibrary("cerami", "cerami", "csci230");
		DBConnection.university_deleteUniversity("SchoolName");
		DBConnection.user_deleteUser("testUsername");
		DBConnection.user_deleteUser("testAdminUsername");
	}
}
