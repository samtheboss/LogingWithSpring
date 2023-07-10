package com.smartapps.loginwithspring.Controllers;

import com.smartapps.loginwithspring.entity.Login;
import com.smartapps.loginwithspring.entity.User;
import com.smartapps.loginwithspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class LoginController {
  @Autowired UserService userService;

  @PostMapping("/user/login")
  public ResponseEntity authenticateUser(@RequestBody Login login) {
    List<String> userEmail = userService.checkUserEmail(login.getEmail());
    if (userEmail.isEmpty()) {
      return new ResponseEntity("Email does not Exist", HttpStatus.NOT_FOUND);
    }
    String getPasswordFromDb = userService.checkUserPasswordByEmail(login.getEmail());
      System.out.println(login.getPassword());
    System.out.println(getPasswordFromDb);

    if (!BCrypt.checkpw(login.getPassword(), getPasswordFromDb)) {

      return new ResponseEntity("Incorrect Email or password", HttpStatus.BAD_REQUEST);
    }
    User user = userService.getUserDetailsByEmail(login.getEmail());
    return new ResponseEntity(user, HttpStatus.OK);
  }

}
