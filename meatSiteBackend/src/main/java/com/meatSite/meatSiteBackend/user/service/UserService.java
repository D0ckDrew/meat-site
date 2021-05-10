package com.meatSite.meatSiteBackend.user.service;

import com.meatSite.meatSiteBackend.user.model.User;
import com.meatSite.meatSiteBackend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String username) {
        return userRepository.getByUsername(username).get(0);
    }
}
