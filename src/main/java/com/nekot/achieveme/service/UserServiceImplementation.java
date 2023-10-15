package com.nekot.achieveme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nekot.achieveme.models.AchievemeUser;
import com.nekot.achieveme.models.Role;
import com.nekot.achieveme.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

  @Autowired
  private UserRepository repo;
  @Autowired
  private BCryptPasswordEncoder encoder;
  
  @Override
  public boolean createUser(AchievemeUser user) {
    String username = user.getUsername();
    
    if (repo.findByUsername(username).isPresent()) return false; 

    user.setUsername(username);
    user.setPassword(encoder.encode(user.getPassword()));
    user.setEmail(user.getEmail());
    user.getRoles().add(Role.USER);
    
    repo.save(user);
    return true;
  }

}
