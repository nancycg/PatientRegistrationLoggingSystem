package prls.patients;

import java.util.Date;

/**
 * Represents one visit with augmented information. The additional information
 * includes patient first and last name, patient SSN, patient city, patient
 * state, doctor's first and last name, doctor's NPI, the doctor's speciality,
 * and the date of the visit Objects of this class are created as needed from
 * the Visit, Patient, and Provider records.
 * 
 */
public class FullVisitInfo {
	//variable declaration
	private String patFname;
	private String patLname;
	private String patSSN;
	private String patCity;
	private String patState;
	private String drFname;
	private String drLname;
	private String drNPI;
	private String drSpecialty;
	private Date date;

	/**
	 * Create a FullVisit object from the information in a Patient object, a
	 * Doctor object, and a Visit object
	 * 
	 * @param pat
	 *            - a patient record
	 * @param doc
	 *            - a doctor record
	 * @param visit
	 *            - a visit record
	 */
	public FullVisitInfo(Patient pat, Doctor doc, Visit visit) {
		patFname = pat.getFname();
		patLname = pat.getLname();
		patSSN = pat.getSsn();
		patCity = pat.getCity();
		patState = pat.getState();
		drFname = doc.getFname();
		drLname = doc.getLname();
		drNPI = doc.getNpi();
		drSpecialty = doc.getSpecialty();
		date = visit.getDate();
	}

	// getter and setter
	public String getPatFname() {
		return patFname;
	}

	public void setPatFname(String patFname) {
		this.patFname = patFname;
	}

	public String getPatLName() {
		return patLname;
	}

	public void setPatLName(String patLName) {
		this.patLname = patLName;
	}

	public String getPatSSN() {
		return patSSN;
	}

	public void setPatSSN(String patSSN) {
		this.patSSN = patSSN;
	}

	public String getPatCity() {
		return patCity;
	}

	public void setPatCity(String patCity) {
		this.patCity = patCity;
	}

	public String getPatState() {
		return patState;
	}

	public void setPatState(String patState) {
		this.patState = patState;
	}

	public String getDrFname() {
		return drFname;
	}

	public void setDrFname(String drFname) {
		this.drFname = drFname;
	}

	public String getDrLname() {
		return drLname;
	}

	public void setDrLname(String drLname) {
		this.drLname = drLname;
	}

	public String getDrNPI() {
		return drNPI;
	}

	public void setDrNPI(String drNPI) {
		this.drNPI = drNPI;
	}

	public String getDrSpecialty() {
		return drSpecialty;
	}

	public void setDrSpecialty(String drSpecialty) {
		this.drSpecialty = drSpecialty;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * return a formatted string with visit information
	 */
	@Override
	public String toString() {
		String ls = System.getProperty("line.separator");
		return (patFname + "|" + patLname + "|" + patSSN + "|" + patCity + "|" + patState + "|" + drFname + "|"
				+ drLname + "|" + drNPI + "|" + drSpecialty + "|" + date + ls);
	}
}
