//<<<<<<< HEAD:src/SearchController.java

/* --Header--
 * Group - Ceramic Toasters
=======
package CMC;
/* Header
 * 
 * By Mitch Peck
 * 
 * Ceramic Toasters
>>>>>>> 92ab790103aafcbf06961d563e8b242022a17659:src/CMC/SearchController.java
 * 
 * Name - Search Controller
 * Description -
 *	-Searches for school based on input data
 *	-Recommends 5 schoolsArraybased on specified school
 */

/**
 *@author Mitch Peck
 *@version 2.28.18 
 */

package CMC;

import java.util.*;

public class SearchControllerV2 {
	/**
	 * Pre: Post:
	 * 
	 * @param schoolName
	 * @param state
	 * @param locatio
	 * @param control
	 * @param numberOfStudentsL
	 * @param numberOfStudentsH
	 * @param femaleL
	 * @param femaleH
	 * @param VerbalSATL
	 * @param VerbalSATH
	 * @param MathSATL
	 * @param MathSATH
	 * @param expensesL
	 * @param expensesH
	 * @param aidL
	 * @param aidH
	 * @param applicantsL
	 * @param applicantsH
	 * @param perAdmittedL
	 * @param perAdmittedH
	 * @param perEnrolledL
	 * @param perEnrolledH
	 * @param academicScaleL
	 * @param academicScaleH
	 * @param socialScaleL
	 * @param socialScaleH
	 * @param qualityScaleL
	 * @param qualityScaleH
	 * @param emphasis
	 * @return School[] - array of schoolsArraythat was searched for
	 */

	public ArrayList<School> search(String schoolName, String state, String location, String control,
			int numberOfStudentsL, int numberOfStudentsH, double femaleL, double femaleH, int verbalSATL,
			int verbalSATH, int mathSATL, int mathSATH, int expensesL, int expensesH, double aidL, double aidH,
			int applicantsL, int applicantsH, double perAdmittedL, double perAdmittedH, double perEnrolledL,
			double perEnrolledH, int academicScaleL, int academicScaleH, int socialScaleL, int socialScaleH,
			int qualityScaleL, int qualityScaleH, ArrayList<String> emphasis)

