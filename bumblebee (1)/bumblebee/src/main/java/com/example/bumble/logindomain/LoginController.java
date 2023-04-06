package com.example.bumble.logindomain;



import java.util.Objects;

import org.apache.commons.logging.LogFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.LindaSchool.Logindomain.login.Login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
@Autowired
    private LogFactoryService userService;
 
                                  
   
          
    public ModelAndView login() {
     ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Login());
        return mav;
    }
 
    @PostMapping("/login")
    public String login(@ModelAttribute("user") Login user ) {
    
     Login oauthUser = ((Object) userService).login(user.getUsername(), user.getPassword());
    
 
     System.out.print(oauthUser);
     if(Objects.nonNull(oauthUser))
     {
  
     return "redirect:/";
    
    
     } else {
     return "redirect:/login";
    
    
     }
 
}
    
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
    
  
        return "redirect:/login";
    }
 
}