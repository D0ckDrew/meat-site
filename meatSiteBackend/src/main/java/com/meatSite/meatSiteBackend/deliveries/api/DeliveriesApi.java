package com.meatSite.meatSiteBackend.deliveries.api;

import com.meatSite.meatSiteBackend.deliveries.service.DeliveriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8080")
public class DeliveriesApi {

    private final DeliveriesService deliveriesService;

    @Autowired
    public DeliveriesApi(DeliveriesService deliveriesService) {
        this.deliveriesService = deliveriesService;
    }

}
