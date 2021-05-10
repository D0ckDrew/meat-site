package com.meatSite.meatSiteBackend.user.api;

import com.meatSite.meatSiteBackend.user.model.User;
import com.meatSite.meatSiteBackend.user.repository.UserRepository;
import com.meatSite.meatSiteBackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8080")
public class UserApi {

    private final UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/get")
    public User getUser(@RequestParam String username) {
        return userService.getUser(username);
    }

}
