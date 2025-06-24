class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

// Subclass
class PostgraduateStudent extends Student {
    public PostgraduateStudent(int rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }

    public void showDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name (protected): " + name);
        System.out.println("CGPA (via getter): " + getCGPA());
    }

    public static void main(String[] args) {
        PostgraduateStudent pg = new PostgraduateStudent(101, "Ruchi", 8.9);
        pg.showDetails();
        pg.setCGPA(9.2); // modify using setter
        System.out.println("Updated CGPA: " + pg.getCGPA());
    }
}
