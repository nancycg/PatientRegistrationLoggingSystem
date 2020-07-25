package prls.patients;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoctorListTest {
    DoctorList doctors;
    
	@Before
	public void setUp() throws Exception {
		doctors = new DoctorList();
		doctors.add(new Doctor("Sam", "Smith", "333", "pediatrics"));
		doctors.add(new Doctor("Marla", "Lee", "555","allergist"));
	}

	@Test
	public void testAdd() {
		Doctor doc = new Doctor("Josie","Trudeau","899","pediatrics");
		doctors.add(doc);
		Doctor retDoc = doctors.findByNPI("899");
		assertEquals(doc, retDoc);
	}

	@Test
	public void testFindByNPI() {
		Doctor retDoc = doctors.findByNPI("333");
		assertEquals("Sam",retDoc.getFname());
		assertEquals("Smith",retDoc.getLname());
		assertEquals("333",retDoc.getNpi());
		assertEquals("pediatrics",retDoc.getSpecialty());
	}

	@Test
	public void testToString() {
		String ls = System.getProperty("line.separator");
		String testString = "Sam|Smith|333|pediatrics" + ls + "Marla|Lee|555|allergist" + ls;
		assertEquals(testString, doctors.toString());
	}

}
