package com.flightbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightbook.entity.AuthGroupEntity;

@Repository
public interface AuthGroupRepo extends JpaRepository<AuthGroupEntity, Long> {
	
}
