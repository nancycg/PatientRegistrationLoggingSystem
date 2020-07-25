package prls.patients;

/**
 * Represents one doctor. A doctor record contains first and last name, National
 * Provider ID (NPI), and the doctor's area of specialization
 *
 */
public class Doctor {
	//variable declaration
	private String fname;
	private String lname;
	private String npi;
	private String specialty;

	//construct an empty doctor record
	public Doctor() {
	}

	/**
	 * construct a doctor record
	 * 
	 * @param fname
	 *            first name
	 * @param lname
	 *            last name
	 * @param npi
	 *            National Provider ID
	 * @param specialty
	 *            doctor's specialty area
	 */
	public Doctor(String fname, String lname, String npi, String specialty) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.npi = npi;
		this.specialty = specialty;
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

	public String getNpi() {
		return npi;
	}

	public void setNpi(String npi) {
		this.npi = npi;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	/**
	 * This returns a string representing the doctor record, formatted for text
	 * file output
	 */
	public String toString() {
		String ls = System.getProperty("line.separator");
		return (fname + "|" + lname + "|" + npi + "|" + specialty + ls);
	}
}
