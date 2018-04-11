/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import CMC.DBController;
import CMC.Recommendation;
import CMC.School;
import CMC.SearchControllerV2;

/**
 * @author mjpeck
 *
 */
public class SearchControllerTest {

	SearchControllerV2 sc;
	ArrayList<String> emphasis;
	DBController dataBase;
	Recommendation r = new Recommendation();
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	
		sc = new SearchControllerV2();
		dataBase = new DBController();
		emphasis = new ArrayList<String>();
		emphasis.add("COMSCI");
		emphasis.add("SCIENCE");
		
	}

	/**
	 * Test method for {@link CMC.SearchControllerV2#search(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, double, double, int, int, int, int, int, int, double, double, int, int, double, double, double, double, int, int, int, int, int, int, java.util.ArrayList)}.
	 */
	@Test
	public void testSearchEmpty() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, 1, -1, 1, -1, -1, -1,null);
		//System.out.println(searchedSchools.toString());
		assertTrue("Searched criteria are empty, All schools returned", searchedSchools.equals(dataBase.getAllSchools()));
	}
	
	/**
	 * Test method for {@link CMC.SearchControllerV2#search(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, double, double, int, int, int, int, int, int, double, double, int, int, double, double, double, double, int, int, int, int, int, int, java.util.ArrayList)}.
	 */
	@Test
	public void testSearchValid() {
		ArrayList<School> searchedSchools = sc.search("COLLEGE", "MN", "SUBURBAN", "STATE", 20000, 41000, 40, 65, 400, 800, 400, 800, 1100, 20000, 40, 90, 1000, 7000, 60, 100,60, 100, 1, 60, 1, 5, 1, 5,emphasis);
		assertTrue("Valid Searched Criteria, Schools Array is not Empty", !searchedSchools.equals(null));
	}
	
	/**
	 * Test method for {@link CMC.SearchControllerV2#search(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, double, double, int, int, int, int, int, int, double, double, int, int, double, double, double, double, int, int, int, int, int, int, java.util.ArrayList)}.
	 */
//	@Test
//	public void testSearchInvalid() {
//		ArrayList<School> searchedSchools = sc.search("NAME", "STATE", "PLACE", "OWNER", -2, -2, -2, 120, 399, 801, 399, 801, -2, -2, -2, 120, -2, -2, -2, 120,-2, 120, -2, 120, -2, 6, -2, 6,emphasis);
//		
//	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRecommendationFailsForNullSchool() {
		r.getRecommendations(null);
	}

	/**
	 * Test method for {@link CMC.SearchControllerV2#getRecommendations(CMC.School)}.
	 */
	@Test
	public void testGetRecommendations() {
		School yale = dataBase.getSchool("YALE");
		ArrayList<School> recommended = sc.getRecommendations(yale);
		//System.out.println(recommended.toString());
		assertTrue("Recommendations given for Yale", !recommended.equals(null));
	}

}
