package com.meatSite.meatSiteBackend.user.service;

import com.meatSite.meatSiteBackend.database.model.UserModel;
import com.meatSite.meatSiteBackend.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel getUser(String username) {
        List<UserModel> userList = userRepository.getFirstByUsername(username);
        return userList.size() <= 0 ? null : userList.get(0);
    }

    public void addUser(UserModel userModel) {
        userRepository.save(userModel);
    }

    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }

}
