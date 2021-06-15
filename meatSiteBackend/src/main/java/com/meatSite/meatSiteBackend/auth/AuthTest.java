package com.meatSite.meatSiteBackend.auth;

import com.meatSite.meatSiteBackend.auth.model.LoginResponse;
import com.meatSite.meatSiteBackend.auth.model.LoginStatus;
import com.meatSite.meatSiteBackend.auth.service.AuthService;
import com.meatSite.meatSiteBackend.database.model.UserModel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthTest {
    private static final UserModel TEST_USR = new UserModel(
            (long) -1,
            "test_user",
            "test_password",
            "name",
            "surname"
    );

    @Autowired
    private AuthService authService;

    @Test
    public void authTest(){
        authService.registration(TEST_USR);
        LoginResponse loginResponse = authService.login(TEST_USR.getUsername(), TEST_USR.getPassword());

        Assert.assertEquals(loginResponse.getLoginStatus().getCode(), LoginStatus.SUCCESSFULLY.getCode());

        authService.deleteUser(TEST_USR.getUsername());
        LoginResponse loginDeletedResponse = authService.login(TEST_USR.getUsername(), TEST_USR.getPassword());
        Assert.assertEquals(loginDeletedResponse.getLoginStatus().getCode(), LoginStatus.INVALID_LOGIN_DATA.getCode());
    }
}
