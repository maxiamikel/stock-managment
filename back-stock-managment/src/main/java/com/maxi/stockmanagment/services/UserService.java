package com.maxi.stockmanagment.services;

import java.util.List;
import java.util.Optional;

import com.maxi.stockmanagment.domains.User;

public interface UserService {
    public List<User> getAll();

    public Optional<User> getById(Long idUser);

    public User save(User user);

    public User update(User user);

    public User checkCredentials(String userName, String password);
}
