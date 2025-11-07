public class GeneralPractitioner extends HealthProfessional {
    private String clinicRoom;
    private boolean homeVisitAvailable;

    public GeneralPractitioner() {
        super();
        this.clinicRoom = "Unknown";
        this.homeVisitAvailable = false;
    }

    public GeneralPractitioner(int id, String name, String department, String clinicRoom, boolean homeVisitAvailable) {
        super(id, name, department);
        this.clinicRoom = clinicRoom;
        this.homeVisitAvailable = homeVisitAvailable;
    }

    @Override
    public void printDetails() {
        System.out.println("Type: General Practitioner");
        super.printDetails();
        System.out.println("  Clinic Room: " + clinicRoom);
        System.out.println("  Home Visit Available: " + (homeVisitAvailable ? "Yes" : "No"));
    }
}