	{

		// if(numberOfStudentsL<-1 || femaleL<-1 || femaleH>100 || (verbalSATL<400 &&
		// verbalSATL!=-1) ||verbalSATH>800 ||(mathSATL<400 && mathSATL!=-1) ||
		// mathSATH>800 || expensesL<-1
		// || aidL <-1 || aidH> 100 ||applicantsL<-1 || perAdmittedL<-1 ||
		// perAdmittedH>100 || perEnrolledL <-1 || perEnrolledH>100 || academicScaleL<-1
		// || academicScaleH>5 || socialScaleL<-1 || socialScaleH>5 || qualityScaleL<-1
		// || qualityScaleH >5) {
		//
		// System.out.println("Illegal Argument Exception");
		// return null;
		// }

		ArrayList<School> tempSchools = new ArrayList<School>(); // Temp dynamic array to hold schoolsArraythat have a
																	// give value
		ArrayList<School> schoolsArray = new ArrayList<School>();
		DBController dataBase = new DBController();
		schoolsArray = dataBase.getAllSchools(); // Array of all schoolsArrayto look through
		// Check if a school name is given
		if (!schoolName.equals("")) {
			// Loop through schools
			for (School s : schoolsArray) {
				// Check if the school matches the name or name fragment
				if (s.getName().contains(schoolName)) {
					// Add to temp array
					tempSchools.add(s);
				}
			}
			// Override the schoolsArrayarray to only contain schoolsArraywith the specified
			// name or name fragment
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// state
		if (!state.equals("")) {
			for (School s : schoolsArray) {
				if (s.getState().contains(state)) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
			;
		}

		// for(School s:schools)
		// System.out.println(s.toString());
		// Location
		if (!location.equals("")) {
			for (School s : schoolsArray) {
				if (s.getLocation().contains(location)) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// Control
		if (!control.equals("")) {
			for (School s : schoolsArray) {
				if (s.getControl().contains(control)) {
					tempSchools.add(s);

				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
			System.out.println("Size" + schoolsArray.size());
		}
		// System.out.println(schoolsArray.toString());
		// numberOfStudentsL
		if (!(numberOfStudentsL == -1)) {
			for (School s : schoolsArray) {
				if (s.getNumStudents() > numberOfStudentsL) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// System.out.println(schoolsArray.toString());
		// numberOfStudentsH
		if (!(numberOfStudentsH == -1)) {
			for (School s : schoolsArray) {
				if (s.getNumStudents() < numberOfStudentsH) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// System.out.println(schoolsArray.toString());
		// femaleL
		if (!(femaleL == -1)) {
			for (School s : schoolsArray) {
				if (s.getPercentFemale() > femaleL) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// femaleH
		if (!(femaleH == -1)) {
			for (School s : schoolsArray) {
				if (s.getPercentFemale() < femaleH) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
			;
		}
		// verbalSATL
		if (!(verbalSATL == -1)) {
			for (School s : schoolsArray) {
				if (s.getVerbalSAT() > verbalSATL) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// verbalSATH
		if (!(verbalSATH == -1)) {
			for (School s : schoolsArray) {
				if (s.getVerbalSAT() < verbalSATH) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// mathSATL
		if (!(mathSATL == -1)) {
			for (School s : schoolsArray) {
				if (s.getMathSAT() > mathSATL) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// mathSATH
		if (!(mathSATH == -1)) {
			for (School s : schoolsArray) {
				if (s.getMathSAT() < mathSATH) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// expensesL
		if (!(expensesL == -1)) {
			for (School s : schoolsArray) {
				if (s.getExpense() > expensesL) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// expensesH
		if (!(expensesH == -1)) {
			for (School s : schoolsArray) {
				if (s.getExpense() < expensesH) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// aidL

		if (aidL >= 0) {
			for (School s : schoolsArray) {

				if (s.getPercentFinAid() > aidL) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// aidH
		if (!(aidH == -1)) {
			for (School s : schoolsArray) {
				if (s.getPercentFinAid() < aidH) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// applicantsL
		if (!(applicantsL == -1)) {
			for (School s : schoolsArray) {
				if (s.getNumApplicants() > applicantsL) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// applicantH
		if (!(aidH == -1)) {
			for (School s : schoolsArray) {
				if (s.getNumApplicants() < applicantsH) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// perAdmittedL
		if (!(perAdmittedL == -1)) {
			for (School s : schoolsArray) {
				if (s.getPercentAdmit() > perAdmittedL) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
			;
		}
		// perAdmittedH
		if (!(perAdmittedH == -1)) {
			for (School s : schoolsArray) {
				if (s.getPercentAdmit() < perAdmittedH) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// perEnrolledL
		if (!(perEnrolledL == -1)) {
			for (School s : schoolsArray) {
				if (s.getPercentEnroll() > perEnrolledL) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// perEnrolledH
		if (!(perEnrolledH == -1)) {
			for (School s : schoolsArray) {
				if (s.getPercentEnroll() < perEnrolledH) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// academicScaleL
		if (!(academicScaleL == -1)) {
			for (School s : schoolsArray) {
				if (s.getAcademicScale() >= academicScaleL) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// academicScaleH
		if (!(academicScaleH == -1)) {
			for (School s : schoolsArray) {
				if (s.getAcademicScale() <= academicScaleH) {
					tempSchools.add(s);

				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// socialScaleL
		if (!(socialScaleL == -1)) {
			for (School s : schoolsArray) {
				if (s.getSocialScale() >= socialScaleL) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// socialScaleH
		if (!(socialScaleH == -1)) {
			for (School s : schoolsArray) {
				if (s.getSocialScale() <= socialScaleH) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// qualityScaleL
		if (!(qualityScaleL == -1)) {
			for (School s : schoolsArray) {
				if (s.getQualityLifeScale() >= qualityScaleL) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		// qualityScaleH
		if (!(qualityScaleH == -1)) {
			for (School s : schoolsArray) {
				if (s.getQualityLifeScale() <= qualityScaleH) {
					tempSchools.add(s);
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}

		// Emphasis
		if (!emphasis.equals(null)) {

			for (School s : schoolsArray) {
				for (String e : emphasis) {
					if (!s.getAreasOfStudy().equals(null)) {
						for (String emph : s.getAreasOfStudy()) {
							if (emph.equals(e)) {
								tempSchools.add(s);
							}
						}
					}
				}
			}
			if (tempSchools.isEmpty())
				return tempSchools;
			schoolsArray = (ArrayList<School>) tempSchools.clone();
			tempSchools.clear();
		}
		return schoolsArray;
	}

	/**
	 * Returns array of schoolsArrayas recommendations based on an input school
	 *
	 * @param School
	 *            - school that recommendations are based off of
	 * @return School[] - array of schoolsArrayas recommendations
	 */

	public ArrayList<School> getRecommendations(School s) {
		DBController dataBase = new DBController();
		if (s == null) {
			throw new IllegalArgumentException("School passed is null");
		} else if (!dataBase.getAllSchools().contains(s)) {
			throw new IllegalArgumentException("School not in database");
		} else {

			ArrayList<School> schoolsArray = new ArrayList<School>();
			schoolsArray = dataBase.getAllSchools();
			// Initialize max/min values with first schoolsArraynumbers
			int minNumStudents = schoolsArray.get(0).getNumStudents();
			int maxNumStudents = 0;
			double minPercentFemale = 100.0;
			double maxPercentFemale = 0.0;
			int maxVerbalSAT = 0;
			int minVerbalSat = 800;
			int maxMathSAT = 0;
			int minMathSat = 800;
			double maxExpenses = 0;
			double minExpenses = schoolsArray.get(0).getExpense();
			double maxPercentFinAid = 0.0;
			double minPercentFinAid = 100.0;
			int maxNumApplicants = 0;
			int minNumApplicants = schoolsArray.get(0).getNumApplicants();
			double maxPercentAdmit = 0;
			double minPercentAdmit = 100.0;
			double maxPercentEnroll = 0;
			double minPercentEnroll = 100.0;
			int maxAcademic = 0;
			int minAcademic = 6;
			int maxSocial = 0;
			int minSocial = 6;
			int maxQuality = 0;
			int minQuality = 6;

			// Loop through all schoolsArrayto find min and max values
			for (School sch : schoolsArray) {
				// Number Students
				int numStuds = sch.getNumStudents();
				if (numStuds < minNumStudents && numStuds >= 0)
					minNumStudents = sch.getNumStudents(); // Save min value
				// System.out.println(sch.toString());
				else if (numStuds > maxNumStudents)
					maxNumStudents = sch.getNumStudents(); // Save max value
				// Percent Female
				double perFemale = sch.getPercentFemale();
				if (perFemale < minPercentFemale && perFemale >= 0)
					minPercentFemale = sch.getPercentFemale();
				else if (perFemale > maxPercentFemale && perFemale <= 100.0)
					maxPercentFemale = sch.getPercentFemale();
				// Verbal SAT
				int vSAT = sch.getVerbalSAT();
				if (vSAT < minVerbalSat && vSAT >= 400)
					minVerbalSat = vSAT;
				else if (vSAT > maxVerbalSAT && vSAT <= 800)
					maxVerbalSAT = vSAT;
				// Math SAT
				int mSAT = sch.getMathSAT();
				if (mSAT < minMathSat && mSAT >= 400)
					minMathSat = mSAT;
				else if (mSAT > maxMathSAT && mSAT <= 800)
					maxMathSAT = mSAT;
				// Expenses
				double expense = sch.getExpense();
				if (expense < minExpenses && expense >= 0)
					minExpenses = expense;
				else if (expense > maxExpenses)
					maxExpenses = expense;
				// percentFinAid
				double percentFin = sch.getPercentFinAid();
				if (percentFin < minPercentFinAid && percentFin >= 0)
					minPercentFinAid = percentFin;
				else if (percentFin > maxPercentFinAid && percentFin <= 100)
					maxPercentFinAid = percentFin;
				// numApplicants
				int numApp = sch.getNumApplicants();
				if (numApp < minNumApplicants && numApp >= 0)
					minNumApplicants = numApp;
				else if (numApp > maxNumApplicants)
					maxNumApplicants = numApp;
				// percentAdmitted
				double admit = sch.getPercentAdmit();
				if (admit < minPercentAdmit && admit >= 0)
					minPercentAdmit = admit;
				else if (admit > maxPercentAdmit && admit <= 100.0)
					maxPercentAdmit = admit;
				// percentEnroll
				double enroll = sch.getPercentEnroll();
				if (enroll < minPercentEnroll && enroll >= 0)
					minPercentEnroll = enroll;
				else if (enroll > maxPercentEnroll && enroll <= 100)
					maxPercentEnroll = enroll;
				// academicScale
				int academic = sch.getAcademicScale();
				if (academic < minAcademic && academic > 0)
					minAcademic = academic;
				else if (academic > maxAcademic && academic < 6)
					maxAcademic = academic;
				// socailScale
				int social = sch.getSocialScale();
				if (social < minSocial && social > 0)
					minSocial = social;
				else if (social > maxSocial && social < 6)
					maxSocial = social;
				// qualityScale
				int quality = sch.getQualityLifeScale();
				// System.out.println(quality + " " +sch.toString());
				if (quality < minQuality && quality > 0)
					minQuality = quality;
				else if (quality > maxQuality && quality < 6)
					maxQuality = quality;

			}

			// Array to hold top 5 recommended schools
			ArrayList<School> recommended = new ArrayList<School>();
			// Array to hold top 5 distances that correlate to the top 5 schools
			ArrayList<Double> distance = new ArrayList<Double>();
			// See CMC_RankOrderingMatchingSchools_SPring2018.pdf
			// Distance Equation: ∑ |V1.Xi−V2.Xi|/|max(Xi)−min⁡(Xi)|

			String sName = s.getName();
			String sState = s.getState();
			String sLocation = s.getLocation();
			String sControl = s.getControl();
			for (int n = 0; n < schoolsArray.size(); n++) {
				double dist = 0;
				if (!sName.equals(schoolsArray.get(n).getName())) {
					if (!sState.equals(schoolsArray.get(n).getState()))
						dist++;
					if (!sLocation.equals(schoolsArray.get(n).getLocation()))
						dist++;
					if (!sControl.equals(schoolsArray.get(n).getControl()))
						dist++;
					// System.out.println("After State, Control, Location: " + dist);
					double emphDist = 0;
					if (!s.getAreasOfStudy().isEmpty()) {
						for (String emph : s.getAreasOfStudy()) {
							if (!schoolsArray.get(n).getAreasOfStudy().contains(emph)) {
								emphDist++;
							}
						}
						dist = dist + Math.abs((emphDist / s.getAreasOfStudy().size()));
					}

					dist += distanceMeasure((double) s.getNumStudents(), (double) schoolsArray.get(n).getNumStudents(),
							(double) maxNumStudents, (double) minNumStudents);
					dist += distanceMeasure(s.getPercentFemale(), schoolsArray.get(n).getPercentFemale(),
							maxPercentFemale, minPercentFemale);
					dist += distanceMeasure((double) s.getVerbalSAT(), (double) schoolsArray.get(n).getVerbalSAT(),
							(double) maxVerbalSAT, (double) minVerbalSat);
					dist += distanceMeasure((double) s.getMathSAT(), (double) schoolsArray.get(n).getMathSAT(),
							(double) maxMathSAT, (double) minMathSat);
					dist += distanceMeasure(s.getExpense(), schoolsArray.get(n).getExpense(), maxExpenses, minExpenses);
					dist += distanceMeasure(s.getPercentFinAid(), schoolsArray.get(n).getPercentFinAid(),
							maxPercentFinAid, minPercentFinAid);
					dist += distanceMeasure((double) s.getNumApplicants(),
							(double) schoolsArray.get(n).getNumApplicants(), (double) maxNumApplicants,
							(double) minNumApplicants);
					dist += distanceMeasure(s.getPercentAdmit(), schoolsArray.get(n).getPercentAdmit(), maxPercentAdmit,
							minPercentAdmit);
					dist += distanceMeasure(s.getPercentEnroll(), schoolsArray.get(n).getPercentEnroll(),
							maxPercentEnroll, minPercentEnroll);
					dist += distanceMeasure((double) s.getAcademicScale(),
							(double) schoolsArray.get(n).getAcademicScale(), (double) maxAcademic,
							(double) minAcademic);
					dist += distanceMeasure((double) s.getSocialScale(), (double) schoolsArray.get(n).getSocialScale(),
							(double) maxSocial, (double) minSocial);
					dist += distanceMeasure((double) s.getQualityLifeScale(),
							(double) schoolsArray.get(n).getQualityLifeScale(), (double) maxQuality,
							(double) minQuality);

					if (n < 5) {
						distance.add(dist);
						recommended.add(schoolsArray.get(n));
					} else {
						double max = Collections.max(distance);
						if (dist < max) {
							int index = distance.indexOf(max);
							distance.set(index, dist);
							recommended.set(index, schoolsArray.get(n));
						}
					}
				}
				//System.out.println(dist + "   " + schoolsArray.get(n).getName());
			}
			return recommended;
		}
	}

	public double distanceMeasure(double recSchool, double compareSchool, double max, double min) {
		double partialDist = 0.0;
		if (recSchool == -1)
			return 0.0;
		else if (compareSchool == -1)
			partialDist = Math.abs((double) recSchool - max) / Math.abs(max - min);
		else {
			partialDist = Math.abs((double) recSchool - compareSchool) / Math.abs(max - min);
		}
		return partialDist;
	}

}
