package expense.tracker.backend.controller;

import expense.tracker.backend.exception.EmailAlreadyExist;
import expense.tracker.backend.exception.InvalidEmail;
import expense.tracker.backend.exception.UsernameAlreadyExist;
import expense.tracker.backend.model.User;
import expense.tracker.backend.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    AuthService authService;
    private static Logger logger= LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody User user){
        Map<String,String>response= new HashMap<>();

        try {
            authService.register(user);
            response.put("message", "Inserted Successfully");
            return ResponseEntity.ok().body(response);
        }
        catch (InvalidEmail e) {
            logger.error("Invalid email provided: {}", user.getEmail());
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);

        } catch (EmailAlreadyExist e) {
            logger.error("Email already exists: {}", user.getEmail());
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);

        } catch (UsernameAlreadyExist e) {
            logger.error("Username already exists: {}", user.getUsername());
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);

        } catch (Exception e) {
            logger.error("Unexpected error during registration", e);
            response.put("error", "Some error occurred");
            return ResponseEntity.internalServerError().body(response);
        }
    }

}
