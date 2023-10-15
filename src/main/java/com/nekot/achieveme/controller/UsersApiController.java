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
    
    AchievemeUser n = new AchievemeUser();
    n.setUsername(username);
    n.setEmail(email);
    n.setPassword(encoder.encode("123"));
    n.getRoles().add(Role.USER);
    repo.save(n);
    return ("User " + n.getUsername() + " saved");
  }

  @GetMapping(path="/all") 
  public @ResponseBody Iterable<AchievemeUser> showAllUsers() {
    return repo.findAll();
  }
}
