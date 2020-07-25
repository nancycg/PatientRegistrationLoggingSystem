package prls.patients;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A collection of visit records, showing visits by patients to doctors
 */
public class VisitList {
	
	//logger instance
	static Logger logger = Logger.getLogger(PatientList.class.getName());
	
	//list for visit records.
	private ArrayList<Visit> visitRecords = new ArrayList<Visit>();
	
	//Adding visits to list
	public void add(Visit visit) {
		visitRecords.add(visit);
		logger.log(Level.FINE, "adding visit " + visit.toString());
	}

	/**
	 * return a list of visits on a given date
	 */
	public ArrayList<Visit> findByDate(Date date) {
		ArrayList<Visit> visits = new ArrayList<Visit>();
		for (Visit visit : visitRecords) {
			if (date.equals(visit.getDate()))
				visits.add(visit);
		}
		logger.log(Level.FINE, "Found visit by date: " + visits.toString());
		return visits;
	}

	/**
	 * given a social security number and national provider id, return the first
	 * visit found in the collection
	 * 
	 * @return return the associated visit or null if not found
	 */
	public Visit find(String ssn, String npi) {
		for (Visit visit : visitRecords) {
			if (ssn.equals(visit.getPatSSN()) && npi.equals(visit.getNpi())) {
				logger.log(Level.FINE, "Found visits: " + visit.toString());
				return visit;
			}
		}
		logger.log(Level.FINE, "Visit not found.");
		return null;
	}

	/**
	 * given a social security number, return a list of visits for that patient.
	 * 
	 * @param ssn
	 * @return return a list of visits
	 */
	public ArrayList<Visit> findBySSN(String ssn) {
		ArrayList<Visit> visits = new ArrayList<Visit>();

		for (Visit visit : visitRecords) {
			if (ssn.equals(visit.getPatSSN())) {
				visits.add(visit);
			}
		}
		logger.log(Level.FINE, "Visits found by SSN " + "[" + ssn + "] : " + visits.toString());
		return visits;
	}

	/**
	 * given a national provider id, return a list of visits to that doctor
	 * 
	 * @param npi
	 * @return return a list of visits
	 */
	public ArrayList<Visit> findByNPI(String npi) {
		ArrayList<Visit> visits = new ArrayList<Visit>();

		for (Visit visit : visitRecords) {
			if (npi.equals(visit.getNpi())) {
				visits.add(visit);
			}
		}
		logger.log(Level.FINE, "Visits found by NPI [" + npi + "]: " + visits.toString());
		return visits;
	}

	/**
	 * return a formatted string with visit information
	 */
	public String toString() {
		String outStr = "";
		for (Visit visit : visitRecords)
			outStr = outStr + visit.toString();
		return outStr;
	}
}
