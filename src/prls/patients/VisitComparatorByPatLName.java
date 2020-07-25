package prls.patients;

import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Compare two visit's record by patient's last name. 
 */
class FullVisitInfoComparatorByPatLname implements Comparator<FullVisitInfo> {
	//logger instance
	static Logger logger = Logger.getLogger(PatientList.class.getName());
	
	public int compare(FullVisitInfo visit1, FullVisitInfo visit2) {
		logger.log(Level.FINE, "Comparing Visits by pat last name : compare " + visit1.getPatLName() + " and " + visit2.getPatLName());
		return visit1.getPatLName().compareTo(visit2.getPatLName());
	}
}