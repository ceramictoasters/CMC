//import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

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

	/*A simple driver class which demos each of the functionalities in CMC (from your updated use case diagram)
	 * Must include an instance of each of your interaction classes
	 * Must use your interaction classes to demo each functionality by showing sample input and output
	 * Must show that all scenarios for all use cases (i.e. functionalities) work for some sample input
	 * Does not have to be interactive
	 *  Output should be clear and easy for me to read and match to the required functionalities in CMC
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
