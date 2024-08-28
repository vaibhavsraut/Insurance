package com.insurance.service;

import com.insurance.entity.User;
import java.util.List;

/**
 * Service interface for managing Users.
 */
public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
}
