import java.util.ArrayList;

import CMC.*;

public class databaseDriver {

	public static void main(String[] args) {
		DBController DBTest = new DBController();
		AdminFunctionalityController AFCTest = new AdminFunctionalityController();
		AdminInteractions UITest = new AdminInteractions();
		LogOn myLog = new LogOn();
		
		Account myAccount= DBTest.getAccount("John");
//		myUser = AFCTest.toggleActivation(myUser);
//		System.out.println(myUser);
//		
//		myUser= DBTest.getAccount("John").toUser();
//		System.out.println(myUser);
//
//		myLog.run(myUser.getUsername(), myUser.getPassword());
		System.out.println(myAccount+"\n");

		boolean changed = DBTest.editAccount(	myAccount.getUsername(), 
												myAccount.getPassword(), 
												"John",
												myAccount.getLast(),
												'a',
												'N');
		
		System.out.println(changed);
		myAccount= DBTest.getAccount(myAccount.getUsername());

		System.out.println(myAccount);
		myLog.run(myAccount.getUsername(), myAccount.getPassword());
	

}
}
