/**
 * 
 */
package CMC;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

/**
 * @author ctate001
 */
public class UserFunctionalityControllerTest {
	private UserFunctionalityController UFC;
	private DBController DBC;
	private User testUser;
	
	//BEFORE
	@Before
	public void setUp() throws Exception {
		DBC = new DBController();
		testUser = new User("USERTEST", "USERTESTPASSWORD", "FIRST", "LAST", 'u', 'Y', new ArrayList<School>());
		DBC.addAccount(testUser);
		LogOn.setCurrentAccount((Account)testUser);
		UFC = new UserFunctionalityController();
	}
	
	//VIEW SEARCH RESULTS
	@Test
	public void testViewSearchResultsNull() {
		assertTrue("Search results should be null", UFC.viewSearchResults().size()==0);
	}
	
	@Test
	public void testViewSearchResultsValid() {
		UFC.inputSearchData();
		ArrayList<School> results = UFC.viewSearchResults();
		System.out.println("results"+results);
		assertTrue("Search results should be valid", results.size()>0);
	}
	
	//VIEW SCHOOL
	@Test
	public void testViewSchoolNull() {
		assertTrue("View school should be null", UFC.viewSchool("InvalidSchoolName")==null);
	}
	
	@Test
	public void testViewSchoolValid() {
		assertTrue("View school should be valid", UFC.viewSchool("YALE")!=null);
	}
	
	//SAVE SCHOOL
	@Test
	public void testSaveSchoolInvalidName() {
		boolean saved = UFC.saveSchool("InvalidSchoolName");
		assertTrue("Save school should be false", !saved);
	}
	
	@Test
	public void testSaveSchoolValid() {
		boolean saved = UFC.saveSchool("YALE");
		assertTrue("Save school should be true", saved);
	}
	
	@Test
	public void testSaveSchoolAlreadySaved() {
		UFC.saveSchool("YALE");
		boolean saved = UFC.saveSchool("YALE");
		assertTrue("Save school should be false", !saved);
	}
	
	//VIEW SAVED SCHOOLS
	@Test (expected = IllegalArgumentException.class)
	public void testViewSavedSchoolsInvalid() {
		testUser.setType('a');
		UFC.viewSavedSchools();
		testUser.setType('u');
	}
	
	@Test
	public void testViewSavedSchoolsValid() {
		UFC.saveSchool("YALE");
		UFC.saveSchool("BROWN");
		System.out.println(UFC.viewSavedSchools());
		assertTrue("Saved schools should be valid", UFC.viewSavedSchools().size()!=0);
	}
	
	//REMOVE SCHOOL
	@Test
	public void testRemoveSchoolInvalidName() {
		boolean removed = UFC.removeSchool("InvalidSchoolName");
		assertTrue("Saved list should be empty", !removed);
	}
	
	@Test
	public void testRemoveSchoolValid() {
		UFC.saveSchool("BROWN");
		UFC.saveSchool("YALE");
		boolean removed = UFC.removeSchool("YALE");
		assertTrue("Saved list should be empty", removed);
	}
	
	@Test
	public void testRemoveSchoolInvalid() {
		boolean removed = UFC.removeSchool("YALE");
		assertTrue("Saved list should be empty", !removed);
	}
	
	//VIEW USER
	@Test
	public void testViewProfile() {
		assertTrue("Viewed profile should match testUser", UFC.viewProfile().equals(testUser));
	}
	
	//EDIT PROFILE
	@Test
	public void testEditProfileValidFirst() {
		UFC.editProfile("NEWFIRST","LAST","USERTESTPASSWORD");
		assertTrue("New first name should be \"NEWFIRST\"", testUser.getFirst().equals("NEWFIRST"));
	}
	
	@Test
	public void testEditProfileValidLast() {
		UFC.editProfile("NEWFIRST","NEWLAST","USERTESTPASSWORD");
		assertTrue("New last name should be \"NEWLAST\"", testUser.getLast().equals("NEWLAST"));
	}
	
	@Test
	public void testEditProfileValidPassword() {
		UFC.editProfile("NEWFIRST","NEWLAST","NEWUSERTESTPASSWORD");
		assertTrue("New password should be \"NEWUSERTESTPASSWORD\"", testUser.getPassword().equals("NEWUSERTESTPASSWORD"));
	}
	
	@Test
	public void testEditProfileInvalidFirst() {
		UFC.editProfile(null,"LAST","USERTESTPASSWORD");
		assertTrue("First name should be \"FIRST\"", testUser.getFirst().equals("FIRST"));
	}
	
	@Test
	public void testEditProfileInvalidLast() {
		UFC.editProfile("FIRST",null,"USERTESTPASSWORD");
		assertTrue("Last name should be \"LAST\"", testUser.getLast().equals("LAST"));
	}
	
	@Test
	public void testEditProfileInvalidPassword() {
		UFC.editProfile("FIRST","LAST",null);
		assertTrue("Password should be \"USERTESTPASSWORD\"", testUser.getPassword().equals("USERTESTPASSWORD"));
	}
	
	@After
	public void deleteTestUser() {
		DBC.deleteAccount(testUser);
		LogOn.setCurrentAccount(null);
	}
}
