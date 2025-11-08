
public class GeneralPractitioner extends HealthProfessional {
    private String clinicRoom;
    private boolean homeVisit;

    public GeneralPractitioner() {
        super();
        this.clinicRoom = "Room 1";
        this.homeVisit = false;
    }

    public GeneralPractitioner(int id, String name, String department, String clinicRoom, boolean homeVisit) {
        super(id, name, department);
        this.clinicRoom = clinicRoom;
        this.homeVisit = homeVisit;
    }

    public String getClinicRoom() { return clinicRoom; }
    public void setClinicRoom(String clinicRoom) { this.clinicRoom = clinicRoom; }

    public boolean isHomeVisit() { return homeVisit; }
    public void setHomeVisit(boolean homeVisit) { this.homeVisit = homeVisit; }

    @Override
    public void printDetails() {
        System.out.println("Type: General Practitioner");
        super.printDetails();
        System.out.println("  Clinic Room: " + clinicRoom);
        System.out.println("  Home Visit: " + (homeVisit ? "Yes" : "No"));
    }
}
