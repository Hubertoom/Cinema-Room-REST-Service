package cinema.exceptions;

public class WrongTokenError extends RuntimeException {
    public WrongTokenError(String message) {
        super(message);
    }
}
