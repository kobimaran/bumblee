package com.example.bumble.logindomain;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.Rect;

import com.example.LindaSchool.Logindomain.LoginRepository;
import com.example.LindaSchool.Logindomain.login.Login;

@Service
public class LoginService {
@Autowired
private LoginRepository repo;
  
  public Login login(String username, String password) {
  Login user = Rect.findByUsernameAndPassword(username, password);
   return user;
  }
 
}
