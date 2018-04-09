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
		boolean saved = UFC.saveSchool(testUser, "InvalidSchoolName");
		assertTrue("Save school should be false", !saved);
	}
	
	@Test
	public void testSaveSchoolValid() {
		boolean saved = UFC.saveSchool(testUser, "YALE");
		assertTrue("Save school should be true", saved);
	}
	
	@Test
	public void testSaveSchoolAlreadySaved() {
		UFC.saveSchool(testUser, "YALE");
		boolean saved = UFC.saveSchool(testUser, "YALE");
		assertTrue("Save school should be false", !saved);
	}
	
	//VIEW SAVED SCHOOLS
	@Test (expected = NullPointerException.class)
	public void testViewSavedSchoolsInvalid() {
		System.out.println(UFC.viewSavedSchools(null));
	}
	
	@Test
	public void testViewSavedSchoolsValid() {
		UFC.saveSchool(testUser, "YALE");
		UFC.saveSchool(testUser, "BROWN");
		System.out.println(UFC.viewSavedSchools(testUser));
		assertTrue("Saved schools should be valid", UFC.viewSavedSchools(testUser).size()!=0);
	}
	
	//REMOVE SCHOOL
	@Test
	public void testRemoveSchoolInvalidName() {
		boolean removed = UFC.removeSchool(testUser, "InvalidSchoolName");
		assertTrue("Saved list should be empty", !removed);
	}
	
	@Test
	public void testRemoveSchoolValid() {
		UFC.saveSchool(testUser, "BROWN");
		UFC.saveSchool(testUser, "YALE");
		boolean removed = UFC.removeSchool(testUser, "YALE");
		assertTrue("Saved list should be empty", removed);
	}
	
	@Test
	public void testRemoveSchoolInvalid() {
		boolean removed = UFC.removeSchool(testUser, "YALE");
		assertTrue("Saved list should be empty", !removed);
	}
	
	//VIEW USER
	@Test
	public void testViewProfile() {
		assertTrue("Viewed profile should match testUser", UFC.viewProfile().equals(testUser));
	}
	
	//EDIT PROFILE
	@Test
	public void testEditProfileFirstName() {
		UFC.editProfile("NEWFIRST","LAST","USERTESTPASSWORD");
		assertTrue("New  should be ", testUser.getFirst().equals("NEWFIRST"));
	}
	
	@Test
	public void testEditProfileLastName() {
		UFC.editProfile("NEWFIRST","NEWLAST","USERTESTPASSWORD");
		assertTrue("New  should be ", testUser.getLast().equals("NEWLAST"));
	}
	
	@Test
	public void testEditProfilePassword() {
		UFC.editProfile("NEWFIRST","NEWLAST","NEWUSERTESTPASSWORD");
		assertTrue("New  should be ", testUser.getPassword().equals("NEWUSERTESTPASSWORD"));
	}
	
	@After
	public void deleteTestUser() {
		DBC.deleteAccount(testUser);
		LogOn.setCurrentAccount(null);
	}
}
