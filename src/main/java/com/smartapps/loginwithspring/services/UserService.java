package com.smartapps.loginwithspring.services;

import com.smartapps.loginwithspring.entity.User;
import com.smartapps.loginwithspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired UserRepository userRepository;

  public void RegisterUser(User users) {
    String pass = BCrypt.hashpw(users.getPassword(), BCrypt.gensalt());
    users.setPassword(pass);
    userRepository.save(users);
  }

  public int registerNewUSer(String fname, String lname, String email, String password) {
    return userRepository.registerNewUser(fname, lname, email, password);
  }

  public List<String> checkUserEmail(String email){
    return userRepository.checkUserEmail(email);
  }
  // End Of Check User Email Services Method.

  public String checkUserPasswordByEmail(String email){
    return userRepository.checkUserPasswordByEmail(email);
  }
  // End Of Check User Password Services Method.

  public User getUserDetailsByEmail(String email){
    return userRepository.GetUserDetailsByEmail(email);
  }
}
