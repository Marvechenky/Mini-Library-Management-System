package com.marvis.mylibrary.data.repository;
import com.marvis.mylibrary.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailIgnoreCase(String email);

    Optional<User> findByFullName(String fullName);
}
