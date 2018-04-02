package CMC;
import java.util.*;
/**
 * School is a class that holds all of the specific information for a given school
 * Author: Tyler Wilson
 * Version: February 27, 2018
 **/
public class School {
  /**
   * name: the name of the school
   **/
  private String name;
  /**
   * state: the state that the school is in
   */
  private String state;
  /**
   * location: the type of area the school is in
   */
  private String location;
  /**
   * control: public or private
   */
  private String control;
  /**
   * numStudents: the number of students at a school
   **/
  private int numStudents;
  /**
   * verbalSAT: the verbal SAT score at a school
   **/
  private int verbalSAT;
  /**
   * mathSAT: the math SAT score at a school
   **/
  private int mathSAT;
  /**
   * numApplicants: the number of applicants at a school
   **/
  private int numApplicants;
  /**
   * academicScale: the academics on a scale from 1-5
   **/
  private int academicScale;
  /**
   * socialScale: the social life on a scale from 1-5
   **/
  private int socialScale;
  /**
   * qualityLifeScale: the quality of life on a scale from 1-5
   **/
  private int qualityLifeScale;
  /**
   * percentFemale: the percent of the students enrolled that are female
   **/
  private double percentFemale;
  /**
   * expense: the cost to attend a school
   **/
  private double expense;
  /**
   * percentFinAid: the percentage of students who recieve financial aid
   **/
  private double percentFinAid;
  /**
   * percentAdmit: the percentage of students who are admitted
   **/
  private double percentAdmit;
  /**
   * percentEnroll: the percentage of admitted students who enroll
   **/
  private double percentEnroll;
  /**
   * areasOfStudy: the areas of study at a school
   **/
  private ArrayList<String> areasOfStudy = new ArrayList<String>();
  

   /**
   * a constructor method for the school
   * @param name is the name of the school
   * @param state is the state of the school
   * @param location is the city the school is in
   * @param control is the control of the school
   * @param numStudents is the number of students at the school
   * @param percentFemale is the percentage of female students at the school
   * @param verbalSAT is the verbal SAT score
   * @param mathSAT is the math SAT score
   * @param expense is the cost
   * @param percentFinAid is the percentage of students that recieve financial aid
   * @param numApplicants is the number of applicants
   * @param percentAdmit is the percentage of students admitted
   * @param percentEnroll is the percentage of admitted students that enroll
   * @param academicScale is the scale of academics from 1-5
   * @param socialScale is the social scale from 1-5
   * @param qualityLifeScale is the quality of life scale from 1-5
   * @param areasOfStudy is the areas of study at a school
   **/
  public School(String name,String state, String location, String control, int numStudents, 
                double percentFemale, int verbalSAT, int mathSAT, double expense, double percentFinAid,
                int numApplicants, double percentAdmit, double percentEnroll, int academicScale,
                int socialScale, int qualityLifeScale, ArrayList<String> areasOfStudy){
    this.name = name;
    this.state = state;
    this.location = location;
    this.control=control;
    this.numStudents=numStudents;
    this.percentFemale = percentFemale;
    this.verbalSAT = verbalSAT;
    this.mathSAT = mathSAT;
    this.expense = expense;
    this.percentFinAid = percentFinAid;
    this.numApplicants = numApplicants;
    this.percentAdmit = percentAdmit;
    this.percentEnroll = percentEnroll;
    this.academicScale = academicScale;
    this.socialScale = socialScale;
    this.qualityLifeScale = qualityLifeScale;
    this.areasOfStudy = areasOfStudy;
  }
    
