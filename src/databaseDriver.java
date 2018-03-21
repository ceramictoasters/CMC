import java.util.ArrayList;

import CMC.*;

public class databaseDriver {

	public static void main(String[] args) {
		DBController DBTest = new DBController();
		AdminFunctionalityController AFCTest = new AdminFunctionalityController();
		
		/**
		 * Removes a school
		 */
		School yale = DBTest.getSchool("YALE");
		System.out.println(yale.getAreasOfStudy());

}
}
