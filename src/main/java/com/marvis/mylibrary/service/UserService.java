package com.marvis.mylibrary.service;

import com.marvis.mylibrary.data.dto.request.UserRequest;
import com.marvis.mylibrary.data.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    User addUser(UserRequest userRequest);

    List<User> getAllUsers();

    User findUserById(Long id);

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByFullName(String fullName);

    String updateUser(Long id, UserRequest userRequest);

    String deleteUser(Long id);

}
