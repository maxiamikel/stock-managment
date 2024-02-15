package com.maxi.stockmanagment.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.maxi.stockmanagment.domains.User;
import com.maxi.stockmanagment.enums.UserType;
import com.maxi.stockmanagment.repositories.UserRepository;
import com.maxi.stockmanagment.services.UserService;

public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Long idUser) {
        Optional<User> user = userRepository.findById(idUser);
        if (user.isPresent()) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User save(User user) {
        user.setUserType(UserType.USER);
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User checkCredentials(String userName, String password) {
        return null;
    }

}
