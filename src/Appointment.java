/**
 * Appointment class: represents a patient appointment with a doctor.
 * Holds patient info, appointment time, and associated HealthProfessional.
 */
public class Appointment {
    private String patientName;
    private String mobile;
    private String timeSlot;
    private HealthProfessional doctor;

    /** Default constructor with placeholder values */
    public Appointment() {
        this.patientName = "Unknown";
        this.mobile = "00000000";
        this.timeSlot = "00:00";
        this.doctor = new HealthProfessional();
    }

    /** Parameterized constructor */
    public Appointment(String patientName, String mobile, String timeSlot, HealthProfessional doctor) {
        this.patientName = patientName;
        this.mobile = mobile;
        this.timeSlot = timeSlot;
        this.doctor = doctor;
    }

    /** Getters */
    public String getPatientName() { return patientName; }
    public String getMobile() { return mobile; }
    public String getTimeSlot() { return timeSlot; }
    public HealthProfessional getDoctor() { return doctor; }

    /** Validate mobile: 8-12 digits */
    public static boolean isValidMobile(String m) {
        return m != null && m.matches("^\\d{8,12}$");
    }

    /** Validate time format HH:mm */
    public static boolean isValidTime(String t) {
        return t != null && t.matches("^([01]\\d|2[0-3]):[0-5]\\d$");
    }

    /** Print appointment details in a readable format */
    public void printDetails() {
        System.out.println("=== Appointment ===");
        System.out.println("Patient : " + patientName);
        System.out.println("Mobile  : " + mobile);
        System.out.println("Time    : " + timeSlot);
        System.out.println("Doctor  : " + doctor.getName() + " (" + doctor.getClass().getSimpleName() + ")");
        System.out.println("Doctor details:");
        doctor.printDetails();
        System.out.println("------------------------------");
    }
}
