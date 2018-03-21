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
 *	-Recommends 5 schools based on specified school
 */

/**
 *@author Mitch Peck
 *@version 2.28.18 
 */

package CMC;
import java.util.*;


public class SearchController{
  
  /**
   * The name of the school
   */
  private String schoolName;
  /**
   * the state that the school is in
   */
  private String state;
  /**
   * the type of location
   */
  private String location;
  /**
   * private or public
   */
  private String control;
  /**
   * the low range for the number of students at a school
   */
  private int numberOfStudentsLow;
  /**
   * the high range for the number of students at a school
   */
  private int numberOfStudentsHigh;
  /**
   * the low range for the percentage of female students
   */
  private int femaleLow;
  /**
   * the high range for the percentage of female students
   */
  private int femaleHigh;
  /**
   * the low end of the verbal SAT
   */
  private int verbalSATLow;
  /**
   * the high end of the verbal SAT
   */
  private int verbalSATHigh;
  /**
   * the low end of the math SAT
   */
  private int mathSATLow;
  /**
   * the high end of the math SAT
   */
  private int mathSATHigh;
  /**
   * the low end of the expense
   */
  private int expensesLow;
  /**
   * the high end of the expense
   */
  private int expensesHigh;
  /**
   * the low end of the financial aid
   */
  private int aidLow;
  /**
   * the high end of the financial aid
   */
  private int aidHigh;
  /**
   * the low end for the number of applicants
   */
  private int applicantsLow;
  /**
   * the high end for the number of applicants
   */
  private int applicantsHigh;
  /**
   * the low end for the percent of students admitted
   */
  private int percentAdmittedLow;
  /**
   * the high end for the percent of students admitted
   */
  private int percentAdmittedHigh;
  /**
   * the low end of the percent of students enrolled
   */
  private int percentEnrolledLow;
  /**
   * the high end of the percent of students enrolled
   */
  private int percentEnrolledHigh;
  /**
   * the low end of the academic Scale
   */
  private int academicScaleLow;
  /**
   * the high end of the academic Scale
   */
  private int academicScaleHigh;
  /**
   * the low end of the social Scale
   */
  private int socialScaleLow;
  /**
   * the high end of the social scale
   */
  private int socialScaleHigh;
  /**
   * the low end of the quality of life scale
   */
  private int qualityScaleLow;
  /**
   * the high end of the quality of life scale
   */
  private int qualityScaleHigh;
  /**
   * the emphasis for a school
   */
  private String[] emphasis;
  /**
   * a array of schools
   */
  private ArrayList<School> schoolsArray;//Not in UML documents
  /**
   * a list of schools
   */
  private School[] schools;//Not in UML documents
  
  
  /** 
   * Pre: 
   * Post:
   * @param   schoolName
   * @param   state
   * @param   locatio
   * @param   control
   * @param   numberOfStudentsLow
   * @param   numberOfStudentsHigh
   * @param   femaleLow
   * @param   femaleHigh
   * @param   verbalSATLow
   * @param   verbalSATHigh
   * @param   mathSATLow
   * @param   mathSATHigh
   * @param   expensesLow
   * @param   expensesHigh
   * @param   aidLow
   * @param   aidHigh
   * @param   applicantsLow
   * @param   applicantsHigh
   * @param   percentAdmittedLow
   * @param   percentAdmittedHigh
   * @param   percentEnrolledLow
   * @param   percentEnrolledHigh
   * @param   academicScaleLow
   * @param   academicScaleHigh
   * @param   socialScaleLow
   * @param   socialScaleHigh
   * @param   qualityScaleLow
   * @param   qualityScaleHigh
   * @param   emphasis
   * @return School[] - array of schools that was searched for 
   */
  
