package com.meatSite.meatSiteBackend.user.api;

import com.meatSite.meatSiteBackend.database.model.UserModel;
import com.meatSite.meatSiteBackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8080")
public class UserApi {

    private final UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/get")
    public UserModel getUser(@RequestParam String username) {
        return userService.getUser(username);
    }

}
