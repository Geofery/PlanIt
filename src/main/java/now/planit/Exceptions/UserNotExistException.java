package now.planit.Exceptions;

public class UserNotExistException extends Throwable {

    public UserNotExistException(String message) {
        super(message);
    }
}
