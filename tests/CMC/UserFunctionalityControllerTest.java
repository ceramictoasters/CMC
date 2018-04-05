/**
 * 
 */
package CMC;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ctate001
 */
public class UserFunctionalityControllerTest {
	private UserFunctionalityController UFC;
	private User testUser;
	
	//BEFORE
	@Before
	public void setUp() throws Exception {
		new DBController();
		testUser = new User("USERTEST", "USERTESTPASSWORD", "FIRST", "LAST", 'u', 'Y', new ArrayList<School>());
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
		assertTrue("Search results should be valid", UFC.viewSearchResults().size()>0);
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
		assertTrue("Save school should be false", UFC.saveSchool("InvalidSchoolName"));
	}
	
	@Test
	public void testSaveSchoolValid() {
		assertTrue("Save school should be true", UFC.saveSchool("YALE"));
	}
	
	@Test
	public void testSaveSchoolAlreadySaved() {
		assertTrue("Save school should be false", UFC.saveSchool("YALE"));
	}
	
	//VIEW SAVED SCHOOLS
	@Test
	public void testViewSavedSchoolsInvalid() {
		assertTrue("Saved schools should be null", UFC.viewSavedSchools(null)==null);
	}
	
	@Test
	public void testViewSavedSchoolsValid() {
		assertTrue("Saved schools should be valid", UFC.viewSavedSchools(testUser)!=null);
	}
	
	//REMOVE SCHOOL
	@Test
	public void testRemoveSchoolValid() {
		UFC.removeSchool(testUser, "YALE");
		assertTrue("Saved list should be empty", UFC.viewSavedSchools(testUser).size()==0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRemoveSchoolInvalid() {
		UFC.removeSchool(testUser, "YALE");
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
}
