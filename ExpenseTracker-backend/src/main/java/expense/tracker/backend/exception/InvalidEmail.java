package expense.tracker.backend.exception;

public class InvalidEmail extends RuntimeException{
    public InvalidEmail(){
        super("Invalid Email");
    }
}
