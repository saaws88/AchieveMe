package com.nekot.achieveme.service;

import org.springframework.stereotype.Service;

import com.nekot.achieveme.exception.UserAlreadyExistsException;
import com.nekot.achieveme.models.AchievemeUser;

@Service
public interface UserService {
 
  public void createUser(AchievemeUser user) throws UserAlreadyExistsException;

}
