package prls.patients;

import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Compare two doctor's record by doctor's last name. 
 */
public class FullVisitInfoComparatorByDocLname implements Comparator<FullVisitInfo> {
	//logger instance
	static Logger logger = Logger.getLogger(PatientList.class.getName());

	public int compare(FullVisitInfo visit1, FullVisitInfo visit2) {
		logger.log(Level.FINE, "Comparing doctor by doctor last name : compare " + visit1.getDrLname() + " and "
				+ visit2.getDrLname());
		return visit1.getDrLname().compareTo(visit2.getDrLname());
	}

}
