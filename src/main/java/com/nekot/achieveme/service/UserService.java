package com.nekot.achieveme.service;

import org.springframework.stereotype.Service;

import com.nekot.achieveme.models.AchievemeUser;

@Service
public interface UserService {
 
  public boolean createUser(AchievemeUser user);

}
