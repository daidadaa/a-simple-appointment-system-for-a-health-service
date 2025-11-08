
public class OtherProfessional extends HealthProfessional {
    private String specialty;

    public OtherProfessional() {
        super();
        this.specialty = "Specialty";
    }

    public OtherProfessional(int id, String name, String department, String specialty) {
        super(id, name, department);
        this.specialty = specialty;
    }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    @Override
    public void printDetails() {
        System.out.println("Type: " + specialty);
        super.printDetails();
        System.out.println("  Specialty: " + specialty);
    }
}
