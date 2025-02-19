package com.atrory.atrory_project.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atrory.atrory_project.models.User;
import com.atrory.atrory_project.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Criar ou salvar um novo usuário
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Obter um usuário por ID
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    // Atualizar um usuário existente
    public User updateUser(Integer id, User updatedUser) {
        if (userRepository.existsById(id)) {
            updatedUser.setId(id);
            return userRepository.save(updatedUser);
        }
        return null; // Ou lançar uma exceção
    }

    // Deletar um usuário
    public boolean deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Verificar se um usuário existe pelo email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Método adicional para buscar um usuário por nome de usuário
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
