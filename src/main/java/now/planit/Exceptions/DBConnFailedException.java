package now.planit.Exceptions;

public class DBConnFailedException extends RuntimeException {

    public DBConnFailedException(String DBConnFailMessage) {
        super(DBConnFailMessage);
    }


}
