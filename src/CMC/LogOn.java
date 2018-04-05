package CMC;

/**
 * Initial class that has the user log in with valid credentials After logging
 * is the user will be sent to their respective menu
 * 
 * @author Colin Tate
 * @version 2/28/18
 */
public class LogOn {

	private static boolean isLoggedOn = false;
	// Current account variable
	private static Account currentAccount = null;

	/**
	 * Static method that gets the current account
	 * 
	 * @return the current account object
	 */
	public static Account getCurrentAccount() {
		return currentAccount;
	}
	
	public static void setCurrentAccount(Account a) {
		currentAccount = a;
	}
	
	public static boolean getIsLoggedOn() {
		return isLoggedOn;
	}

	/**
	 * Static Run method that attempts to log in the user and
	 * open their account's respective menu
	 * 
	 * @param username user name credential
	 * @param password password credentials
	 */
	public static void run(String username, String password) {
		
		
		DBController dbHome = new DBController();
		if (dbHome.credentialValidation(username, password)) {
			Account attempedUser = dbHome.getAccount(username);
			if (attempedUser.getStatus() == 'N') {
				System.out.println("<>==E R R O R==<>\nAccount is deactivated, please contact support.\nCALL 1-800-411-PAIN FOR ASSISTANCE");
			}
			else {
				currentAccount = attempedUser;
				isLoggedOn = true;
			}
		}
		else {
			System.out.println("Error: Invalid username or password.");
			return;
			//System.exit(0);
		}

		if (currentAccount.getType() == 'a')
			AdminInteractions.adminMenu(currentAccount);

	}

	public String isLoggedOn() {
		if(isLoggedOn) {
			return "true";
		}
		else {
			return "false";
		}
	}
	
}
