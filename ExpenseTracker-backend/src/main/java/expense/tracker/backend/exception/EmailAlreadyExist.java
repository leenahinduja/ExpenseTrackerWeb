package expense.tracker.backend.exception;

public class EmailAlreadyExist extends RuntimeException{
    public EmailAlreadyExist(){
        super("Email Already Exists");
    }
}
