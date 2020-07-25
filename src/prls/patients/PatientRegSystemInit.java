package prls.patients;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.util.logging.*;

/**
 * The patient registration system allows a user to both display and enter
 * information about patients, doctors, and appointments. Information about new
 * patients can be entered, as well as information about new doctors and visits.
 * Appointments can be displayed by doctor, by patient, and by date This
 * component initializes the patient information system by reading in from input
 * files. At the end of a session, all in-memory information is written back to
 * the files, ensuring that any new information entered is made persistent. A
 * menu allows users to select different actions.
 * 
 */
public class PatientRegSystemInit {
	
	//variable for file names.
	public static final String PAT_FILE_LOC = "patients.txt";
	public static final String VISIT_FILE_LOC = "visits.txt";
	public static final String DOC_FILE_LOC = "doctors.txt";

	//logger instance
	static Logger logger = Logger.getLogger(PatientRegSystemInit.class.getName());

	//Program execution starts form here.
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("logging.properties");
			LogManager.getLogManager().readConfiguration(fis);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error while reading the logging configuration file.");
		}

		PatientRegSystem regSystem = new PatientRegSystem();
		logger.log(Level.FINE, "Created patient registry system.");

		loadPatients(regSystem);
		logger.log(Level.FINE, "Read patient information from patient file.");

		loadDoctors(regSystem);
		logger.log(Level.FINE, "Read doctor information from doctor file.");

		loadVisits(regSystem);
		logger.log(Level.FINE, "Read visit information from visit file.");

		Menu menu = new Menu(regSystem);
		menu.go();
		logger.log(Level.FINE, "Menu displayed.");

		writePatients(regSystem);
		writeDoctors(regSystem);
		writeVisits(regSystem);
	}

	/**
	 *  Write all visits in the system out to the visit file
	 * @param regSystem
	 */
	private static void writeVisits(PatientRegSystem regSystem) {
		String outString = regSystem.getPatientListRecord();
		FileWriter outFile = null;
		try {
			outFile = new FileWriter(new File(PAT_FILE_LOC));
			logger.log(Level.INFO, "writing " + outString);
			outFile.write(outString);
			logger.log(Level.FINE, "Write successfully all the visits in the system out to the visit file.");
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error writing to visit file", e);
		} finally {
			try {
				if (outFile != null)
					outFile.close();
			} catch (IOException e) {
				logger.log(Level.SEVERE, "Error while closing the out stream for visit.", e);
			}
		}
	}

	/**
	 * Write all doctors in the system out to the doctor file
	 * @param regSystem
	 */
	private static void writeDoctors(PatientRegSystem regSystem) {
		String outString = regSystem.getDoctorListRecord();
		FileWriter outFile = null;
		try {
			outFile = new FileWriter(new File(DOC_FILE_LOC));
			logger.log(Level.INFO, "writing " + outString);
			outFile.write(outString);
			logger.log(Level.FINE, "Write successfully all doctors in the system out to the doctor file.");
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error writing to doctors file", e);
		} finally {
			try {
				if (outFile != null)
					outFile.close();
			} catch (IOException e) {
				logger.log(Level.SEVERE, "Error while closing the out stream for doctor.", e);
			}
		}
	}

	/**
	 * write all patients in the system out to the patient file
	 * @param regSystem
	 */
	private static void writePatients(PatientRegSystem regSystem) {
		String outString = regSystem.getVisitListRecord();
		FileWriter outFile = null;
		try {
			outFile = new FileWriter(new File(VISIT_FILE_LOC));
			logger.log(Level.INFO, "writing " + outString);
			outFile.write(outString);
			logger.log(Level.FINE, "Write successfully all patients in the system out to the patient file.");
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error writing to patient file.", e);
		} finally {
			try {
				if (outFile != null)
					outFile.close();
			} catch (IOException e) {
				logger.log(Level.SEVERE, "Error while closing the out stream for patient.", e);
			}
		}

	}

	/**
	 *  read visit information from the visit file
	 * @param regSystem
	 */
	private static void loadVisits(PatientRegSystem regSystem) {
		Scanner fileIn = null;
		try {
			fileIn = new Scanner(new File(VISIT_FILE_LOC));
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			while (fileIn.hasNextLine()) {
				Visit visit = new Visit();

				String line = fileIn.nextLine();

				StringTokenizer tokenizer = new StringTokenizer(line, "|");

				visit.setPatSSN(tokenizer.nextToken());
				visit.setNpi(tokenizer.nextToken());
				visit.setDate(sdf.parse(tokenizer.nextToken()));
				regSystem.addVisit(visit);
			}
			logger.log(Level.FINE, "Read visit file successfully.");
		} catch (ParseException p) {
			logger.log(Level.SEVERE, "Wrongly formed date.", p);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error reading from visit file", e);
		} finally {
			if (fileIn != null)
				fileIn.close();
			logger.log(Level.FINE, "Visit Input stream closed.");

		}

	}

	/**
	 *  read doctor information from the doctor file
	 * @param regSystem
	 */
	private static void loadDoctors(PatientRegSystem regSystem) {
		Scanner fileIn = null;
		try {
			fileIn = new Scanner(new File(DOC_FILE_LOC));

			while (fileIn.hasNextLine()) {
				Doctor doc = new Doctor();

				String line = fileIn.nextLine();

				StringTokenizer tokenizer = new StringTokenizer(line, "|");
				doc.setFname(tokenizer.nextToken());
				doc.setLname(tokenizer.nextToken());
				doc.setNpi(tokenizer.nextToken());
				doc.setSpecialty(tokenizer.nextToken());

				regSystem.addDoctor(doc);
			}
			logger.log(Level.FINE, "Read doctor information successfully.");
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error reading from doctors file", e);
		} finally {
			if (fileIn != null)
				fileIn.close();
			logger.log(Level.FINE, "Doctor Input stream closed.");
		}
	}

	/**
	 *  read patient information from the patient file
	 * @param regSystem
	 */
	private static void loadPatients(PatientRegSystem regSystem) {
		Scanner fileIn = null;
		try {
			fileIn = new Scanner(new File(PAT_FILE_LOC));

			while (fileIn.hasNextLine()) {
				Patient pat = new Patient();

				String line = fileIn.nextLine();

				StringTokenizer tokenizer = new StringTokenizer(line, "|");
				pat.setFname(tokenizer.nextToken());
				pat.setLname(tokenizer.nextToken());
				pat.setSsn(tokenizer.nextToken());
				pat.setCity(tokenizer.nextToken());
				pat.setState(tokenizer.nextToken());

				regSystem.addPatient(pat);
			}
			logger.log(Level.FINE, "Read patient file successfully.");
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error reading from patients file", e);
		} finally {
			if (fileIn != null)
				fileIn.close();
			logger.log(Level.FINE, "patient Input stream closed.");
		}
	}
}
