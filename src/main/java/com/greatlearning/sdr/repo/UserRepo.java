package com.greatlearning.sdr.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.sdr.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	// adding a find by username method
	Optional<User> findByUsername(String username);

}
