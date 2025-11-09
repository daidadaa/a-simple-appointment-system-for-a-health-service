/**
 * Thrown when an appointment has invalid data
 */
public class InvalidAppointmentException extends Exception {
    public InvalidAppointmentException(String message) {
        super(message);
    }
}
