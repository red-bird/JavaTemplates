package com.redbird.lesson24.services;

import com.redbird.lesson24.models.User;
import com.redbird.lesson24.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Captor
    ArgumentCaptor<User> captor;

    private final String name = "Vasya";

    @Test
    void findByUsername() {
        User user = new User();
        user.setUsername(name);
        Mockito.when(userRepository.findByUsername(name)).thenReturn(user);
        UserService userService = new UserServiceImpl(userRepository, passwordEncoder);
        assertEquals(name, userService.findByUsername(name).getUsername());
        assertNotNull(userService.findByUsername(name));
    }

    @Test
    void saveUser() {
        User user = new User();
        user.setUsername(name);
        UserService userService = new UserServiceImpl(userRepository, passwordEncoder);
        userService.saveUser(user);
        Mockito.verify(userRepository).save(captor.capture());
        User captured = captor.getValue();
        assertEquals(name, captured.getUsername());
    }

    @Test
    void loadUserByUsername() {
        User user = new User();
        user.setUsername(name);
        Mockito.when(userRepository.findByUsername(name)).thenReturn(user);
        UserDetailsService userDetailsService = new UserServiceImpl(userRepository, passwordEncoder);
        assertEquals(name, userDetailsService.loadUserByUsername(name).getUsername());
        assertNotNull(userDetailsService.loadUserByUsername(name));
    }
}