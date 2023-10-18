package com.nekot.achieveme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nekot.achieveme.exception.UserAlreadyExistsException;
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
  public void createUser(AchievemeUser user) throws UserAlreadyExistsException {
    
    String username = user.getUsername();
    
    if (repo.findByUsername(username).isPresent()) { 

      throw new UserAlreadyExistsException("User " + username + " already exists");
    
    } 

      user.setUsername(username);
      user.setPassword(encoder.encode(user.getPassword()));
      user.setEmail(user.getEmail());
      user.getRoles().add(Role.USER);
      
      repo.save(user);

  }

}
