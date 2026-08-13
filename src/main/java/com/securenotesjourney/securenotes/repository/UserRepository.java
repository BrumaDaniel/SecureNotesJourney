package com.securenotesjourney.securenotes.repository;

import com.securenotesjourney.securenotes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}