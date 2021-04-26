package com.redbird.lesson23.services;

import com.redbird.lesson23.models.User;

public interface UserService {
    public User findByUsername(String username);
    public User saveUser(User user);
}
