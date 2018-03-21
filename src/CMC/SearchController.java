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


public class SearchController{
  
  //Variables listed in UML - NOTE: I do not see the use for these
//  private String schoolName;
//  private String state;
//  private String location;
//  private String control;
//  private int numberOfStudentsL;
//  private int numberOfStudentsH;
//  private int femaleL;
//  private int female;
//  private int VerbalSATL;
//  private int VerbalSATH;
//  private int MathSATL;
//  private int MathSATH;
//  private int expensesL;
//  private int expensesH;
//  private int aidL;
//  private int aidH;
//  private int applicantsL;
//  private int applicantsH;
//  private int perAdmittedL;
//  private int perAdmittedH;
//  private int perEnrolledL;
//  private int perEnrolledH;
//  private int academicScaleL;
//  private int academicScaleH;
//  private int socialScaleL;
//  private int socialScaleH;
//  private int qualityScaleL;
//  private int qualityScaleH;
  private String[] emphasis;
  
  
  
  
  
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
   * @return School[] - array of schoolsArraythat was searched for 
   */
  
  public ArrayList<School> search(String schoolName, String state, String location, String control, int numberOfStudentsL, int numberOfStudentsH, double femaleL,
		  				double femaleH, int verbalSATL, int verbalSATH, int mathSATL, int mathSATH, int expensesL, int expensesH, double aidL, 
		  				double aidH, int applicantsL, int applicantsH, double perAdmittedL, double perAdmittedH, double perEnrolledL, double perEnrolledH, 
		  				int academicScaleL, int academicScaleH, int socialScaleL, int socialScaleH, int qualityScaleL, int qualityScaleH, ArrayList<String> emphasis){//TODO add   , String[] emphasis
    
    ArrayList<School> tempSchools = new ArrayList<School>(); //Temp dynamic array to hold schoolsArraythat have a give value
    ArrayList<School> schoolsArray = new ArrayList<School>();
    DBController dataBase = new DBController();
    schoolsArray =  dataBase.getAllSchools();  //Array of all schoolsArrayto look through
    //schoolsArray= new School[schoolsArray.size()];
    //schoolsArray=  schoolsArray.toArray(schools);
    
    
    //Check if a school name is given
    if(!schoolName.equals("")){
      //Loop through schools
     for(School s : schoolsArray){
        //Check if the school matches the name or name fragment
        if( s.getName().contains(schoolName)){
          //Add to temp array
          tempSchools.add(s);
        } 
      }
      
      //Override the schoolsArrayarray to only contain schoolsArraywith the specified name or name fragment
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();

    }
    
    //state
    if(!state.equals("")){
       for(School s : schoolsArray){
          if( s.getState().contains(state)){
            tempSchools.add(s);
          } 
        }
       if(tempSchools.isEmpty())
           return tempSchools;
        schoolsArray = (ArrayList<School>) tempSchools.clone();
        tempSchools.clear();;
      }
    
 
    //for(School s:schools)
  	//  System.out.println(s.toString());
    //Location
    if(!location.equals("")){
     for(School s : schoolsArray){
        if( s.getLocation().contains(location)){
          tempSchools.add(s);
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //Control
    if(!control.equals("")){
     for(School s : schoolsArray){
        if( s.getControl().contains(control)){
          tempSchools.add(s);
          
        } 
      }
      if(tempSchools.isEmpty())
          return tempSchools;
       schoolsArray = (ArrayList<School>) tempSchools.clone();
       tempSchools.clear();
       System.out.println("Size" + schoolsArray.size());
    }
    //System.out.println(schoolsArray.toString());
    //numberOfStudentsL
    if(!(numberOfStudentsL == -1)){
     for(School s : schoolsArray){
        if( s.getNumStudents() > numberOfStudentsL){
          tempSchools.add(s);
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //System.out.println(schoolsArray.toString());
    //numberOfStudentsH
    if(!(numberOfStudentsH == -1)){
     for(School s : schoolsArray){
        if( s.getNumStudents() < numberOfStudentsH){
          tempSchools.add(s);
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //System.out.println(schoolsArray.toString());
    //femaleL
    if(!(femaleL == -1)){
     for(School s : schoolsArray){
        if( s.getPercentFemale() > femaleL){
          tempSchools.add(s);
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //femaleH
    if(!(femaleH == -1)){
     for(School s : schoolsArray){
        if( s.getPercentFemale() < femaleH){
          tempSchools.add(s);
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();;
    }
    //verbalSATL
    if(!(verbalSATL == -1)){
     for(School s : schoolsArray){
        if(s.getVerbalSAT() > verbalSATL){
          tempSchools.add(s);
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //verbalSATH
    if(!(verbalSATH == -1)){
     for(School s : schoolsArray){
        if( s.getVerbalSAT() < verbalSATH){
          tempSchools.add(s);
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //mathSATL
    if(!(mathSATL == -1)){
     for(School s : schoolsArray){
        if( s.getMathSAT() > mathSATL){
          tempSchools.add(s);
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //mathSATH
    if(!(mathSATH == -1)){
     for(School s : schoolsArray){
        if( s.getMathSAT() < mathSATH){
          tempSchools.add(s);
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //expensesL
    if(!(expensesL == -1)){
     for(School s : schoolsArray){
        if( s.getExpense() > expensesL){
          tempSchools.add(s);
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //expensesH 
    if(!(expensesH == -1)){
     for(School s : schoolsArray){
        if( s.getExpense() < expensesH){
          tempSchools.add(s);
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //aidL
  
    if(aidL >= 0){
    	for(School s : schoolsArray){
    	 
        if( s.getPercentFinAid() > aidL){
          tempSchools.add(s);
        } 
      }
        if(tempSchools.isEmpty())
            return tempSchools;
         schoolsArray = (ArrayList<School>) tempSchools.clone();
         tempSchools.clear();
    }
    //aidH
    if(!(aidH == -1)){
     for(School s : schoolsArray){
        if( s.getPercentFinAid() < aidH){
          tempSchools.add(s);
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //applicantsL
    if(!(applicantsL == -1)){
     for(School s : schoolsArray){
        if( s.getNumApplicants() > applicantsL){
          tempSchools.add(s);
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //applicantH
    if(!(aidH == -1)){
     for(School s : schoolsArray){
		if( s.getNumApplicants() < applicantsH){
          tempSchools.add(s);
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //perAdmittedL
    if(!(perAdmittedL == -1)){
     for(School s : schoolsArray){
        if( s.getPercentAdmit() > perAdmittedL){
          tempSchools.add(s);
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();;
    }
    //perAdmittedH
    if(!(perAdmittedH == -1)){
     for(School s : schoolsArray){
		if( s.getPercentAdmit() < perAdmittedH){
          tempSchools.add(s);
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //perEnrolledL
    if(!(perEnrolledL == -1)){
     for(School s : schoolsArray){
        if( s.getPercentEnroll() > perEnrolledL){
          tempSchools.add(s);
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //perEnrolledH
    if(!(perEnrolledH == -1)){
     for(School s : schoolsArray){
		if( s.getPercentEnroll() < perEnrolledH){
          tempSchools.add(s);
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //academicScaleL
    if(!(academicScaleL == -1)){
     for(School s: schoolsArray){
		if( s.getAcademicScale() >= academicScaleL){
          tempSchools.add(s);
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //academicScaleH
    if(!(academicScaleH == -1)){
    	for(School s : schoolsArray){
		if( s.getAcademicScale() <= academicScaleH){
          tempSchools.add(s);
          
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //socialScaleL
    if(!(socialScaleL == -1)){
     for(School s : schoolsArray){
		if( s.getSocialScale() >= socialScaleL){
          tempSchools.add(s);
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //socialScaleH
    if(!(socialScaleH == -1)){
     for(School s : schoolsArray){
		if( s.getSocialScale() <= socialScaleH){
          tempSchools.add(s);
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
     //qualityScaleL
    if(!(qualityScaleL == -1)){
     for(School s : schoolsArray){
		if( s.getQualityLifeScale() >= qualityScaleL){
          tempSchools.add(s);
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //qualityScaleH
    if(!(qualityScaleH == -1)){
     for(School s : schoolsArray){
		if( s.getQualityLifeScale() <= qualityScaleH){
          tempSchools.add(s);
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
       
    //Emphasis

//    if(!emphasis.equals(null)){
//
//     for(School s : schoolsArray){
//     	for(String e: emphasis) {
//     		if(!s.getAreasOfStudy().equals(null)) {
//     			for(String emph: s.getAreasOfStudy()){
//     				if(emph.equals(e)){
//     					tempSchools.add(s);
//    			}
//    		}
//     	  }
//     	}		
//      }     
//     if(tempSchools.isEmpty())
//         return tempSchools;
//      schoolsArray = (ArrayList<School>) tempSchools.clone();
//      tempSchools.clear();
//    
//    }
    
    //TODO: Parameters left:  String[] emphasis
    
    return schoolsArray;
  } 
  
  /** 
   * Returns array of schoolsArrayas recommendations based on an input school
   *
   * @param  School - school that recommendations are based off of 
   * @return School[] - array of schoolsArrayas recommendations 
   */
  
  
  public ArrayList<School> getRecommendations(School s){

	    ArrayList<School> schoolsArray = new ArrayList<School>();
	    DBController dataBase = new DBController();
	    schoolsArray =  dataBase.getAllSchools();  //Array of all schoolsArrayto look through
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
   - socialScale: int (1-5 Best)  //Done
   - qualityLifeScale: int (1-5 Best)//Done
   
   TODO:Emphasis: Not DONE
   */
  
    
    //Initialize max/min values with first schoolsArraynumbers
    int minNumStudents = schoolsArray.get(0).getNumStudents();
    int maxNumStudents = schoolsArray.get(0).getNumStudents();
    double minPercentFemale = 1.0;
    double maxPercentFemale = 0.0;
    int maxVerbalSAT = 0;
    int minVerbalSat = 800;
    int maxMathSAT = 0;
    int minMathSat = 800;
    double maxExpenses = 0;
    double minExpenses = schoolsArray.get(0).getExpense();
    double maxPercentFinAid = 0.0;
    double minPercentFinAid = 1.0;
    int maxNumApplicants = 0;
    int minNumApplicants = schoolsArray.get(0).getNumApplicants();
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
    
    
    //Loop through all schoolsArrayto find min and max values
   for(School sch : schoolsArray){
      //Number Students
      if( sch.getNumStudents() < minNumStudents)
        minNumStudents = sch.getNumStudents(); //Save min value
      else if( sch.getNumStudents() > maxNumStudents)
        maxNumStudents = sch.getNumStudents(); //Save max value
      //Percent Female
      if( sch.getPercentFemale() < minPercentFemale)
        minPercentFemale = sch.getPercentFemale();
      else if( sch.getPercentFemale() > maxPercentFemale)
        maxPercentFemale = sch.getPercentFemale();
      //Verbal SAT
      int vSAT = sch.getVerbalSAT();
      if(vSAT < minVerbalSat)
        minVerbalSat = vSAT;
      else if(vSAT > maxVerbalSAT)
        maxVerbalSAT = vSAT;
      //Math SAT
      int mSAT = sch.getMathSAT();
      if(mSAT < minMathSat)
        minMathSat = mSAT;
      else if(mSAT > maxMathSAT)
        maxMathSAT = mSAT;
      //Expenses
      double expense = sch.getExpense();
      if(expense < minExpenses)
        minExpenses = expense;
      else if(expense > maxExpenses)
        maxExpenses = expense;
      //percentFinAid
      double percentFin = sch.getPercentFinAid();
      if(percentFin < minPercentFinAid)
        minPercentFinAid = percentFin;
      else if(percentFin > maxPercentFinAid)
        maxPercentFinAid = percentFin;
      //numApplicants
      int numApp = sch.getNumApplicants();
      if(numApp < minNumApplicants)
    	  minNumApplicants = numApp;
      else if(numApp > maxNumApplicants)
    	  maxNumApplicants = numApp;
      //percentAdmitted
      double admit = sch.getPercentAdmit();
      if(admit < minPercentAdmit)
    	  minPercentAdmit = admit;
      else if(admit > maxPercentAdmit)
    	  maxPercentAdmit = admit;
      //percentEnroll
      double enroll = sch.getPercentEnroll();
      if(enroll < minPercentEnroll)
    	  minPercentEnroll = enroll;
      else if(enroll > maxPercentEnroll)
    	  maxPercentEnroll = enroll;
      //academicScale
      int academic = sch.getAcademicScale();
      if(academic < minAcademic)
    	  minAcademic = academic;
      else if(academic > maxAcademic)
    	  maxAcademic = academic;
      //socailScale
      int social = sch.getSocialScale();
      if(social < minSocial)
    	  minSocial = social;
      else if(social > maxSocial)
    	  maxSocial = social;
      //qualityScale
      int quality = sch.getQualityLifeScale();
      if(quality < minQuality)
    	  minQuality = quality;
      else if(quality > maxQuality)
    	  maxQuality = quality;

      
    }
    //Array to hold top 5 recommended schools
	ArrayList<School> recommended = new ArrayList<School>();
	//Array to hold top 5 distances that correlate to the top 5 schools
	ArrayList<Double> distance = new ArrayList<Double>();
    
    //See CMC_RankOrderingMatchingSchools_SPring2018.pdf
    //Distance Equation: ∑  |V1.Xi−V2.Xi|/|max(Xi)−min⁡(Xi)|
    
	double dist = 0;
	String sName = s.getName();
	String sState = s.getState();
	String sLocation = s.getLocation();
	String sControl = s.getControl();
    for(int n = 0; n<schoolsArray.size();n++){
    	if(!sName.equals(schoolsArray.get(n).getName()))
    	{
    		if(!sState.equals(schoolsArray.get(n).getState()))
    			dist++;
    		if(!sLocation.equals(schoolsArray.get(n).getLocation()))
    			dist++;
    		if(!sControl.equals(schoolsArray.get(n).getControl()))
    			dist++;

	      //Cast ints to doubles to avoid truncating integer division
	      //Abs to avoid negative numbers (no negative distance)
	      dist = Math.abs((double) s.getNumStudents()-schoolsArray.get(n).getNumStudents())/Math.abs(maxNumStudents-minNumStudents) 
	    		  + Math.abs(s.getPercentFemale()-schoolsArray.get(n).getPercentFemale())/Math.abs(maxPercentFemale-minPercentFemale);
	      dist+= Math.abs((double) s.getVerbalSAT()-schoolsArray.get(n).getVerbalSAT())/Math.abs(maxVerbalSAT-minVerbalSat);
	      dist+= Math.abs((double) s.getMathSAT()-schoolsArray.get(n).getMathSAT())/(maxMathSAT-minMathSat);
	      dist+= Math.abs(s.getExpense()-schoolsArray.get(n).getExpense())/(maxExpenses-minExpenses);
	      dist+= Math.abs(s.getPercentFinAid()-schoolsArray.get(n).getPercentFinAid())/(maxPercentFinAid-minPercentFinAid);
	      dist+= Math.abs((double) s.getNumApplicants()-schoolsArray.get(n).getNumApplicants())/(maxNumApplicants-minNumApplicants);
	      dist+= Math.abs(s.getPercentAdmit()-schoolsArray.get(n).getPercentAdmit())/(maxPercentAdmit-minPercentAdmit);
	      dist+= Math.abs(s.getPercentEnroll()-schoolsArray.get(n).getPercentEnroll())/(maxPercentEnroll-minPercentEnroll);
	      dist+= Math.abs((double) s.getAcademicScale()-schoolsArray.get(n).getAcademicScale())/(maxAcademic-minAcademic);
	      dist+= Math.abs((double) s.getSocialScale()-schoolsArray.get(n).getSocialScale())/(maxSocial-minSocial);
	      dist+= Math.abs((double) s.getQualityLifeScale()-schoolsArray.get(n).getQualityLifeScale())/(maxQuality-minQuality);

	      if(n<5) {
		    distance.add(dist);
		    recommended.add(schoolsArray.get(n));  
	      }
	      else {
	    	  
	      double max = Collections.max(distance);
	      if(dist < max)
	      {
	    	int index = distance.indexOf(max);
	    	distance.set(index, dist);
	    	recommended.set(index, schoolsArray.get(n));  	  
	      }
	    }
	  }
    }
    return recommended;
  }
}












