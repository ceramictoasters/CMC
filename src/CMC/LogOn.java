package CMC;
/**
 * Initial class that has the user log in with valid credentials
 * After logging is the user will be sent to their respective menu
 * 
 * @author Colin Tate
 * @version 2/28/18
 */
public class LogOn {

	// User credential input variables
	String userName;
	String password;
	Account currentAccount;
	
	/**
	 * Main constructor that takes the user's credentials then tries to log in
	 * Error messages will appear is account credentials are invalid or account is deactivated
	 * If type account is valid the session will be created and set the users accountas to current
	 * 
	 * @param n user name credential
	 * @param p password credential
	 */
	public LogOn(Account a) {
		currentAccount = a;
	}
	
	/**
	 * Method that gets the current account
	 */
	public Account getCurrentAccount() {
		return currentAccount;
	}
	
	public static void run() {
		if(getCurrentAccount().getType().equals('a'))
			AdminInteractions.adminMenu();
		else
			UserInteractions.userMenu(getCurrentAccount());
	}

	public static void main(String[] args) {
		// User enters username
		String name = "Bob";
		// User enters password
		String pass = "1234";
		
		// If creds are invalid
		if(!credentialValidation(name,pass)) {
			System.out.println("Error:\nUsername: "+name+"\nPassword: "+pass+"\nInvalid username or password.");
			System.exit(0);
		}
		
		Account curAcc = getAccount(name);
		
		// If account status is deacivated
		if(curAcc.getStatus().equals('N')) {
			System.out.println("Error:\nAccount: "+ name + "\nStatus: Deactivated\nAccount is deactivated, please contact support.");
		}
		
		// Stars the session
		LogOn session = new LogOn(curAcc);
		session.run();
	}
}
