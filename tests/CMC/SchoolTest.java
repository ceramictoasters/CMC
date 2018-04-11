package CMC;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class SchoolTest {
	private School newSchool;
	private ArrayList<String> myEmphasis;

	@Before
	public void setUp() throws Exception {
		newSchool = new School("SCHOOLNAME", "SCHOOLSTATE", "STATELOCATION", "STATECONTROLLER", 1000,
				.5, 720, 790, 10000.1, .1, 2000, .25, .15, 5, 4, 3, myEmphasis );
		
	}

	@Test
	public void testCreateSchool() {
		School createdSchool = new School("SCHOOLNAME", "SCHOOLSTATE", "STATELOCATION", "STATECONTROLLER", 1000,
				.5, 720, 790, 10000.1, .1, 2000, .25, .15, 5, 4, 3, myEmphasis );
		assertEquals("created school equals newSchool", newSchool, createdSchool);
	}
	
	@Test
	public void testEqualsObject() {
		School createdSchool = new School("SCHOOLNAME", "SCHOOLSTATE", "STATELOCATION", "STATECONTROLLER", 1000,
				.5, 720, 790, 10000.1, .1, 2000, .25, .15, 5, 4, 3, myEmphasis );
		assertTrue("These two schools are equal", createdSchool.equals(newSchool));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetVerbalSATFailsNegativeInput() {
		newSchool.setVerbalSAT(-1);
	}
	
	@Test
	public void testSetVerbalSATAtBoundaryValue() {
		newSchool.setVerbalSAT(0);
	}
	
	@Test
	public void testSetVerbalSATAboveBoundaryValue() {
		newSchool.setVerbalSAT(1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetMathSATFailsOverMaxValue() {
		newSchool.setMathSAT(850);
	}
	
	@Test
	public void testSetMathSATAtBoundaryValue() {
		newSchool.setVerbalSAT(0);
	}
	
	@Test
	public void testSetMathSATAboveBoundaryValue() {
		newSchool.setMathSAT(1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetAcademicScaleFailsZeroInput() {
		newSchool.setAcademicScale(0);
	}
	
	@Test
	public void testAcademicScaleAtBoundaryValue() {
		newSchool.setAcademicScale(1);
	}
	
	@Test
	public void testAcademicScaleAboveBoundaryValue() {
		newSchool.setAcademicScale(2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetSocialScaleFailsNegativeInput() {
		newSchool.setSocialScale(-1);
	}
	
	@Test
	public void testQualityLifeScaleAtBoundaryValue() {
		newSchool.setQualityLifeScale(1);
	}
	
	@Test
	public void testQualityLifeScaleAboveBoundaryValue() {
		newSchool.setQualityLifeScale(2);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetQualityLifeScaleFails0Input() {
		newSchool.setQualityLifeScale(0);
	}
	
	@Test
	public void testSocialScaleAtBoundaryValue() {
		newSchool.setSocialScale(1);
	}
	
	@Test
	public void testSocialScaleAboveBoundaryValue() {
		newSchool.setSocialScale(2);
	}
	
	@Test
	public void testName() {
		newSchool.setName("newSchoolName");
		assertTrue("Name was set", newSchool.getName().equals("newSchoolName"));
	}
	
	@Test
	public void testState() {
		newSchool.setState("newState");
		assertTrue("State was set", newSchool.getState().equals("newState"));
	}
	
	@Test
	public void testLocation() {
		newSchool.setLocation("newLocation");
		assertTrue("Location was set", newSchool.getLocation().equals("newLocation"));
	}
	
	@Test
	public void testControl() {
		newSchool.setControl("newControl");
		assertTrue("Control was set", newSchool.getControl().equals("newControl"));
	}
	
	@Test
	public void testNumStudents() {
		newSchool.setNumStudents(10000);
		assertTrue("NumStudents was set", newSchool.getNumStudents() == 10000);
	}
	
	@Test
	public void testpercentFemale() {
		newSchool.setPercentFemale(0.6);
		assertTrue("PercentFemale was set", newSchool.getPercentFemale() == 0.6);
	}
	
	@Test
	public void testVerbalSAT() {
		newSchool.setVerbalSAT(550);
		assertTrue("VerbalSAT was set", newSchool.getVerbalSAT() == 550);
	}
	
	@Test
	public void testMathSAT() {
		newSchool.setMathSAT(550);
		assertTrue("MathSAT was set", newSchool.getMathSAT() == 550);
	}
	
	@Test
	public void testExpense() {
		newSchool.setExpense(10000);
		assertTrue("Expense was set", newSchool.getExpense() == 10000);
	}
	
	@Test
	public void testPercentFinAid() {
		newSchool.setPercentFinAid(0.1);
		assertTrue("PercentFinAid was set", newSchool.getPercentFinAid() == 0.1);
	}
	
	@Test
	public void testNumApplicants() {
		newSchool.setNumApplicants(10000);
		assertTrue("NumApplicants was set", newSchool.getNumApplicants() == 10000);
	}
	
	@Test
	public void testPercentAdmit() {
		newSchool.setPercentAdmit(0.8);
		assertTrue("PercentAdmit was set", newSchool.getPercentAdmit() == 0.8);
	}
	
	@Test
	public void testPercentEnroll() {
		newSchool.setPercentEnroll(0.8);
		assertTrue("PercentEnroll was set", newSchool.getPercentEnroll() == 0.8);
	}
	
	@Test
	public void testAcademicScale() {
		newSchool.setAcademicScale(2);
		assertTrue("AcademicScale was set", newSchool.getAcademicScale() == 2);
	}
	
	@Test
	public void testSocialScale() {
		newSchool.setSocialScale(2);
		assertTrue("SocialScale was set", newSchool.getSocialScale() == 2);
	}
	
	@Test
	public void testQualityLifeScale() {
		newSchool.setQualityLifeScale(2);
		assertTrue("QualityLifeScale was set", newSchool.getQualityLifeScale() == 2);
	}
	
	@Test
	public void testAreasOfStudy() {
		ArrayList<String> newEmphasis = null;
		newSchool.setAreasOfStudy(newEmphasis);
		assertTrue("AreasOfStudy was set", newSchool.getAreasOfStudy() == null);
	}
	
	

}
