package expense.tracker.backend.service;

import expense.tracker.backend.model.User;
import expense.tracker.backend.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthRepository authRepository;

    public void register(User user){

    }
}
