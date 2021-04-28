package com.redbird.lesson24.services;

import com.redbird.lesson24.models.User;

public interface UserService {
    public User findByUsername(String username);
    public User saveUser(User user);
}
