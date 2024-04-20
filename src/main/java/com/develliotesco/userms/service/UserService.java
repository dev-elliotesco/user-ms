package com.develliotesco.userms.service;

import com.develliotesco.userms.entity.User;
import com.develliotesco.userms.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
