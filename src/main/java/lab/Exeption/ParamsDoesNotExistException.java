package lab.Exeption;

public class ParamsDoesNotExistException extends RuntimeException {

    public ParamsDoesNotExistException(String message) {
        super(message);
    }
}