  public School[] search(String schoolName, String state, String location, String control, int numberOfStudentsLow, int numberOfStudentsHigh, double femaleLow,
		  				double femaleHigh, int verbalSATLow, int verbalSATHigh, int mathSATLow, int mathSATHigh, int expensesLow, int expensesHigh, double aidLow, 
		  				double aidHigh, int applicantsLow, int applicantsHigh, double percentAdmittedLow, double percentAdmittedHigh, double percentEnrolledLow, double percentEnrolledHigh, 
		  				int academicScaleLow, int academicScaleHigh, int socialScaleLow, int socialScaleHigh, int qualityScaleLow, int qualityScaleHigh  ){//TODO add   , String[] emphasis
    
    List<School> tempSchools = new ArrayList<School>(); //Temp dynamic array to hold schools that have a give value
    schoolsArray = new ArrayList<School>();
    DBController dataBase = new DBController();
    schoolsArray = dataBase.getAllSchools();  //Array of all schools to look through
    schools = new School[schoolsArray.size()];
    schools = (School[]) schoolsArray.toArray();
    
    //Check if a school name is given
    if(!schoolName.equals("")){
      //Loop through schools
      for(int i = 0; i<schools.length;i++){
        //Check if the school matches the name or name fragment
        if(schools[i].getName().contains(schoolName)){
          //Add to temp array
          tempSchools.add(schools[i]);
        } 
      }
      //Override the schools array to only contain schools with the specified name or name fragment
      schools = (School[]) tempSchools.toArray();
    }
    //State
    if(!state.equals("")){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getState().contains(state)){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //Location
    if(!location.equals("")){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getLocation().contains(location)){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) (School[]) tempSchools.toArray();
    }
    //Control
    if(!control.equals("")){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getControl().contains(control)){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //numberOfStudentsLow
    if(!(numberOfStudentsLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getNumStudents() > numberOfStudentsLow){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //numberOfStudentsHigh
    if(!(numberOfStudentsHigh == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getNumStudents() < numberOfStudentsHigh){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //femaleLow
    if(!(femaleLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentFemale() > femaleLow){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //femaleHigh
    if(!(femaleHigh == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentFemale() < femaleHigh){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //verbalSATLow
    if(!(verbalSATLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getVerbalSAT() > verbalSATLow){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //verbalSATHigh
    if(!(verbalSATHigh == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getVerbalSAT() < verbalSATHigh){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //mathSATLow
    if(!(mathSATLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getMathSAT() > mathSATLow){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //mathSATHigh
    if(!(mathSATHigh == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getMathSAT() < mathSATHigh){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //expensesLow
    if(!(expensesLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getExpense() > expensesLow){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //expensesHigh
    if(!(expensesHigh == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getExpense() < expensesHigh){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //aidLow
    if(!(aidLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentFinAid() > aidLow){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //aidHigh
    if(!(aidHigh == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentFinAid() < aidHigh){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //applicantsLow
    if(!(applicantsLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getNumApplicants() > applicantsLow){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //applicantH
    if(!(aidHigh == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getNumApplicants() < applicantsHigh){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //percentAdmittedLow
    if(!(percentAdmittedLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentAdmit() > percentAdmittedLow){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //percentAdmittedHigh
    if(!(percentAdmittedHigh == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getPercentAdmit() < percentAdmittedHigh){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //percentEnrolledLow
    if(!(percentEnrolledLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentEnroll() > percentEnrolledLow){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //percentEnrolledHigh
    if(!(percentEnrolledHigh == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getPercentEnroll() < percentEnrolledHigh){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //academicScaleLow
    if(!(academicScaleLow == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getAcademicScale() < academicScaleLow){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    
    //academicScaleHigh
    if(!(academicScaleHigh == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getAcademicScale() < academicScaleHigh){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //socialScaleLow
    if(!(socialScaleLow == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getSocialScale() < socialScaleLow){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //socialScaleHigh
    if(!(socialScaleHigh == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getSocialScale() < socialScaleHigh){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
   //qualityScaleLow
    if(!(qualityScaleLow == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getQualityLifeScale() < qualityScaleLow){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //qualityScaleHigh
    if(!(qualityScaleHigh == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getQualityLifeScale() < qualityScaleHigh){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    
    
    
    //TODO: Parameters left:  String[] emphasis
    
    return schools;
  } 
  
  /** 
   * Returns array of schools as recommendations based on an input school
   *
   * @param  School - school that recommendations are based off of 
   * @return School[] - array of schools as recommendations 
   */
  
  
  public School[] getRecommendations(School s){

  /* 
   - numStudents: int            //Done
   - percentFemale: double       //Done
   - verbalSAT: int  (0-800)     //Done
   - mathSAT: int  (0-800)       //Done
   - expense: double             //Done
   - percentFinAid: double       //Done
   - numApplicants: int			 //DOne
   - percentAdmit: double		 //Done
   - percentEnroll: double		 //Done
   - acadmicScale: int  (1-5 Best)//Done
   - socialScale: int (1-5 Best)
   - qualityLifeScale: int (1-5 Best)*/
  
    
    //Initialize max/min values with first schools numbers
    int minNumStudents = schools[0].getNumStudents();
    int maxNumStudents = schools[0].getNumStudents();
    double minPercentFemale = 1.0;
    double maxPercentFemale = 0.0;
    int maxVerbalSAT = 0;
    int minVerbalSat = 800;
    int maxMathSAT = 0;
    int minMathSat = 800;
    double maxExpenses = 0;
    double minExpenses = schools[0].getExpense();
    double maxPercentFinAid = 0.0;
    double minPercentFinAid = 1.0;
    int maxNumApplicants = 0;
    int minNumApplicants = schools[0].getNumApplicants();
    double maxPercentAdmit = 0;
    double minPercentAdmit = 1.0;
    double maxPercentEnroll =0;
    double minPercentEnroll = 1.0;
    int maxAcademic = 0;
    int minAcademic = 6;
    int maxSocial = 0;
    int minSocial = 6;
    int maxQuality = 0;
    int minQuality = 6;
    
    
    //Loop through all schools to find min and max values
    for(int i = 0; i<schools.length;i++){
      //Number Students
      if(schools[i].getNumStudents() < minNumStudents)
        minNumStudents = schools[i].getNumStudents(); //Save min value
      else if(schools[i].getNumStudents() > maxNumStudents)
        maxNumStudents = schools[i].getNumStudents(); //Save max value
      //Percent Female
      if(schools[i].getPercentFemale() < minPercentFemale)
        minPercentFemale = schools[i].getPercentFemale();
      else if(schools[i].getPercentFemale() > maxPercentFemale)
        maxPercentFemale = schools[i].getPercentFemale();
      //Verbal SAT
      int vSAT = schools[i].getVerbalSAT();
      if(vSAT < minVerbalSat)
        minVerbalSat = vSAT;
      else if(vSAT > maxVerbalSAT)
        maxVerbalSAT = vSAT;
      //Math SAT
      int mSAT = schools[i].getMathSAT();
      if(mSAT < minMathSat)
        minMathSat = mSAT;
      else if(mSAT > maxMathSAT)
        maxMathSAT = mSAT;
      //Expenses
      double expense = schools[i].getExpense();
      if(expense < minExpenses)
        minExpenses = expense;
      else if(expense > maxExpenses)
        maxExpenses = expense;
      //percentFinAid
      double percentFin = schools[i].getPercentFinAid();
      if(percentFin < minPercentFinAid)
        minPercentFinAid = percentFin;
      else if(percentFin > maxPercentFinAid)
        maxPercentFinAid = percentFin;
      //numApplicants
      int numApp = schools[i].getNumApplicants();
      if(numApp < minNumApplicants)
    	  minNumApplicants = numApp;
      else if(numApp > maxNumApplicants)
    	  maxNumApplicants = numApp;
      //percentAdmitted
      double admit = schools[i].getPercentAdmit();
      if(admit < minPercentAdmit)
    	  minPercentAdmit = admit;
      else if(admit > maxPercentAdmit)
    	  maxPercentAdmit = admit;
      //percentEnroll
      double enroll = schools[i].getPercentEnroll();
      if(enroll < minPercentEnroll)
    	  minPercentEnroll = enroll;
      else if(enroll > maxPercentEnroll)
    	  maxPercentEnroll = enroll;
      //academicScale
      int academic = schools[i].getAcademicScale();
      if(academic < minAcademic)
    	  minAcademic = academic;
      else if(academic > maxAcademic)
    	  maxAcademic = academic;
      //socailScale
      int social = schools[i].getSocialScale();
      if(social < minSocial)
    	  minSocial = social;
      else if(social > maxSocial)
    	  maxSocial = social;
      //qualityScale
      int quality = schools[i].getQualityLifeScale();
      if(quality < minQuality)
    	  minQuality = quality;
      else if(quality > maxQuality)
    	  maxQuality = quality;

      
    }
    //Array to hold top 5 recommended schools
	School[] recommended = new School[5];
	//Array to hold top 5 distances that correlate to the top 5 schools
	List<Double> distance = new ArrayList<Double>();
    
    //See CMC_RankOrderingMatchingSchools_SPring2018.pdf
    //Distance Equation: ∑  |V1.Xi−V2.Xi|/|max(Xi)−min⁡(Xi)|
    
	double dist = 0;
	String sName = s.getName();
	String sState = s.getState();
	String sLocation = s.getLocation();
	String sControl = s.getControl();
    for(int n = 0; n<schools.length;n++){
    	if(!sName.equals(schools[n].getName()))
    	{
    		if(!sState.equals(schools[n].getState()))
    			dist++;
    		if(!sLocation.equals(schools[n].getLocation()))
    			dist++;
    		if(!sControl.equals(schools[n].getControl()))
    			dist++;

	      //Cast ints to doubles to avoid truncating integer division
	      //Abs to avoid negative numbers (no negative distance)
	      dist = Math.abs((double) s.getNumStudents()-schools[n].getNumStudents())/Math.abs(maxNumStudents-minNumStudents) + Math.abs(s.getPercentFemale()-schools[n].getPercentFemale())/Math.abs(maxPercentFemale-minPercentFemale);
	      dist+= Math.abs((double) s.getVerbalSAT()-schools[n].getVerbalSAT())/Math.abs(maxVerbalSAT-minVerbalSat);
	      dist+= Math.abs((double) s.getMathSAT()-schools[n].getMathSAT())/(maxMathSAT-minMathSat);
	      dist+= Math.abs(s.getExpense()-schools[n].getExpense())/(maxExpenses-minExpenses);
	      dist+= Math.abs(s.getPercentFinAid()-schools[n].getPercentFinAid())/(maxPercentFinAid-minPercentFinAid);
	      dist+= Math.abs((double) s.getNumApplicants()-schools[n].getNumApplicants())/(maxNumApplicants-minNumApplicants);
	      dist+= Math.abs(s.getPercentAdmit()-schools[n].getPercentAdmit())/(maxPercentAdmit-minPercentAdmit);
	      dist+= Math.abs(s.getPercentEnroll()-schools[n].getPercentEnroll())/(maxPercentEnroll-minPercentEnroll);
	      dist+= Math.abs((double) s.getAcademicScale()-schools[n].getAcademicScale())/(maxAcademic-minAcademic);
	      dist+= Math.abs((double) s.getSocialScale()-schools[n].getSocialScale())/(maxSocial-minSocial);
	      dist+= Math.abs((double) s.getQualityLifeScale()-schools[n].getQualityLifeScale())/(maxQuality-minQuality);

	      
	      double max = Collections.max(distance);
	      if(dist < max)
	      {
	    	int index = distance.indexOf(max);
	    	distance.set(index, dist);
	    	recommended[index] = schools[n];  	  
	      }
	  }
    }
    return recommended;
  }
}












