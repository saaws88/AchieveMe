package com.nekot.achieveme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.nekot.achieveme.models.AchievemeUser;
import com.nekot.achieveme.services.UserService;

@Controller
public class RegistrationController {
 
  private UserService userService;

@GetMapping("/signup")
public String showRegistrationForm(Model model) {
  model.addAttribute("user", new AchievemeUser());
  return "signup";
}

@PostMapping("/signup")
public String createUser(@ModelAttribute AchievemeUser user, String matchingPassword, Model model) {
  model.addAttribute("user", user);
  model.addAttribute("matchingPassword", matchingPassword);
  if (!userService.createUser(user)) {
    model.addAttribute("errorMessage", "Пользователь с именем " + user.getUsername()+ " уже существует");
      return "signup";
    } else if (!user.getPassword().equals(matchingPassword)) {
      model.addAttribute("validationError", "Введенные пароли не совпадают");
      return "signup";
    }
    
    return "redirect:/login";
  }


}
