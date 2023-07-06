package com.smartapps.loginwithspring.Controllers;

import com.smartapps.loginwithspring.entity.User;
import com.smartapps.loginwithspring.services.UserService;
import com.smartapps.loginwithspring.utills.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    @Autowired
    UserService userService;

    @PostMapping("/register-user")
    public ResponseEntity saveDepartment(@RequestBody User users) throws IllegalAccessException {
        User u = new User();

        if (!Utils.isAnyFieldEmpty(u))
            return new
                    ResponseEntity<>(" failed Check all Field",
                    HttpStatus.BAD_REQUEST);
        else
            userService.RegisterUser(users);

        return new ResponseEntity<>("user save successful", HttpStatus.OK);
    }

    @PostMapping("/user/register-user")
    public ResponseEntity saveNewUser(@RequestParam String fname,
                                      @RequestParam String lname,
                                      @RequestParam String email,
                                      @RequestParam String password) {
        if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || password.isEmpty()) {
            return new ResponseEntity<>("SomeField Are missing", HttpStatus.BAD_REQUEST);
        }
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        int result = userService.registerNewUSer(fname, lname, email, hashedPassword);
        if (result != 1) {
            return new ResponseEntity<>("Failed To save User", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Saved Successful", HttpStatus.OK);
    }
}
