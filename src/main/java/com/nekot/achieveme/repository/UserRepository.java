package com.nekot.achieveme.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nekot.achieveme.models.AchievemeUser;

@Repository
public interface UserRepository extends JpaRepository<AchievemeUser, Long> {
  Optional<AchievemeUser> findByUsername(String username);
}
