import java.util.ArrayList;

import CMC.*;
import dblibrary.project.csci230.UniversityDBLibrary;

public class databaseDriver {

	public static void main(String[] args) {
		DBController DBTest = new DBController();
			
		User testUser = new User("wilmotUserName", "wilmotPassword", "Wilmot", "Osei-Bonsu", 'u', 'Y', new ArrayList<School>());
		
		//System.out.println("1  \n" + DBTest.getUser("juser"));

		System.out.println("2  \n" + DBTest.viewSavedSchool(DBTest.getUser("juser")));

	}		

		
		


		
	//}
}
