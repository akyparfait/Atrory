package com.atrory.atrory_project.models.services;

import com.atrory.model.User;
import com.atrory.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserById(Integer id) {  // Alterado para Integer
        return userRepository.findById(id);
    }

    public void deleteUserById(Integer id) {  // Alterado para Integer
        userRepository.deleteById(id);
    }
}

