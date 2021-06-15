package com.meatSite.meatSiteBackend.admin.service;

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
public class AdminService {

    @Autowired
    public AdminService() {
    }
}
