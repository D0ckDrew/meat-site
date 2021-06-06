package com.meatSite.meatSiteBackend.auth.service;

import com.meatSite.meatSiteBackend.auth.model.LoginResponse;
import com.meatSite.meatSiteBackend.auth.model.LoginStatus;
import com.meatSite.meatSiteBackend.auth.model.RegistrationStatus;
import com.meatSite.meatSiteBackend.auth.model.Role;
import com.meatSite.meatSiteBackend.database.model.UserModel;
import com.meatSite.meatSiteBackend.response.Response;
import com.meatSite.meatSiteBackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public Response registration(UserModel userModel) {
        if (userService.getUser(userModel.getUsername()) != null) {
            return RegistrationStatus.USER_ALREADY_EXISTS.getResponse();
        }

        if (userModel.getUsername() == null || userModel.getPassword() == null) {
            return RegistrationStatus.INVALID_REGISTRATION_DATA.getResponse();
        }

        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userModel.setName("1");
        userModel.setSurname("1");
        userModel.setRole(Role.ROLE_GUEST.getName());

        userService.addUser(userModel);

        return RegistrationStatus.SUCCESSFULLY.getResponse();
    }

    public LoginResponse login(String username, String password) {
        UserModel user = userService.getUser(username);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            return new LoginResponse(LoginStatus.INVALID_LOGIN_DATA);
        }

        return new LoginResponse(LoginStatus.SUCCESSFULLY);
    }
}
