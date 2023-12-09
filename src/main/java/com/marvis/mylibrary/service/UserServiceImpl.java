package com.marvis.mylibrary.service;

import com.marvis.mylibrary.data.dto.request.UserRequest;
import com.marvis.mylibrary.data.model.User;
import com.marvis.mylibrary.data.repository.UserRepository;
import com.marvis.mylibrary.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;


    @Override
    public User addUser(UserRequest userRequest) {
        User user= User.builder()
                .id(userRequest.getId())
                .firstName(userRequest.getFirstName())
                .LastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .gender(userRequest.getGender())
                .age(userRequest.getAge())
                .address(userRequest.getAddress())
                .build();
        return userRepository.save(user);

//        return UserResponse.builder()
//                .message("User successfully added with details: ")
//                .email(user.getEmail())
//                .fullName(user.getFullName())
//                .build();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return findUser(id);
    }


    @Override
    public Optional<User> findUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmailIgnoreCase(email);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found for email: " + email);
        }
        return user;
    }

    @Override
    public Optional<User> findUserByFullName(String fullName) {
        Optional<User> user = userRepository.findByFullName(fullName);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found for full name: " + fullName);
        }
        return user;
    }

    @Override
    public String updateUser(Long id, UserRequest userRequest) {
        String message = "User successfully updated";
        User userToUpdate = findUser(id);

//        userToUpdate.setFirstName(userRequest.getFirstName());
//        userToUpdate.setLastName(userRequest.getLastName());
//        userToUpdate.setEmail(userRequest.getEmail());
//        userToUpdate.setGender(userRequest.getGender());
//        userToUpdate.setAge(userRequest.getAge());
//        userToUpdate.setAddress(userRequest.getAddress());
//        userRepository.save(userToUpdate);
//        return message;

        userToUpdate = User.builder()
                .firstName(userRequest.getFirstName())
                .LastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .gender(userRequest.getGender())
                .age(userRequest.getAge())
                .address(userRequest.getAddress())
                .build();
        userRepository.save(userToUpdate);
        return message;
    }


    @Override
    public String deleteUser(Long id) {
        String message = "User successfully deleted";
        User userToDelete = findUser(id);
        userRepository.delete(userToDelete);
        return message;
    }



    private User findUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException
                                (String.format("User with id: %s not found", id)));
    }
}
