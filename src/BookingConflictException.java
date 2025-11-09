/**
 * Thrown when there is a booking conflict
 */
public class BookingConflictException extends Exception {
    public BookingConflictException(String message) {
        super(message);
    }
}
