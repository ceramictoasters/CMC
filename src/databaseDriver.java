import java.util.ArrayList;

import CMC.*;

public class databaseDriver {

	public static void main(String[] args) {
		DBController DBTest = new DBController();
		AdminFunctionalityController AFCTest = new AdminFunctionalityController();
		AdminInteractions UITest = new AdminInteractions();
		LogOn myLog = new LogOn();
		
		ArrayList<String> areaOfStudy = new ArrayList<String>();
		areaOfStudy.add("THIS IS A TEST");
		areaOfStudy.add("Wilmot");
		areaOfStudy.add("osei");
		School testSchool = DBTest.getSchool("deletable School");
//		boolean added  = DBTest.addNewSchool(testSchool);

		//System.out.println(DBTest.getSchool("deletable School"));
		
		//System.out.println(DBTest.getAllSchools());

		
//		//boolean added  = DBTest.addNewSchool(testSchool);
//		//System.out.println("School Added " + added);
//		//System.out.println("School Added " + added);
//		
//		System.out.println(DBTest.getSchool(testSchool.getName()));
		boolean removed  = DBTest.deleteSchool(testSchool);
//		System.out.println("School Removed " + removed);
//		System.out.println("HERE" + DBTest.getSchool(testSchool.getName()) + "end here");
		//System.out.println(DBTest.getAllSchools());

		System.out.println("database Contains " + DBTest.databaseContainsSchool(DBTest.getSchool("deletable School")));

		
	}
}
