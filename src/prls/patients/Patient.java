package prls.patients;

/**
 * Represents one patient. A patient record contains first and last name, social
 * security number, and the patient's city and state
 * 
 */
public class Patient {
	//variable declaration.
	private String fname;
	private String lname;
	private String ssn;
	private String city;
	private String state;

	/**
	 * construct an empty patient record
	 */
	public Patient() {
	}

	/**
	 * construct a patient record
	 * 
	 * @param fname
	 *            first name
	 * @param lname
	 *            last name
	 * @param ssn
	 *            social security number
	 * @param city
	 * @param state
	 */
	public Patient(String fname, String lname, String ssn, String city, String state) {
		this.fname = fname;
		this.lname = lname;
		this.ssn = ssn;
		this.city = city;
		this.state = state;
	}

	// getter and setter
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * This returns a string representing the patient record, formatted for text
	 * file output.
	 */
	public String toString() {
		String ls = System.getProperty("line.separator");
		return fname + "|" + lname + "|" + ssn + "|" + city + "|" + state + ls;
	}
}
