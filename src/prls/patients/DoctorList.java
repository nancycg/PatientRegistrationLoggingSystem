package prls.patients;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A collection of doctors
 */
public class DoctorList {
	
	//Logger instance.
	static Logger logger = Logger.getLogger(PatientRegSystemInit.class.getName());
	//list for doctors
	private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	
	//adding doctors to the list
	public void add(Doctor dr) {
		doctors.add(dr);
		logger.log(Level.FINE, "Adding doctor to the list : " + dr.toString());
	}

	/**
	 * given a national provider id, return the doctor if he or she is in the
	 * collection.
	 * 
	 * @param npi
	 *            - National Provider ID
	 * @return return the associated doctor or null if not found
	 */
	public Doctor findByNPI(String npi) {
		//Looping around the doctor's list
		for (Doctor doc : doctors) {
			if (npi.equals(doc.getNpi())) {
				logger.log(Level.FINE, "Doctor record found with npi" + "[" + npi + "]: " + doc.toString());
				return doc;
			}
		}
		logger.log(Level.FINE, "Doctor not found with npi = " + npi);
		return null;
	}

	/**
	 * return a formatted string with doctor information
	 */
	public String toString() {
		String outStr = "";
		for (Doctor doc : doctors)
			outStr = outStr + doc.toString();
		return outStr;
	}
}
