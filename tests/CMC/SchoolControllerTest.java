package CMC;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import CMC.SchoolController;

public class SchoolControllerTest {
	private SchoolController sc = new SchoolController();
	private ArrayList<String> myEmphasis = new ArrayList<String>();
	private School testSchool;
	private DBController dbController;

	@Before
	public void setUp() throws Exception {
		testSchool = new School("SCHOOLNAME", "SCHOOLSTATE", "STATELOCATION", "STATECONTROLLER", 1000, .5, 720, 790,
				10000.1, .1, 2000, .25, .15, 5, 4, 3, myEmphasis); 

	}

	@Test
	public void testEditSchool() {
		ArrayList<String> newEmphasis = null;
		Boolean edit = sc.editSchool("SCHOOLNAME", "SCHOOLSTATE", "STATELOCATION", "STATECONTROLLER", 10, .5, 720, 790,
				10000.1, .1, 2000, .25, .15, 5, 4, 3, newEmphasis);
		assertTrue("Numstudents is edited", edit);

	}

	@Test
	public void testCreateSchool() {
		sc.createSchool("SCHOOLNAME", "SCHOOLSTATE", "STATELOCATION", "STATECONTROLLER", 1000,
				.5, 720, 790, 10000.1, .1, 2000, .25, .15, 5, 4, 3, myEmphasis );
		School newSchool = new School("SCHOOLNAME", "SCHOOLSTATE", "STATELOCATION", "STATECONTROLLER", 1000,
				.5, 720, 790, 10000.1, .1, 2000, .25, .15, 5, 4, 3, myEmphasis );
		assertTrue("School should be in the System", newSchool.equals(testSchool));
	}

}