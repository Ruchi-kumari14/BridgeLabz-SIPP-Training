// Interface for maintaining medical records
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract Patient class
abstract class Patient implements MedicalRecord {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;
    private StringBuilder medicalHistory;

    public Patient(int patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.medicalHistory = new StringBuilder();
    }

    // Getters
    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    // Encapsulated access to diagnosis
    protected String getMaskedDiagnosis() {
        return diagnosis != null ? diagnosis.substring(0, 1) + "***" : "N/A";
    }

    // Concrete method
    public void getPatientDetails() {
        System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age);
        System.out.println("Diagnosis: " + getMaskedDiagnosis());
    }

    // Interface methods
    public void addRecord(String record) {
        medicalHistory.append(record).append("\n");
    }

    public void viewRecords() {
        System.out.println("Medical History:");
        System.out.println(medicalHistory.length() > 0 ? medicalHistory : "No records available.");
    }

    // Abstract method
    public abstract double calculateBill();
}

// Subclass: InPatient
class InPatient extends Patient {
    private int daysAdmitted;
    private double roomChargePerDay;

    public InPatient(int id, String name, int age, String diagnosis, int days, double chargePerDay) {
        super(id, name, age, diagnosis);
        this.daysAdmitted = days;
        this.roomChargePerDay = chargePerDay;
    }

    public double calculateBill() {
        return daysAdmitted * roomChargePerDay + 1500; // base treatment cost
    }
}

// Subclass: OutPatient
class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(int id, String name, int age, String diagnosis, double fee) {
        super(id, name, age, diagnosis);
        this.consultationFee = fee;
    }

    public double calculateBill() {
        return consultationFee + 300; // includes registration fee
    }
}

// Main class
public class HospitalManagementSystem {
    public static void main(String[] args) {
        // Polymorphic patient list
        Patient[] patients = {
            new InPatient(201, "Alice", 45, "Diabetes", 5, 2000),
            new OutPatient(202, "Bob", 30, "Flu", 500)
        };

        // Add and display data
        for (Patient p : patients) {
            p.getPatientDetails();
            p.addRecord("Visited on 2024-07-01: Prescribed medication.");
            p.viewRecords();
            System.out.println("Total Bill: ₹" + p.calculateBill());
            System.out.println("-----------------------------");
        }
    }
}
