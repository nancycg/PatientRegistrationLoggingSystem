package prls.patients;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoctorTest {
    Doctor testDoc;
	@Before
	public void setUp() throws Exception {
		testDoc = new Doctor("Sam", "Smith", "555", "cardiology");
	}

	@Test
	public void testGetFname() {
		assertEquals("Sam", testDoc.getFname());
	}

	@Test
	public void testSetFname() {
		testDoc.setFname("Jack");
		assertEquals("Jack", testDoc.getFname());
	}

	@Test
	public void testGetLname() {
		assertEquals("Smith", testDoc.getLname());
	}

	@Test
	public void testSetLname() {
		testDoc.setLname("Jackson");
		assertEquals("Jackson", testDoc.getLname());
	}

	@Test
	public void testGetNpi() {
		assertEquals("555", testDoc.getNpi());
	}

	@Test
	public void testSetNpi() {
		testDoc.setNpi("888");
		assertEquals("888", testDoc.getNpi());
	}

	@Test
	public void testGetSpecialty() {
		assertEquals("cardiology", testDoc.getSpecialty());
	}

	@Test
	public void testSetSpecialty() {
		testDoc.setSpecialty("internist");
		assertEquals("internist", testDoc.getSpecialty());
	}

	@Test
	public void testToString() {
		String ls = System.getProperty("line.separator");
		assertEquals("Sam|Smith|555|cardiology" + ls, testDoc.toString());
	}

}
