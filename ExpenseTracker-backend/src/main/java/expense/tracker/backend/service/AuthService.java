package expense.tracker.backend.service;

import expense.tracker.backend.exception.EmailAlreadyExist;
import expense.tracker.backend.exception.InvalidEmail;
import expense.tracker.backend.exception.UsernameAlreadyExist;
import expense.tracker.backend.model.User;
import expense.tracker.backend.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthService {

    @Autowired
    AuthRepository authRepository;
    public void register(User user) throws InvalidEmail {

        if (!checkIfEmailValid(user.getEmail())) {
            throw new InvalidEmail();
        }

        if (authRepository.Emailexists(user.getEmail())) {
            throw new EmailAlreadyExist();
        }

        if (authRepository.Usernameexists(user.getUsername())) {
            throw new UsernameAlreadyExist();
        }
        authRepository.register(
                user.getName(),
                user.getEmail(),
                user.getUsername(),
                user.getPassword(),
                user.getPhone(),
                user.getActive_yn()
        );
    }

    public boolean checkIfEmailValid(String email){
        if(email==null)  return false;

        String REGEX ="[A-Za-z0-9_+.-]+@[A-Za-z0-9_+.-]+\\.[a-z]{2,}$";

        Pattern pattern= Pattern.compile(REGEX);

        Matcher matcher= pattern.matcher(email);
        return matcher.matches();
    }
}
