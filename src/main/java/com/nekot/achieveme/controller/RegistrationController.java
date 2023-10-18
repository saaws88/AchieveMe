package com.nekot.achieveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nekot.achieveme.exception.UserAlreadyExistsException;
import com.nekot.achieveme.models.AchievemeUser;
import com.nekot.achieveme.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class RegistrationController {
 
  @Autowired
  private UserService userService;

  @GetMapping("/signup")
  public String showRegistrationForm(Model model) {
    model.addAttribute("user", new AchievemeUser());
    return "signup";
  }

  @PostMapping("/signup")
  public String signupUser(@Valid AchievemeUser user, BindingResult bindingResult, Model model) throws UserAlreadyExistsException {  
    
    if(bindingResult.hasErrors()) {
      model.addAttribute("user", user);
      return "/signup";
    }

    userService.createUser(user);
    
    return "redirect:/login";

  }
  


}
