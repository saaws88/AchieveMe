package com.nekot.achieveme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nekot.achieveme.models.AchievemeUser;
import com.nekot.achieveme.services.UserService;

@Controller
@RequestMapping("/user")
public class RegistrationController {
 
  private UserService userService;

  @GetMapping("/signup")
  public String signup() {
    return "signup";
  }

  @PostMapping("/signup")
  public String createUser(AchievemeUser user, @RequestParam String matchingPassword, Model model) {
    if (!userService.createUser(user)) {
      model.addAttribute("errorMessage", "Пользователь с именем " + user.getUsername()+ " уже существует");
      return "registration";
    } else if (!user.getPassword().equals(matchingPassword)) {
      model.addAttribute("validationError", "Введенные пароли не совпадают");
      return "registration";
    }
    return "redirect:/login";
  }

}
