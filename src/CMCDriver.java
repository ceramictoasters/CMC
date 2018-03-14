import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import CMC.LogOn;
import CMC.School;
import CMC.SearchController;
import java.util.Scanner;

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
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Username:");
		String username = scan.next();
		System.out.println("\nEnter Password: ");
		String password = scan.next();
		LogOn.run(username, password);
		
		
	}

}
