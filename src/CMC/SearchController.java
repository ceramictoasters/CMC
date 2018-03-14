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
  
  //Variables listed in UML - NOTE: I do not see the use for these
  private String schoolName;
  private String state;
  private String location;
  private String control;
  private int numberOfStudentsL;
  private int numberOfStudentsH;
  private int femaleL;
  private int female;
  private int VerbalSATL;
  private int VerbalSATH;
  private int MathSATL;
  private int MathSATH;
  private int expensesL;
  private int expensesH;
  private int aidL;
  private int aidH;
  private int applicantsL;
  private int applicantsH;
  private int perAdmittedL;
  private int perAdmittedH;
  private int perEnrolledL;
  private int perEnrolledH;
  private int academicScaleL;
  private int academicScaleH;
  private int socialScaleL;
  private int socialScaleH;
  private int qualityScaleL;
  private int qualityScaleH;
  private String[] emphasis;
  
  private ArrayList<School> schoolsArray;//Not in UML documents
  private School[] schools;//Not in UML documents
  
  
  /** 
   * Pre: 
   * Post:
   * @param   schoolName
   * @param   state
   * @param   locatio
   * @param   control
   * @param   numberOfStudentsL
   * @param   numberOfStudentsH
   * @param   femaleL
   * @param   femaleH
   * @param   VerbalSATL
   * @param   VerbalSATH
   * @param   MathSATL
   * @param   MathSATH
   * @param   expensesL
   * @param   expensesH
   * @param   aidL
   * @param   aidH
   * @param   applicantsL
   * @param   applicantsH
   * @param   perAdmittedL
   * @param   perAdmittedH
   * @param   perEnrolledL
   * @param   perEnrolledH
   * @param   academicScaleL
   * @param   academicScaleH
   * @param   socialScaleL
   * @param   socialScaleH
   * @param   qualityScaleL
   * @param   qualityScaleH
   * @param   emphasis
   * @return School[] - array of schools that was searched for 
   */
  
  public School[] search(String schoolName, String state, String location, String control, int numberOfStudentsL, int numberOfStudentsH, double femaleL,
		  				double femaleH, int verbalSATL, int verbalSATH, int mathSATL, int mathSATH, int expensesL, int expensesH, double aidL, 
		  				double aidH, int applicantsL, int applicantsH, double perAdmittedL, double perAdmittedH, double perEnrolledL, double perEnrolledH, 
		  				int academicScaleL, int academicScaleH, int socialScaleL, int socialScaleH, int qualityScaleL, int qualityScaleH  ){//TODO add   , String[] emphasis
    
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
    //numberOfStudentsL
    if(!(numberOfStudentsL == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getNumStudents() > numberOfStudentsL){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //numberOfStudentsH
    if(!(numberOfStudentsH == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getNumStudents() < numberOfStudentsH){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //femaleL
    if(!(femaleL == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentFemale() > femaleL){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //femaleH
    if(!(femaleH == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentFemale() < femaleH){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //verbalSATL
    if(!(verbalSATL == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getVerbalSAT() > verbalSATL){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //verbalSATH
    if(!(verbalSATH == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getVerbalSAT() < verbalSATH){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //mathSATL
    if(!(mathSATL == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getMathSAT() > mathSATL){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //mathSATH
    if(!(mathSATH == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getMathSAT() < mathSATH){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //expensesL
    if(!(expensesL == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getExpense() > expensesL){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //expensesH
    if(!(expensesH == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getExpense() < expensesH){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //aidL
    if(!(aidL == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentFinAid() > aidL){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
    }
    //aidH
    if(!(aidH == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentFinAid() < aidH){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //applicantsL
    if(!(applicantsL == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getNumApplicants() > applicantsL){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //applicantH
    if(!(aidH == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getNumApplicants() < applicantsH){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //perAdmittedL
    if(!(perAdmittedL == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentAdmit() > perAdmittedL){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //perAdmittedH
    if(!(perAdmittedH == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getPercentAdmit() < perAdmittedH){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //perEnrolledL
    if(!(perEnrolledL == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentEnroll() > perEnrolledL){
          tempSchools.add(schools[i]);
        } 
      }
      schools = (School[]) (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //perEnrolledH
    if(!(perEnrolledH == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getPercentEnroll() < perEnrolledH){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //academicScaleL
    if(!(academicScaleL == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getAcademicScale() < academicScaleL){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    
    //academicScaleH
    if(!(academicScaleH == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getAcademicScale() < academicScaleH){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //socialScaleL
    if(!(socialScaleL == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getSocialScale() < socialScaleL){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //socialScaleH
    if(!(socialScaleH == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getSocialScale() < socialScaleH){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
   //qualityScaleL
    if(!(qualityScaleL == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getQualityLifeScale() < qualityScaleL){
          tempSchools.add(schools[i]);
        } 
      }     
      schools = (School[]) tempSchools.toArray();
      if(tempSchools.isEmpty())
        return schools;
    }
    //qualityScaleH
    if(!(qualityScaleH == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getQualityLifeScale() < qualityScaleH){
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












