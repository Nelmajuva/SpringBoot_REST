package coop.confiar.utilities.exceptions;

public class EntityNoExistsException extends RuntimeException {
    public EntityNoExistsException(String message) {
        super(message);
    }
}
