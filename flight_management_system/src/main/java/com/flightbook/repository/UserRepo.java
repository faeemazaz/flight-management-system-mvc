package com.flightbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbook.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
	UserEntity findByUserName(String userName);
}
