import java.util.ArrayList;

import CMC.*;

public class databaseDriver {

	public static void main(String[] args) {
		DBController DBTest = new DBController();
		AdminFunctionalityController AFCTest = new AdminFunctionalityController();
		AdminInteractions UITest = new AdminInteractions();
		LogOn myLog = new LogOn();
		
		User testUser = DBTest.getUser("userName");
		testUser.saveSchool(DBTest.getSchool("YALE"));
		for(User myUser : DBTest.getAllUsers()) {
			System.out.println(myUser);
		}
	}
}
