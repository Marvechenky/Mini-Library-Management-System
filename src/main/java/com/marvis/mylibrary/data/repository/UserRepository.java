package com.marvis.mylibrary.data.repository;
import com.marvis.mylibrary.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailIgnoreCase(String email);

    User findByFullNameIgnoreCase(String fullName);
}
