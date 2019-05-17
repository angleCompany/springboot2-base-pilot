package com.rest.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.api.entity.User;

public interface UserJpaRepo extends JpaRepository<User, Integer> {
}
