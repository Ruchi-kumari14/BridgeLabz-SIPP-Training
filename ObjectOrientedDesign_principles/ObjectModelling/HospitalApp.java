import java.util.*;

// Patient class
class Patient {
    String name;
    List<Doctor> doctors; // stores all doctors the patient has consulted

    public Patient(String name) {
        this.name = name;
        doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        if (!doctors.contains(doctor)) {
            doctors.add(doctor);
        }
    }

    public void displayDoctors() {
        System.out.println("\nDoctors consulted by patient " + name + ":");
        for (Doctor d : doctors) {
            System.out.println("- " + d.name);
        }
    }
}

// Doctor class
class Doctor {
    String name;
    List<Patient> patients; // stores all patients this doctor has seen

    public Doctor(String name) {
        this.name = name;
        patients = new ArrayList<>();
    }

    // Communication method
    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " is consulting patient " + patient.name);

        if (!patients.contains(patient)) {
            patients.add(patient);
        }
        patient.addDoctor(this); // maintain bidirectional link
    }

    public void displayPatients() {
        System.out.println("\nPatients seen by Dr. " + name + ":");
        for (Patient p : patients) {
            System.out.println("- " + p.name);
        }
    }
}

// Hospital class
class Hospital {
    String name;
    List<Doctor> doctors;
    List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void displayAll() {
        System.out.println("\nHospital: " + name);

        System.out.println("\nDoctors:");
        for (Doctor d : doctors) {
            System.out.println("- Dr. " + d.name);
        }

        System.out.println("\nPatients:");
        for (Patient p : patients) {
            System.out.println("- " + p.name);
        }
    }
}

public class HospitalApp {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Care Hospital");

        // Create doctors
        Doctor drKhan = new Doctor("Khan");
        Doctor drMehra = new Doctor("Mehra");

        // Create patients
        Patient alice = new Patient("Alice");
        Patient bob = new Patient("Bob");

        // Add to hospital
        hospital.addDoctor(drKhan);
        hospital.addDoctor(drMehra);
        hospital.addPatient(alice);
        hospital.addPatient(bob);

        // Perform consultations (communication + association)
        drKhan.consult(alice);
        drKhan.consult(bob);
        drMehra.consult(alice);

        // Display hospital records
        hospital.displayAll();

        // Display doctor-patient relationships
        drKhan.displayPatients();
        drMehra.displayPatients();

        alice.displayDoctors();
        bob.displayDoctors();
    }
}
