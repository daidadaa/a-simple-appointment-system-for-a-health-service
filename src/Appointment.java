
public class Appointment {
    private String patientName;
    private String mobile;
    private String timeSlot; // expect "HH:mm"
    private HealthProfessional doctor;

    public Appointment() {
        this.patientName = "Unknown";
        this.mobile = "00000000";
        this.timeSlot = "00:00";
        this.doctor = new HealthProfessional();
    }

    public Appointment(String patientName, String mobile, String timeSlot, HealthProfessional doctor) {
        this.patientName = patientName;
        this.mobile = mobile;
        this.timeSlot = timeSlot;
        this.doctor = doctor;
    }

    public String getPatientName() { return patientName; }
    public String getMobile() { return mobile; }
    public String getTimeSlot() { return timeSlot; }
    public HealthProfessional getDoctor() { return doctor; }

    // basic mobile check: digits only and length 8-12
    public static boolean isValidMobile(String m) {
        if (m == null) return false;
        return m.matches("^\\d{8,12}$");
    }

    // basic time check HH:mm (24-hour)
    public static boolean isValidTime(String t) {
        if (t == null) return false;
        return t.matches("^([01]\\d|2[0-3]):[0-5]\\d$");
    }

    public void printDetails() {
        System.out.println("Appointment:");
        System.out.println("  Patient: " + patientName);
        System.out.println("  Mobile : " + mobile);
        System.out.println("  Time   : " + timeSlot);
        System.out.println("  Doctor :");
        doctor.printDetails();
        System.out.println("------------------------------");
    }
}
