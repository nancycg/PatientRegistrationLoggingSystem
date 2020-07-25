package prls.patients;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple menu based user interface.
 * This allows users to enter commands which
 * are then handled by the patient registration system.
 *
 */
public class Menu {
	static Logger logger = Logger.getLogger(PatientRegSystemInit.class.getName());

	private Scanner in;
	private PatientRegSystem system;

	//constructor to initialize variables.
	public Menu(PatientRegSystem sys) {
		system = sys;
		in = new Scanner(System.in);
	}

	//Working menu options
	public void go() {
		String command = readCommand();
		while (!command.equals("Q")) {

			if (command.equals("AP")) {
				addPatient();
			}

			if (command.equals("AD")) {
				addDoctor();
			}

			if (command.equals("V")) {
				addVisit();
			}

			if (command.equals("LP")) {
				try {
					displayVisitListForPatient();
				} catch (ParseException e) {
					logger.log(Level.SEVERE, "Badly formed date - use mm/dd/yy", e);
				}
			}

			if (command.equals("LD")) {
				try {
					displayVisitListForDoctor();
				} catch (ParseException e) {
					logger.log(Level.SEVERE, "Badly formed date - use mm/dd/yy", e);
				}
			}

			if (command.equals("D")) {
				try {
					displayVisitListForDate();
				} catch (ParseException pe) {
					logger.log(Level.SEVERE, "Badly formed date - use mm/dd/yy", pe);
				}
			}
			command = readCommand();
		}
		logger.log(Level.INFO, "Bye, Have a nice day!");
	}

	/**
	 * Displaying the visit list by dates.
	 * @throws ParseException
	 */
	private void displayVisitListForDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Please enter the date in mm/dd/yy format");
		String dateStr = in.next();
		Date date = sdf.parse(dateStr);
		ArrayList<FullVisitInfo> visits = system.getVisitsByDate(date);
		if (visits.size() == 0)
			logger.log(Level.INFO, "There were no appointments on that date.");
		else {
			for (FullVisitInfo visit : visits) {
				dateStr = sdf.format(visit.getDate());
				System.out.println("Visit date: " + visit.getDate());
				System.out.println(
						"Patient: " + visit.getPatFname() + " " + visit.getPatLName() + " " + visit.getPatSSN());
				System.out.println(
						"Physician: " + visit.getDrFname() + " " + visit.getDrLname() + " " + visit.getDrSpecialty());
			}
		}
	}

	/**
	 * Displaying list of visits for doctor. 
	 * @throws ParseException
	 */
	private void displayVisitListForDoctor() throws ParseException {
		System.out.println("Please enter the doctor's NPI");
		String npi = in.next();

		ArrayList<FullVisitInfo> visits = system.getVisitsByDoctor(npi);

		if (visits.size() == 0)
			logger.log(Level.INFO, "That doctor has not seen any patients");
		else {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			for (FullVisitInfo visit : visits) {
				String dateStr = sdf.format(visit.getDate());
				System.out.println("Visit date: " + dateStr);
				System.out.println(
						"Patient: " + visit.getPatFname() + " " + visit.getPatLName() + " " + visit.getPatSSN());
				System.out.println(
						"Physician: " + visit.getDrFname() + " " + visit.getDrLname() + " " + visit.getDrSpecialty());
			}
		}
	}

	/**
	 * Displaying list of visits for patients. 
	 */
	private void displayVisitListForPatient()  throws ParseException {
		System.out.println("Please enter the patient's ssn");
		String ssn = in.next();

		ArrayList<FullVisitInfo> visits = system.getVisitsByPatient(ssn);
		if (visits.size() == 0)
			logger.log(Level.INFO, "That patient has not visited any of our providers");
		else {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			for (FullVisitInfo visit : visits) {

				String dateStr = sdf.format(visit.getDate());
				System.out.println("Visit date: " + dateStr);
				System.out.println(
						"Patient: " + visit.getPatFname() + " " + visit.getPatLName() + " " + visit.getPatSSN());
				System.out.println(
						"Physician: " + visit.getDrFname() + " " + visit.getDrLname() + " " + visit.getDrSpecialty());
			}
		}
	}

	/**
	 * Adding visit to Patient Registry System.
	 */
	private void addVisit() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Enter National Provider ID ");
		String npi = in.next();
		System.out.println("Enter patient ssn ");
		String ssn = in.next();
		System.out.println("Enter date of visit(mm/dd/yy) ");
		String dateStr = in.next();
		Date date;
		try {
			date = sdf.parse(dateStr);
			Visit visit = new Visit(ssn, npi, date);
			system.addVisit(visit);
			logger.log(Level.INFO, "Visit added.");
		} catch (ParseException e) {
			logger.log(Level.SEVERE, "Badly formed date - use mm/dd/yy", e);
		}

	}

	/**
	 * Adding doctor to Patient Registry System.
	 */
	private void addDoctor() {
		System.out.println("Enter first name ");
		String fname = in.next();
		System.out.println("Enter last name ");
		String lname = in.next();
		System.out.println("Enter National Provider ID ");
		String npi = in.next();
		System.out.println("Enter specialty ");
		String specialty = in.next();
		Doctor doc = new Doctor(fname, lname, npi, specialty);

		if (system.findDoctorByNPI(npi) == null) {
			system.addDoctor(doc);
			logger.log(Level.INFO, "Doctor added.");
		} else
			logger.log(Level.INFO, "Doctor is already in the system");
	}

	/**
	 * Adding patient to Patient Registry System.
	 */
	private void addPatient() {
		System.out.println("Enter first name ");
		String fname = in.next();
		System.out.println("Enter last name ");
		String lname = in.next();
		System.out.println("Enter social security number ");
		String ssn = in.next();
		System.out.println("Enter city ");
		String city = in.next();
		System.out.println("Enter state ");
		String state = in.next();
		Patient pat = new Patient(fname, lname, ssn, city, state);

		if (system.findPatientBySSN(ssn) == null) {
			system.addPatient(pat);
			logger.log(Level.INFO, "Patient added successfully.");
		} else
			logger.log(Level.INFO, "Patient is already in the system.");
	}

	//All menu options displayed to user
	private String readCommand() {
		System.out.println("Please enter a command");
		System.out.println("AP: Add a patient");
		System.out.println("AD: Add a doctor");
		System.out.println("V: Record a visit");
		System.out.println("LP: List the visits for a given patient");
		System.out.println("LD: List the visits for a given doctor");
		System.out.println("D: List the visits on a given date");
		System.out.println("Q: quit");
		System.out.println(">>>>>>");
		String command = in.next().toUpperCase();
		return command;
	}
}
