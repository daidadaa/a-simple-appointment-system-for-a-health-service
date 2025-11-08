import java.util.ArrayList;
import java.util.Iterator;

public class AppointmentManager {
    private ArrayList<Appointment> appointments;

    public AppointmentManager() {
        appointments = new ArrayList<>();
    }

    public boolean createAppointment(String patientName, String mobile, String timeSlot, HealthProfessional doctor) {
        // basic validation
        if (patientName == null || patientName.trim().isEmpty()) {
            System.out.println("Error: patient name required.");
            return false;
        }
        if (!Appointment.isValidMobile(mobile)) {
            System.out.println("Error: invalid mobile (8-12 digits required).");
            return false;
        }
        if (!Appointment.isValidTime(timeSlot)) {
            System.out.println("Error: invalid time (HH:mm required).");
            return false;
        }
        if (doctor == null) {
            System.out.println("Error: doctor required.");
            return false;
        }

        // conflict check: same doctor id & same time
        for (Appointment a : appointments) {
            if (a.getDoctor().getId() == doctor.getId() && a.getTimeSlot().equals(timeSlot)) {
                System.out.println("Error: conflict - doctor already booked at " + timeSlot);
                return false;
            }
            // prevent same mobile same time
            if (a.getMobile().equals(mobile) && a.getTimeSlot().equals(timeSlot)) {
                System.out.println("Error: this mobile already has an appointment at " + timeSlot);
                return false;
            }
        }

        appointments.add(new Appointment(patientName, mobile, timeSlot, doctor));
        System.out.println("Appointment created for " + patientName + " at " + timeSlot);
        return true;
    }

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
