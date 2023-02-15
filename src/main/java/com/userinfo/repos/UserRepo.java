package com.userinfo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userinfo.entities.User;

public interface UserRepo extends JpaRepository<User, Long>{ 

}
