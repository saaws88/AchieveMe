package com.nekot.achieveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nekot.achieveme.models.AchievemeUser;
import com.nekot.achieveme.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class RegistrationController {
 
  @Autowired
  private UserService userService;

  @GetMapping("/signup")
  public String showRegistrationForm(Model model) {
    AchievemeUser user = new AchievemeUser();
    model.addAttribute("user", user);
    return "signup";
  }

  @PostMapping("/signup")
  public String createUser(@ModelAttribute("user") @Valid AchievemeUser user, BindingResult BindingResult, String matchingPassword, Model model) {
    
    model.addAttribute("user", user);

    if (!userService.createUser(user)) {
      model.addAttribute("errorMessage", "Пользователь с именем " + user.getUsername()+ " уже существует");
      return "signup";
    } else if (!user.getPassword().equals(matchingPassword)) {
      model.addAttribute("validationError", "Введенные пароли не совпадают");
      return "signup";
    }
    
    userService.createUser(user);
    return "redirect:/login";
  }


}
