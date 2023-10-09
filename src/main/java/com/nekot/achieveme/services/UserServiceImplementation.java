package com.nekot.achieveme.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nekot.achieveme.models.AchievemeUser;
import com.nekot.achieveme.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

  private UserRepository repo;
  private BCryptPasswordEncoder encoder;
  
  public boolean createUser(AchievemeUser user) {

    String username = user.getUsername();
    if (repo.findByUsername(username).isPresent()) return false; 
    user.setUsername(user.getUsername());
    user.setPassword(encoder.encode(user.getPassword()));
    user.setEmail(user.getEmail());
    
    repo.save(user);
    return true;
  }
  


}
