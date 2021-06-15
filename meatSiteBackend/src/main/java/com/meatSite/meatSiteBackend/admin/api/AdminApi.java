package com.meatSite.meatSiteBackend.admin.api;

import com.meatSite.meatSiteBackend.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminApi {

    private final AdminService adminService;

    @Autowired
    public AdminApi(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/getStat")
    public HashMap getStat() {
        return new HashMap();
    }

}