  /**
   * a setter method to set the name of a school
   * @param name is a String
   **/
  public void setName(String name){
    this.name = name;
  }
  /**
   * a getter method for the school name
   * @return the name of the school
   **/
  public String getName(){
    return this.name;
  }
  /**
   * a setter method for the state that the school is in
   * @param state is a String
   **/
  public void setState(String state){
    this.state=state;
  }
  /**
   * a getter method for the state that the school is in
   * @return the state that the school is in
   **/
  public String getState(){
    return this.state;
  }
  /**
   * a setter method for the location that the school is in
   * @param location is a String
   **/
  public void setLocation(String location){
    this.location=location;
  }
  /**
   * a getter method for the location that the school is in
   * @return the location that the school is in
   **/
  public String getLocation(){
    return this.location;
  }
  /**
   * a setter method for the control of the school
   * @param control is a String
   **/
  public void setControl(String control){
    this.control=control;
  }
  /**
   * a getter method for the control of a school
   * @return the control of the school
   **/
  public String getControl(){
    return this.control;
  }
  /**
   * a setter method for the number of students at a school
   * @param numStudents is an integer
   **/
  public void setNumStudents(int numStudents){
    this.numStudents=numStudents;
  }
  /**
   * a getter method for the number of students
   * @returns the number of students
   **/
  public int getNumStudents(){
    return this.numStudents;
  }
  /**
   * a setter method for the percent of female students
   * @param percentFemale is the percentage of female students
   **/
  public void setPercentFemale(double percentFemale){
    this.percentFemale=percentFemale;
  }
  /**
   * a getter method for the percent of female students
   * @returns the percent of female students;
   **/
  public double getPercentFemale(){
    return this.percentFemale;
  }
  /**
   * a setter method for the vebal SAT score
   * @param verbalSAT is an int
   * @pre: verbalSAT must be between 0 and 800
   * @post: verbalSAT will be set
   * @throws: IllegalArgumentException
   **/
  public void setVerbalSAT(int verbalSAT){
    if(verbalSAT < 0 || verbalSAT > 800)
      throw new IllegalArgumentException("SAT score must be between 0 and 800");
    this.verbalSAT = verbalSAT;
  }
  /**
   * a getter method for the verbal SAT score
   * @returns the verbal SAT score
   **/
  public int getVerbalSAT(){
    return this.verbalSAT;
  }
  /**
   * a setter method for the math SAT score
   * @param mathSAT is an int
   * @pre: mathSAT must be between 0 and 800
   * @post: mathSAT will be set
   * @throws IllegalArgumentException
   **/
  public void setMathSAT(int mathSAT){
    if(mathSAT < 0 || mathSAT > 800)
      throw new IllegalArgumentException("SAT score must be between 0 and 800");
    this.mathSAT = mathSAT;
  }
  /** 
   * a getter method for the mathSAT score
   * @returns the mathSAT score
   **/
  public int getMathSAT(){
    return this.mathSAT;
  }
  /** 
   * a setter method for the expense of the school
   * @param expense is a double
   **/
  public void setExpense(double expense){
    this.expense = expense;
  }
  /**
   * a getter method for the expense of the school
   * @returns the expense of the school
   **/
  public double getExpense(){
    return this.expense;
  }
  /**
   * a setter method for the percent of financial aid at a school
   * @param percentFinAid is a double
   **/
  public void setPercentFinAid(double percentFinAid){
    this.percentFinAid = percentFinAid;
  }
  /**
   * a getter method for the percent of financial aid at a school
   * @returns the percent of financial aid at a school
   **/
  public double getPercentFinAid(){
    return this.percentFinAid;
  }
  /**
   * a setter method for the number of applicants for a school
   * @param numApplicants is an int
   **/
  public void setNumApplicants(int numApplicants){
    this.numApplicants = numApplicants;
  }
  /**
   * a getter method for the number of applicants at a school
   * @returns the number of applicants
   **/
  public int getNumApplicants(){
    return this.numApplicants;
  }
  /**
   * a setter method for the percent of students admit
   * @param percentAdmit ia the percentage of students admitted
   **/
  public void setPercentAdmit(double percentAdmit){
    this.percentAdmit = percentAdmit;
  }
  /**
   * a getter method for the percentage of admitted students
   * @returns the percentage of admitted students
   **/
  public double getPercentAdmit(){
    return this.percentAdmit;
  }
  /**
   * a setter method for the percentage of students that enroll
   * @param precentEnroll is a double
   **/
  public void setPercentEnroll(double percentEnroll){
    this.percentEnroll = percentEnroll;
  }
  /**
   * a getter method for the percentage of students that enroll
   * @returns the percentage of students that enroll
   **/
  public double getPercentEnroll(){
    return this.percentEnroll;
  }
  /**
   * a setter method for the academic scale
   * @param academicScale is an int
   * @pre academicScale must be between 1 and 5
   * @post academicScale will be set for a school
   * @throws IllegalArgumentException
   **/
  public void setAcademicScale(int academicScale){
    if(academicScale < 1 || academicScale > 5)
      throw new IllegalArgumentException("Scale must be between 1 and 5");
    this.academicScale = academicScale;
  }
  /**
   * a getter method for the academic scale
   * @returns the academic scale
   **/
  public int getAcademicScale(){
    return this.academicScale;
  }
  /**
   * a setter method for the social Scale
   * @param socialScale is an int
   * @pre: socialScale must be between 1 and 5
   * @post: socialScale will be set for a school
   * @throws: IllegalArgumentException
   **/
  public void setSocialScale(int socialScale){
    if(socialScale < 1 || socialScale > 5)
      throw new IllegalArgumentException("Scale must be between 1 and 5");
    this.socialScale = socialScale;
  }
  /**
   * a getter method for the social Scale
   * @returns the social scale
   **/
  public int getSocialScale(){
    return this.socialScale;
  }
  /**
   * a setter method for the qualityLifeScale
   * @param qualityLifeScale is an int
   * @pre qualityLifeScale must be between 1 and 5
   * @post qualityLifeScale will be set for a school
   * @throws illegalArgumentException
   **/
  public void setQualityLifeScale(int qualityLifeScale){
    if(qualityLifeScale < 1 || qualityLifeScale > 5)
      throw new IllegalArgumentException("Scale must be between 1 and 5");
    this.qualityLifeScale = qualityLifeScale;
  }
  /**
   * a getter method for the qualityLifeScale
   * @returns the qualityLifeScale
   **/
  public int getQualityLifeScale(){
    return this.qualityLifeScale;
  }
  /**
   * a setter method for the areas of study at a school
   * @param areasOfStudy is a list of strings
   **/
  public void setAreasOfStudy(ArrayList<String> areasOfStudy){
    this.areasOfStudy = areasOfStudy;
  }
  /**
   * a getter method for the areas of study at a school
   * @returns the areas of study
   **/
  public ArrayList<String> getAreasOfStudy(){
    return this.areasOfStudy;
  }
  /**
   * a toString method
   * @returns a string
   **/
  public String toString(){
    return "\n-"+this.name + "\n--" + this.state + "\n--" + this.location + "\n--" + this.control + "\n--" +
      this.numStudents + "\n--" + this.percentFemale + "\n--" + this.verbalSAT + "\n--" + this.mathSAT + "\n--" +
      this.expense + "\n--" + this.percentFinAid + "\n--" + this.numApplicants + "\n--" + this.percentAdmit + "\n--" + 
      this.percentEnroll + "\n--" + this.academicScale + "\n--" + this.socialScale + "\n--" + this.qualityLifeScale + "\n--" +
      this.areasOfStudy + "\n"; 
  }
   
}
