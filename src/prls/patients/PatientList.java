package prls.patients;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A collection of patients.
 */
public class PatientList {

	// logger instance
	static Logger logger = Logger.getLogger(PatientList.class.getName());

	// List for patients
	private ArrayList<Patient> patients = new ArrayList<Patient>();

	// adding patients to list.
	public void add(Patient pat) {
		patients.add(pat);
		logger.log(Level.FINE, "adding patient " + pat.toString());
	}

	/**
	 * Given a social security number, return the patient if he or she is in the
	 * collection.
	 * 
	 * @param ssn
	 * @return return the associated patient or null if not found
	 */
	public Patient findBySSN(String ssn) {
		//looping around the list of patients.
		for (Patient pat : patients) {
			if (ssn.equals(pat.getSsn())) {
				logger.log(Level.FINE, "Patient found with ssn [" + ssn + "] : " + pat.toString());
				return pat;
			}
		}
		logger.log(Level.FINE, "Patient not found with ssn :" + ssn);
		return null;
	}

	/**
	 * return a formatted string with patient information
	 */
	public String toString() {
		String outStr = "";
		for (Patient pat : patients)
			outStr = outStr + pat.toString();
		return outStr;
	}
}
