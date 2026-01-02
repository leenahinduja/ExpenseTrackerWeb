package expense.tracker.backend.exception;

public class UsernameAlreadyExist extends RuntimeException{
    public UsernameAlreadyExist(){
        super("Username Already Exists");
    }
}
