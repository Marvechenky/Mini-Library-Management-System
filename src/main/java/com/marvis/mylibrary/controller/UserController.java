package com.marvis.mylibrary.controller;

import com.marvis.mylibrary.data.dto.request.BookRequest;
import com.marvis.mylibrary.data.dto.request.UserRequest;
import com.marvis.mylibrary.data.dto.response.BookResponse;
import com.marvis.mylibrary.data.dto.response.UserResponse;
import com.marvis.mylibrary.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;


    @PostMapping("/users/add")
    public ResponseEntity<UserResponse> addUsers(@RequestBody @Valid UserRequest userRequest) {
        UserResponse addedUser = userService.addUser(userRequest);
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        UserResponse userWithId = userService.findUserById(id);
        return new ResponseEntity<>(userWithId, HttpStatus.OK);
    }


    @GetMapping("/users/all")
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<UserResponse> userResponses = userService.getAllUsers();
        return new ResponseEntity<List<UserResponse>>(userResponses, HttpStatus.OK);
    }

    @GetMapping("/users/email/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
        UserResponse userWithEmail = userService.findUserByEmail(email);
        return new ResponseEntity<>(userWithEmail, HttpStatus.OK);
    }


    @GetMapping("/users/fullName/{fullName}")
    public ResponseEntity<UserResponse> getUserByFullName(@PathVariable String fullName) {
        UserResponse userWithFullName = userService.findUserByFullName(fullName);
        return new ResponseEntity<>(userWithFullName, HttpStatus.OK);
    }


    @PutMapping("/users/update-user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody @Valid UserRequest userRequest) {
        String updateMessage = "User successfully updated";
        userService.updateUser(id, userRequest);
        return new ResponseEntity<>(updateMessage, HttpStatus.OK);
    }


    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        String deleteMessage = "User successfully deleted";
        userService.deleteUser(id);
        return new ResponseEntity<>(deleteMessage, HttpStatus.OK);
    }


}
