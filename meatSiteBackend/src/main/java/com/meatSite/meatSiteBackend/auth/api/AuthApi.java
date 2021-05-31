package com.meatSite.meatSiteBackend.auth.api;

import com.meatSite.meatSiteBackend.auth.model.LoginResponse;
import com.meatSite.meatSiteBackend.auth.model.RegistrationStatus;
import com.meatSite.meatSiteBackend.auth.service.AuthService;
import com.meatSite.meatSiteBackend.database.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:8080")
public class AuthApi {

    private final AuthService authService;

    @Autowired
    public AuthApi(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        return authService.login(username, password);
    }

    @PostMapping("/registration")
    public RegistrationStatus registration(@RequestParam String username,
                                           @RequestParam String password) {
        UserModel user = new UserModel();
        user.setUsername(username);
        user.setPassword(password);

        return authService.registration(user);
    }

}
