package com.nekot.achieveme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nekot.achieveme.models.AchievemeUser;
import com.nekot.achieveme.models.Role;
import com.nekot.achieveme.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path="/api/v1/users")
public class UsersApiController {

  @Autowired
  private UserRepository repo;
  private BCryptPasswordEncoder encoder;

  @PostMapping(path="/add")
  public @ResponseBody String addNewUser 
  (@RequestParam String username,
  @RequestParam String email) {
    
    AchievemeUser user = new AchievemeUser();
    user.setUsername(username);
    user.setEmail(email);
    user.setPassword(encoder.encode("123"));
    user.getRoles().add(Role.USER);
    repo.save(user);
    return ("User " + user.getUsername() + " saved");
  }

  @GetMapping(path="/all") 
  public @ResponseBody Iterable<AchievemeUser> showAllUsers() {
    return repo.findAll();
  }
}
