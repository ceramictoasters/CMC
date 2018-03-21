import java.util.ArrayList;

import CMC.*;

public class databaseDriver {

	public static void main(String[] args) {
		DBController DBTest = new DBController();
		//		ArrayList<Account> accountArray = DBTest.getAccounts();
//		DBTest.addAccount(new User("username", "password", "Name", "Last", 'u', 'Y', null));
//		System.out.println(DBTest.getAccount("username"));
		
		LogOn myWayIn = new LogOn();
		myWayIn.run("John", "User");
		System.out.println(myWayIn.getCurrentAccount());
		//		UserFunctionalityController myUFC = new UserFunctionalityController();
//		UserInteractions myUI = new UserInteractions();
//				
//		myUI.displayProfile();
}
}
