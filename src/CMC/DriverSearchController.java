/**
 * Driver to test Search Controller
 */
package CMC;

import java.util.ArrayList;

/**
 * @author mjpeck
 *
 */
public class DriverSearchController {

	/**
	 * 
	 */
	public DriverSearchController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("In main 1");
		SearchControllerV2 sc = new SearchControllerV2();
		System.out.println("Before search");
		//public ArrayList<School> search(String schoolName, String state, String location, String control, int numberOfStudentsL, int numberOfStudentsH, double femaleL,
  			//	double femaleH, int verbalSATL, int verbalSATH, int mathSATL, int mathSATH, int expensesL, int expensesH, double aidL, 
  				//double aidH, int applicantsL, int applicantsH, double perAdmittedL, double perAdmittedH, double perEnrolledL, double perEnrolledH, 
  				//int academicScaleL, int academicScaleH, int socialScaleL, int socialScaleH, int qualityScaleL, int qualityScaleH  
		ArrayList<String>emphasis = new ArrayList<String>();
		emphasis.add("Something");
		emphasis.add("Something");
		ArrayList<School> searchedSchools = sc.search("", "", "", "", 20000, 41000, 40, 65, 400, 800, 400, 800, 1100, 20000, 40, 90, 1000, 7000, -1, -1,60, 100, 1, 60, 1, 5, 1, 5,emphasis);
		System.out.println("Made it past search" + searchedSchools.toString());
		
		//ArrayList<School> recommended = new ArrayList<School>();
		if(!searchedSchools.isEmpty()){
				ArrayList<School> recommended = sc.getRecommendations(searchedSchools.get(0));
				System.out.println("Recommended   " + recommended.toString());
		}
	}
	
}
