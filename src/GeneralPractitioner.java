/**
 * Represents a general practitioner (GP).
 * Extends HealthProfessional and adds clinic room & home visit info.
 */
public class GeneralPractitioner extends HealthProfessional {
    private String clinicRoom;
    private boolean homeVisit;

    /** Default constructor */
    public GeneralPractitioner() {
        super();
        this.clinicRoom = "Room 1";
        this.homeVisit = false;
    }

    /** Parameterized constructor */
    public GeneralPractitioner(int id, String name, String department, String clinicRoom, boolean homeVisit) {
        super(id, name, department);
        this.clinicRoom = clinicRoom != null ? clinicRoom : "Room 1";
        this.homeVisit = homeVisit;
    }

    /** Getters and setters */
    public String getClinicRoom() { return clinicRoom; }
    public void setClinicRoom(String clinicRoom) { this.clinicRoom = clinicRoom; }

    public boolean isHomeVisit() { return homeVisit; }
    public void setHomeVisit(boolean homeVisit) { this.homeVisit = homeVisit; }

    /** Print GP details */
    @Override
    public void printDetails() {
        System.out.println("Type: General Practitioner");
        super.printDetails();
        System.out.println("  Clinic Room: " + clinicRoom);
        System.out.println("  Home Visit: " + (homeVisit ? "Yes" : "No"));
    }

    /** Return type label */
    @Override
    public String getTypeLabel() {
        return "General Practitioner";
    }
}
