package com.marvis.mylibrary.service;

import com.marvis.mylibrary.data.dto.request.UserRequest;
import com.marvis.mylibrary.data.dto.response.UserResponse;
import com.marvis.mylibrary.data.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    UserResponse addUser(UserRequest userRequest);

    List<UserResponse> getAllUsers();

    UserResponse findUserById(Long id);

    UserResponse findUserByEmail(String email);

    UserResponse findUserByFullName(String fullName);

    String updateUser(Long id, UserRequest userRequest);

    String deleteUser(Long id);

}
