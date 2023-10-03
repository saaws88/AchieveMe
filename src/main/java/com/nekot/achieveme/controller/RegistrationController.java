/*package com.nekot.achieveme.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import com.nekot.achieveme.models.AchievemeUserDTO;

public class RegistrationController {
  
  @GetMapping("/user/registration")
  public String showRegistrationForm(WebRequest request, Model model) {
    var userDto = new AchievemeUserDTO();
    model.addAttribute("user", userDto);
    return "registration";
  }
}*/
