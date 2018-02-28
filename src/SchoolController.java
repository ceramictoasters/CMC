/**
 * a class to create, and edit schools
 * Author: Tyler Wilson
 * Version: February 27, 2018
 **/
public class SchoolController{
  /**
   * a method to edit the school
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
  public void editSchool( String name, String state, String location, String control, int numStudents,
                         double percentFemale, int verbalSAT, int mathSAT, double expense, double percentFinAid,
                         int numApplicants, double percentAdmit, double percentEnroll, int academicScale, 
                         int socialScale, int qualityLifeScale, String[] areasOfStudy){
    School existingSchool = new School(name, state, location, control, numStudents, percentFemale, verbalSAT,
                                  mathSAT, expense, percentFinAid, numApplicants, percentAdmit,
                                  percentEnroll, academicScale, socialScale, qualityLifeScale, areasOfStudy);
    
    db. editSchool(existingSchool);
  }
  /**
   * a method to edit the school
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
  public void createSchool( String name, String state, String location, String control, int numStudents,
                         double percentFemale, int verbalSAT, int mathSAT, double expense, double percentFinAid,
                         int numApplicants, double percentAdmit, double percentEnroll, int academicScale, 
                         int socialScale, int qualityLifeScale, String[] areasOfStudy){
    
    School newSchool = new School(name, state, location, control, numStudents, percentFemale, verbalSAT,
                                  mathSAT, expense, percentFinAid, numApplicants, percentAdmit,
                                  percentEnroll, academicScale, socialScale, qualityLifeScale, areasOfStudy);
    
    db.addNewSchool(newSchool);
  }
  
  
}