package prls.patients;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents one visit by a patient to a provider. A visit record contains the
 * patient's ssn, the provider's NPI, and the date of the visit.
 * 
 */
public class Visit {
	
	//variable declaration
	private String patSSN;
	private String npi;
	private Date date;

	/**
	 * construct an empty Visit object
	 */
	public Visit() {
	}

	/**
	 * Construct a Visit object
	 * 
	 * @param patSSN
	 *            patient social security number
	 * @param npi
	 *            National Provider ID
	 * @param date
	 */
	public Visit(String patSSN, String npi, Date date) {
		super();
		this.patSSN = patSSN;
		this.npi = npi;
		this.date = date;
	}

	// getter and setter
	public String getPatSSN() {
		return patSSN;
	}

	public void setPatSSN(String patSSN) {
		this.patSSN = patSSN;
	}

	public String getNpi() {
		return npi;
	}

	public void setNpi(String npi) {
		this.npi = npi;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * This returns a string representing the visit record, formatted for text
	 * file output
	 */
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String dateStr = sdf.format(date);
		String ls = System.getProperty("line.separator");
		return (patSSN + "|" + npi + "|" + dateStr + ls);
	}
}
