class Patient {
    // Static variable shared by all patients
    static String hospitalName = "Sunrise Hospital";
    static int totalPatients = 0;

    // Instance variables
    private String name;
    private int age;
    private String ailment;
    private final int patientID; // Final: unique and cannot be changed

    // Constructor using 'this' keyword
    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++; // Increase count on every new patient
    }

    // Static method to return total number of patients
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Method to display patient details
    public void displayDetails() {
        System.out.println("Hospital Name : " + hospitalName);
        System.out.println("Patient ID    : " + patientID);
        System.out.println("Name          : " + name);
        System.out.println("Age           : " + age);
        System.out.println("Ailment       : " + ailment);
    }

    // Main method to test the class
    public static void main(String[] args) {
        Patient p1 = new Patient(201, "Ruchi Kumari", 22, "Fever");
        Patient p2 = new Patient(202, "Amit Verma", 28, "Back Pain");

        // Check type before displaying details
        if (p1 instanceof Patient) {
            System.out.println("\nPatient 1 Details:");
            p1.displayDetails();
        }

        if (p2 instanceof Patient) {
            System.out.println("\nPatient 2 Details:");
            p2.displayDetails();
        }

        // Display total patients
        System.out.println();
        Patient.getTotalPatients();
    }
}
