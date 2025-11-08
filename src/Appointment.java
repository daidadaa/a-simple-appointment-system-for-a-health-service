public class Appointment {
    private String patientName;
    private String mobile;
    private String timeSlot;
    private HealthProfessional professional;

    public Appointment() {}

    public Appointment(String patientName, String mobile, String timeSlot, HealthProfessional professional) {
        this.patientName = patientName;
        this.mobile = mobile;
        this.timeSlot = timeSlot;
        this.professional = professional;
    }

    public void printDetails() {
        System.out.println("=== Appointment ===");
        System.out.println("Patient: " + patientName);
        System.out.println("Mobile: " + mobile);
        System.out.println("Time: " + timeSlot);
        professional.printDetails();
        System.out.println("-------------------");
    }

    public String getMobile() { return mobile; }
}
