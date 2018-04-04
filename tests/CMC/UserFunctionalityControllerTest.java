/**
 * 
 */
package CMC;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author ctate001
 */
public class UserFunctionalityControllerTest {
	private UserFunctionalityController UFC;
	private DBController dbController;
	private User user;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		user = new User("USERTEST", "USERTESTPASSWORD", "FIRST", "LAST", 'u', 'Y', new ArrayList<School>());
		Logon.setCurrentAccount((Account)user);
		UFC = new UserFunctionalityController();
		dbController = new DBController();
	}
	
	@Test
	
	
	@After
	
	
}
