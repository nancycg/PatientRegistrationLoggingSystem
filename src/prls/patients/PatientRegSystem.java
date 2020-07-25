package prls.patients;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This component is the main component of the patient information system It
 * manages the lists of doctors, patients, and visits
 *
 */
public class PatientRegSystem {
	//variable declaration.
	private PatientList patients = new PatientList();
	private DoctorList doctors = new DoctorList();
	private VisitList visits = new VisitList();

	//logger instance
	static Logger logger = Logger.getLogger(PatientRegSystemInit.class.getName());

	//Adding patient to patient list.
	public void addPatient(Patient pat) {
		patients.add(pat);
	}
	
	//Adding doctor to patient list.
	public void addDoctor(Doctor doc) {
		doctors.add(doc);
	}

	//Adding visit to patient list.
	public void addVisit(Visit visit) {
		visits.add(visit);
	}

	//searching for patient record with SSN
	public Patient findPatientBySSN(String ssn) {
		return patients.findBySSN(ssn);
	}

	//Searching for doctor record with NPI.
	public Doctor findDoctorByNPI(String npi) {
		return doctors.findByNPI(npi);
	}

	/**
	 * 
	 * @param date
	 * @return All the visits searched by date.
	 */
	public ArrayList<FullVisitInfo> getVisitsByDate(Date date) {
		ArrayList<Visit> retVisits = visits.findByDate(date);
		ArrayList<FullVisitInfo> fullVisits = new ArrayList<FullVisitInfo>();
		for (Visit visit : retVisits) {
			String patSSN = visit.getPatSSN();
			String npi = visit.getNpi();
			Patient pat = patients.findBySSN(patSSN);
			Doctor doc = doctors.findByNPI(npi);
			FullVisitInfo fullInfo = new FullVisitInfo(pat, doc, visit);
			fullVisits.add(fullInfo);
		}
		logger.log(Level.FINE, "Getting Visits by date [" + date + "] : " + fullVisits.toString());
		return fullVisits;
	}

	/**
	 * 
	 * @param npi
	 * @return All the visits searched by doctor npi
	 */
	public ArrayList<FullVisitInfo> getVisitsByDoctor(String npi) {

		ArrayList<Visit> retVisits = visits.findByNPI(npi);
		ArrayList<FullVisitInfo> fullVisits = new ArrayList<FullVisitInfo>();
		for (Visit visit : retVisits) {
			String patSSN = visit.getPatSSN();
			Patient pat = patients.findBySSN(patSSN);
			Doctor doc = doctors.findByNPI(npi);
			FullVisitInfo fullInfo = new FullVisitInfo(pat, doc, visit);
			fullVisits.add(fullInfo);
		}
		Collections.sort(fullVisits, new FullVisitInfoComparatorByPatLname());
		logger.log(Level.FINE, "Getting sorted visits by doctor with NPI [" + npi + "]: " + fullVisits.toString());
		return fullVisits;
	}

	/**
	 * 
	 * @param ssn
	 * @return All the visits searched by patient ssn.
	 */
	public ArrayList<FullVisitInfo> getVisitsByPatient(String ssn) {

		ArrayList<Visit> retVisits = visits.findBySSN(ssn);
		ArrayList<FullVisitInfo> fullVisits = new ArrayList<FullVisitInfo>();
		for (Visit visit : retVisits) {
			String npi = visit.getNpi();
			Patient pat = patients.findBySSN(ssn);
			Doctor doc = doctors.findByNPI(npi);
			FullVisitInfo fullInfo = new FullVisitInfo(pat, doc, visit);
			fullVisits.add(fullInfo);
		}
		Collections.sort(fullVisits, new FullVisitInfoComparatorByDocLname());
		logger.log(Level.FINE, "Getting sorted visits by patients with SSN [" + ssn + "]: " + fullVisits.toString());
		return fullVisits;
	}

	//getter for patient list
	public String getPatientListRecord() {
		return patients.toString();
	}

	//getter for doctor list
	public String getDoctorListRecord() {
		return doctors.toString();
	}

	//getter for visit list
	public String getVisitListRecord() {
		return visits.toString();
	}
}
