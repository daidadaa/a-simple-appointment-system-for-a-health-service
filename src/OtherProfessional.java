/**
 * Represents other types of health professionals (specialists).
 * Extends HealthProfessional and adds specialty.
 */
public class OtherProfessional extends HealthProfessional {
    private String specialty;

    /** Default constructor */
    public OtherProfessional() {
        super();
        this.specialty = "Specialty";
    }

    /** Parameterized constructor */
    public OtherProfessional(int id, String name, String department, String specialty) {
        super(id, name, department);
        this.specialty = specialty != null ? specialty : "Specialty";
    }

    /** Getters and setters */
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    /** Print specialist details */
    @Override
    public void printDetails() {
        System.out.println("Type: " + (specialty != null ? specialty : "Other Professional"));
        super.printDetails();
        System.out.println("  Specialty: " + specialty);
    }

    /** Return type label */
    @Override
    public String getTypeLabel() {
        return specialty != null ? specialty : "Other Professional";
    }
}
