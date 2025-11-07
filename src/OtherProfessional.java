public class OtherProfessional extends HealthProfessional {
    private String specialty;
    private String equipmentNotes;

    public OtherProfessional() {
        super();
        this.specialty = "Unknown";
        this.equipmentNotes = "None";
    }

    public OtherProfessional(int id, String name, String department, String specialty, String equipmentNotes) {
        super(id, name, department);
        this.specialty = specialty;
        this.equipmentNotes = equipmentNotes;
    }

    @Override
    public void printDetails() {
        System.out.println("Type: Other Health Professional");
        super.printDetails();
        System.out.println("  Specialty: " + specialty);
        System.out.println("  Equipment Notes: " + equipmentNotes);
    }
}
