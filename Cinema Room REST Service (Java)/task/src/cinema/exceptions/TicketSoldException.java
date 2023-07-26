package cinema.exceptions;

public class TicketSoldException extends RuntimeException {
    public TicketSoldException(String message) {
        super(message);
    }
}
