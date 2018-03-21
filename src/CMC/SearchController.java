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
  
<<<<<<< HEAD
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
  
  
  
=======
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
  private static School[] schools;//Not in UML documents
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
  
  
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
   * @return School[] - array of schoolsArraythat was searched for 
   */
  
<<<<<<< HEAD
  public ArrayList<School> search(String schoolName, String state, String location, String control, int numberOfStudentsL, int numberOfStudentsH, double femaleL,
		  				double femaleH, int verbalSATL, int verbalSATH, int mathSATL, int mathSATH, int expensesL, int expensesH, double aidL, 
		  				double aidH, int applicantsL, int applicantsH, double perAdmittedL, double perAdmittedH, double perEnrolledL, double perEnrolledH, 
		  				int academicScaleL, int academicScaleH, int socialScaleL, int socialScaleH, int qualityScaleL, int qualityScaleH, ArrayList<String> emphasis){//TODO add   , String[] emphasis
=======
  public School[] search(String schoolName, String state, String location, String control, int numberOfStudentsLow, int numberOfStudentsHigh, double femaleLow,
		  				double femaleHigh, int verbalSATLow, int verbalSATHigh, int mathSATLow, int mathSATHigh, int expensesLow, int expensesHigh, double aidLow, 
		  				double aidHigh, int applicantsLow, int applicantsHigh, double percentAdmittedLow, double percentAdmittedHigh, double percentEnrolledLow, double percentEnrolledHigh, 
		  				int academicScaleLow, int academicScaleHigh, int socialScaleLow, int socialScaleHigh, int qualityScaleLow, int qualityScaleHigh  ){//TODO add   , String[] emphasis
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
    
    ArrayList<School> tempSchools = new ArrayList<School>(); //Temp dynamic array to hold schoolsArraythat have a give value
    ArrayList<School> schoolsArray = new ArrayList<School>();
    DBController dataBase = new DBController();
<<<<<<< HEAD
    schoolsArray =  dataBase.getAllSchools();  //Array of all schoolsArrayto look through
    //schoolsArray= new School[schoolsArray.size()];
    //schoolsArray=  schoolsArray.toArray(schools);
    
=======
    schoolsArray = dataBase.getAllSchools();  //Array of all schools to look through
    schools = new School[schoolsArray.size()];
    schools = (School[]) schoolsArray.toArray();
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
    
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
<<<<<<< HEAD
    //System.out.println(schoolsArray.toString());
    //numberOfStudentsL
    if(!(numberOfStudentsL == -1)){
     for(School s : schoolsArray){
        if( s.getNumStudents() > numberOfStudentsL){
          tempSchools.add(s);
=======
    //numberOfStudentsLow
    if(!(numberOfStudentsLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getNumStudents() > numberOfStudentsLow){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //System.out.println(schoolsArray.toString());
    //numberOfStudentsH
    if(!(numberOfStudentsH == -1)){
     for(School s : schoolsArray){
        if( s.getNumStudents() < numberOfStudentsH){
          tempSchools.add(s);
=======
    //numberOfStudentsHigh
    if(!(numberOfStudentsHigh == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getNumStudents() < numberOfStudentsHigh){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //System.out.println(schoolsArray.toString());
    //femaleL
    if(!(femaleL == -1)){
     for(School s : schoolsArray){
        if( s.getPercentFemale() > femaleL){
          tempSchools.add(s);
=======
    //femaleLow
    if(!(femaleLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentFemale() > femaleLow){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //femaleH
    if(!(femaleH == -1)){
     for(School s : schoolsArray){
        if( s.getPercentFemale() < femaleH){
          tempSchools.add(s);
=======
    //femaleHigh
    if(!(femaleHigh == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentFemale() < femaleHigh){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();;
    }
<<<<<<< HEAD
    //verbalSATL
    if(!(verbalSATL == -1)){
     for(School s : schoolsArray){
        if(s.getVerbalSAT() > verbalSATL){
          tempSchools.add(s);
=======
    //verbalSATLow
    if(!(verbalSATLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getVerbalSAT() > verbalSATLow){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //verbalSATH
    if(!(verbalSATH == -1)){
     for(School s : schoolsArray){
        if( s.getVerbalSAT() < verbalSATH){
          tempSchools.add(s);
=======
    //verbalSATHigh
    if(!(verbalSATHigh == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getVerbalSAT() < verbalSATHigh){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //mathSATL
    if(!(mathSATL == -1)){
     for(School s : schoolsArray){
        if( s.getMathSAT() > mathSATL){
          tempSchools.add(s);
=======
    //mathSATLow
    if(!(mathSATLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getMathSAT() > mathSATLow){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //mathSATH
    if(!(mathSATH == -1)){
     for(School s : schoolsArray){
        if( s.getMathSAT() < mathSATH){
          tempSchools.add(s);
=======
    //mathSATHigh
    if(!(mathSATHigh == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getMathSAT() < mathSATHigh){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //expensesL
    if(!(expensesL == -1)){
     for(School s : schoolsArray){
        if( s.getExpense() > expensesL){
          tempSchools.add(s);
=======
    //expensesLow
    if(!(expensesLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getExpense() > expensesLow){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //expensesH 
    if(!(expensesH == -1)){
     for(School s : schoolsArray){
        if( s.getExpense() < expensesH){
          tempSchools.add(s);
=======
    //expensesHigh
    if(!(expensesHigh == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getExpense() < expensesHigh){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //aidL
  
    if(aidL >= 0){
    	for(School s : schoolsArray){
    	 
        if( s.getPercentFinAid() > aidL){
          tempSchools.add(s);
=======
    //aidLow
    if(!(aidLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentFinAid() > aidLow){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }
        if(tempSchools.isEmpty())
            return tempSchools;
         schoolsArray = (ArrayList<School>) tempSchools.clone();
         tempSchools.clear();
    }
<<<<<<< HEAD
    //aidH
    if(!(aidH == -1)){
     for(School s : schoolsArray){
        if( s.getPercentFinAid() < aidH){
          tempSchools.add(s);
=======
    //aidHigh
    if(!(aidHigh == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentFinAid() < aidHigh){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //applicantsL
    if(!(applicantsL == -1)){
     for(School s : schoolsArray){
        if( s.getNumApplicants() > applicantsL){
          tempSchools.add(s);
=======
    //applicantsLow
    if(!(applicantsLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getNumApplicants() > applicantsLow){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
    //applicantH
<<<<<<< HEAD
    if(!(aidH == -1)){
     for(School s : schoolsArray){
		if( s.getNumApplicants() < applicantsH){
          tempSchools.add(s);
=======
    if(!(aidHigh == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getNumApplicants() < applicantsHigh){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //perAdmittedL
    if(!(perAdmittedL == -1)){
     for(School s : schoolsArray){
        if( s.getPercentAdmit() > perAdmittedL){
          tempSchools.add(s);
=======
    //percentAdmittedLow
    if(!(percentAdmittedLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentAdmit() > percentAdmittedLow){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();;
    }
<<<<<<< HEAD
    //perAdmittedH
    if(!(perAdmittedH == -1)){
     for(School s : schoolsArray){
		if( s.getPercentAdmit() < perAdmittedH){
          tempSchools.add(s);
=======
    //percentAdmittedHigh
    if(!(percentAdmittedHigh == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getPercentAdmit() < percentAdmittedHigh){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //perEnrolledL
    if(!(perEnrolledL == -1)){
     for(School s : schoolsArray){
        if( s.getPercentEnroll() > perEnrolledL){
          tempSchools.add(s);
=======
    //percentEnrolledLow
    if(!(percentEnrolledLow == -1)){
      for(int i = 0; i<schools.length;i++){
        if(schools[i].getPercentEnroll() > percentEnrolledLow){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //perEnrolledH
    if(!(perEnrolledH == -1)){
     for(School s : schoolsArray){
		if( s.getPercentEnroll() < perEnrolledH){
          tempSchools.add(s);
=======
    //percentEnrolledHigh
    if(!(percentEnrolledHigh == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getPercentEnroll() < percentEnrolledHigh){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //academicScaleL
    if(!(academicScaleL == -1)){
     for(School s: schoolsArray){
		if( s.getAcademicScale() >= academicScaleL){
          tempSchools.add(s);
=======
    //academicScaleLow
    if(!(academicScaleLow == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getAcademicScale() < academicScaleLow){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //academicScaleH
    if(!(academicScaleH == -1)){
    	for(School s : schoolsArray){
		if( s.getAcademicScale() <= academicScaleH){
          tempSchools.add(s);
          
=======
    
    //academicScaleHigh
    if(!(academicScaleHigh == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getAcademicScale() < academicScaleHigh){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //socialScaleL
    if(!(socialScaleL == -1)){
     for(School s : schoolsArray){
		if( s.getSocialScale() >= socialScaleL){
          tempSchools.add(s);
=======
    //socialScaleLow
    if(!(socialScaleLow == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getSocialScale() < socialScaleLow){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //socialScaleH
    if(!(socialScaleH == -1)){
     for(School s : schoolsArray){
		if( s.getSocialScale() <= socialScaleH){
          tempSchools.add(s);
=======
    //socialScaleHigh
    if(!(socialScaleHigh == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getSocialScale() < socialScaleHigh){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
     //qualityScaleL
    if(!(qualityScaleL == -1)){
     for(School s : schoolsArray){
		if( s.getQualityLifeScale() >= qualityScaleL){
          tempSchools.add(s);
=======
   //qualityScaleLow
    if(!(qualityScaleLow == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getQualityLifeScale() < qualityScaleLow){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
        } 
      }     
     if(tempSchools.isEmpty())
         return tempSchools;
      schoolsArray = (ArrayList<School>) tempSchools.clone();
      tempSchools.clear();
    }
<<<<<<< HEAD
    //qualityScaleH
    if(!(qualityScaleH == -1)){
     for(School s : schoolsArray){
		if( s.getQualityLifeScale() <= qualityScaleH){
          tempSchools.add(s);
=======
    //qualityScaleHigh
    if(!(qualityScaleHigh == -1)){
      for(int i = 0; i<schools.length;i++){
		if(schools[i].getQualityLifeScale() < qualityScaleHigh){
          tempSchools.add(schools[i]);
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24
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
  
  
<<<<<<< HEAD
  public ArrayList<School> getRecommendations(School s){
=======
  public static School[] getRecommendations(School s){
>>>>>>> 2bbdffdb193287d52d8faa98b6b0d7becabc0b24

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












