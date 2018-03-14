import CMC.School;
import CMC.SearchController;

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

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//TODO: log in as admin and as user
		
		
		System.out.println("--Search Controller--");
		SearchController sc = new SearchController();
		School[] searchedSchools = sc.search("", "MN", "", "", 100, 10000, 10, 90, 0, 800, 0, 800, 1000, 100000, 0.1, 0.9, 10, 500, 0.1, 0.9, 0.1, 0.9, -1, -1, -1, -1, -1, -1);
		School[] recommended = new School[5];  
		recommended = sc.getRecommendations(searchedSchools[0]); //May not work if no school is found with search (i.e. if there aren't any schools in MN)
	}

}
