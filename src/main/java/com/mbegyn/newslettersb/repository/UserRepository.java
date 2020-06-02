package com.mbegyn.newslettersb.repository;

import com.mbegyn.newslettersb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// this interface extends the JpaRepository interface from Spring Data JPA.
// JpaRepository defines standard CRUD methods
public interface UserRepository extends JpaRepository<User, Integer> {
}
