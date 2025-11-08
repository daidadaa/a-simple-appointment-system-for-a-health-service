import java.util.ArrayList;

public class AppointmentManager {
    private ArrayList<Appointment> appointments = new ArrayList<>();

    public void createAppointment(Appointment a) {
        appointments.add(a);
        System.out.println("Created appointment for " + a.getMobile());
    }

    public void printExistingAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments");
        } else {
            for (Appointment a : appointments) a.printDetails();
        }
    }

    public void cancelBooking(String mobile) {
        Appointment found = null;
        for (Appointment a : appointments) {
            if (a.getMobile().equals(mobile)) {
                found = a;
                break;
            }
        }
        if (found != null) {
            appointments.remove(found);
            System.out.println("Cancelled appointment: " + mobile);
        } else {
            System.out.println("No appointment found for: " + mobile);
        }
    }
}
