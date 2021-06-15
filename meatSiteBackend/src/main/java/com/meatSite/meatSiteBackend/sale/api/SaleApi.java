package com.meatSite.meatSiteBackend.sale.api;

import com.meatSite.meatSiteBackend.auth.model.LoginResponse;
import com.meatSite.meatSiteBackend.auth.service.AuthService;
import com.meatSite.meatSiteBackend.database.model.UserModel;
import com.meatSite.meatSiteBackend.response.Response;
import com.meatSite.meatSiteBackend.sale.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
@CrossOrigin(origins = "http://localhost:3000")
public class SaleApi {

    private final SaleService saleService;

    @Autowired
    public SaleApi(SaleService saleService) {
        this.saleService = saleService;
    }

}
