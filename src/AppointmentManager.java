import java.util.ArrayList;
import java.util.Iterator;

/**
 * AppointmentManager class: manages a collection of appointments.
 * Supports creation, cancellation, and display of appointments.
 */
public class AppointmentManager {
    private ArrayList<Appointment> appointments;

    /** Constructor initializes empty appointments list */
    public AppointmentManager() {
        appointments = new ArrayList<>();
    }

    /**
     * Create an appointment if validation passes and no conflict exists.
     * @return true if appointment is successfully created, false otherwise
     */
    public boolean createAppointment(String patientName, String mobile, String timeSlot, HealthProfessional doctor) {
        // Basic input validation
        if (patientName == null || patientName.trim().isEmpty()) {
            System.out.println("Error: patient name required.");
            return false;
        }
        if (!Appointment.isValidMobile(mobile)) {
            System.out.println("Error: invalid mobile (8-12 digits required) for " + patientName);
            return false;
        }
        if (!Appointment.isValidTime(timeSlot)) {
            System.out.println("Error: invalid time format (HH:mm) for " + patientName);
            return false;
        }
        if (doctor == null) {
            System.out.println("Error: doctor required for " + patientName);
            return false;
        }

        // Conflict check: same doctor & time or same mobile & time
        for (Appointment a : appointments) {
            if (a.getDoctor().getId() == doctor.getId() && a.getTimeSlot().equals(timeSlot)) {
                System.out.println("Error: conflict - doctor already booked at " + timeSlot + " for " + patientName);
                return false;
            }
            if (a.getMobile().equals(mobile) && a.getTimeSlot().equals(timeSlot)) {
                System.out.println("Error: this mobile already has an appointment at " + timeSlot + " for " + patientName);
                return false;
            }
        }

        appointments.add(new Appointment(patientName, mobile, timeSlot, doctor));
        System.out.println("Appointment created for " + patientName + " at " + timeSlot
                + " with " + doctor.getName() + " (" + doctor.getClass().getSimpleName() + ")");
        return true;
    }

    /** Print all existing appointments */
    public void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No existing appointments.");
            return;
        }
        System.out.println("Existing appointments (" + appointments.size() + "):");
        for (Appointment a : appointments) {
            a.printDetails();
        }
    }

    /**
     * Cancel appointment by mobile number.
     * Removes first matching appointment.
     * @return true if appointment cancelled successfully
     */
    public boolean cancelBooking(String mobile) {
        if (mobile == null) return false;
        Iterator<Appointment> it = appointments.iterator();
        while (it.hasNext()) {
            Appointment a = it.next();
            if (a.getMobile().equals(mobile)) {
                it.remove();
                System.out.println("Cancelled appointment for mobile: " + mobile);
                return true;
            }
        }
        System.out.println("No appointment found for mobile: " + mobile);
        return false;
    }
}
