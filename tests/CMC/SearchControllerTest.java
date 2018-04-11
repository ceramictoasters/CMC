package CMC;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import CMC.DBController;
import CMC.School;
import CMC.SearchControllerV2;

/**
 * @author mjpeck & tswilson
 *
 */
public class SearchControllerTest {

	SearchControllerV2 sc;
	ArrayList<String> emphasis;
	DBController dataBase;
	School yale, butler;
//	Recommendation r = new Recommendation();
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	
		sc = new SearchControllerV2();
		dataBase = new DBController();
		yale = dataBase.getSchool("YALE");
		butler = dataBase.getSchool("BUTLER");
		emphasis = new ArrayList<String>();
		emphasis.add("COMSCI");
		emphasis.add("SCIENCE");
		
	}

	/**
	 * Test method for {@link CMC.SearchControllerV2#search(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, double, double, int, int, int, int, int, int, double, double, int, int, double, double, double, double, int, int, int, int, int, int, java.util.ArrayList)}.
	 */
	@Test
	public void testSearchEmpty() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Searched criteria are empty, All schools returned", searchedSchools.equals(dataBase.getAllSchools()));
	}
	
	/**
	 * Test method for {@link CMC.SearchControllerV2#search(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, double, double, int, int, int, int, int, int, double, double, int, int, double, double, double, double, int, int, int, int, int, int, java.util.ArrayList)}.
	 */
	@Test
	public void testSearchValid() {
		ArrayList<School> searchedSchools = sc.search("COLLEGE", "MN", "SUBURBAN", "STATE", 20000, 41000, 40, 65, 400, 800, 400, 800, 1100, 20000, 40, 90, 1000, 7000, 60, 100,60, 100, 1, 60, 1, 5, 1, 5,emphasis);
		assertTrue("Valid Searched Criteria, Schools Array is not Empty" + searchedSchools.size(), !searchedSchools.equals(null));
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
		sc.getRecommendations(null);
	}

	/**
	 * Test method for {@link CMC.SearchControllerV2#getRecommendations(CMC.School)}.
	 */
	@Test
	public void testGetRecommendations() {
		School yale = dataBase.getSchool("YALE");
		ArrayList<School> recommended = sc.getRecommendations(yale);
		assertTrue("Recommendations given for Yale", !recommended.equals(null));
	}
	
	@Test
	public void testSearchName() {
		ArrayList<School> searchedSchools = sc.search("YALE", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
		assertTrue("Butler is not in the collection", !searchedSchools.contains(butler));
	}
	
	@Test
	public void testSearchState() {
		ArrayList<School> searchedSchools = sc.search("", "CONNECTICUT", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
		assertTrue("Butler is not in the collection", !searchedSchools.contains(butler));
	}
	
	@Test
	public void testSearchLocation() {
		ArrayList<School> searchedSchools = sc.search("", "", "SMALL-CITY", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
		assertTrue("Butler is not in the collection", !searchedSchools.contains(butler));
	}
	
	@Test
	public void testSearchControl() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "PRIVATE", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearchNumberOfStudentsLow() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", 9999, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearchNumberOfStudentsHigh() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, 10001, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearchPercentFemaleLow() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, 44.0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearchPercentFemaleHigh() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, 46.0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		//System.out.println(searchedSchools.toString());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearchSATVerbalLow() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, 674, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));	
	}
	
	@Test
	public void testSearchSATVerbalHigh() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, 676, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));	
	}
	
	@Test
	public void testSearchSATMathLow() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, 674, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearchSATMathHigh() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, 676, -1, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearchExpenseLow() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, 33010, -1, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearchExpenseHigh() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, 33020, -1, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearchPercentFinancialAidLow() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39.0, -1, -1, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearchNumApplcantsLow() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 11499, -1, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearchNumApplcantsHigh() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 11501, -1, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearchPercentAdmittedLow() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19.0, -1,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearchPercentAdmittedHigh() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21.0,-1, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearchPercentEnrolledLow() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 59.0, -1, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSeacrhPercentEnrolledHigh() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,-1, 61.0, -1, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearcAcademicScaleLow() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	
	@Test
	public void testSearcAcademicScaleHigh() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	
	@Test
	public void testSearcSocialScaleLow() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, -1, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearcSocialScaleHigh() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearcQualityLifeScaleLow() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 3, -1,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}
	
	@Test
	public void testSearcQualityLifeScaleHigh() {
		ArrayList<School> searchedSchools = sc.search("", "", "", "", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5,new ArrayList<String>());
		assertTrue("Yale is in the returned collection", searchedSchools.contains(yale));
	}

}