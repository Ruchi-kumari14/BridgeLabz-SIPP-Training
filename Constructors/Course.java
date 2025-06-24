public class Course {
    String courseName;
    int duration; // in months
    double fee;
    static String instituteName = "Default Institute"; // Class variable

    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + " months, Fee: ₹" + fee);
        System.out.println("Institute: " + instituteName);
    }

    // Class method
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {
        Course.updateInstituteName("BridgeLabz Academy");

        Course c1 = new Course("Java", 3, 15000);
        Course c2 = new Course("Python", 2, 12000);

        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
