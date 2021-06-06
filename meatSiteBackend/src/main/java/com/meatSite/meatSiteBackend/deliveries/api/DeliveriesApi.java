package com.meatSite.meatSiteBackend.deliveries.api;

import com.meatSite.meatSiteBackend.database.model.DeliveryModel;
import com.meatSite.meatSiteBackend.database.model.ReceiptsModel;
import com.meatSite.meatSiteBackend.database.model.SuppliersModel;
import com.meatSite.meatSiteBackend.materialWarehouse.model.ReceiptElementModel;
import com.meatSite.meatSiteBackend.deliveries.service.DeliveriesService;
import com.meatSite.meatSiteBackend.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
@CrossOrigin(origins = "http://localhost:3000")
public class DeliveriesApi {

    private final DeliveriesService deliveriesService;

    @Autowired
    public DeliveriesApi(DeliveriesService deliveriesService) {
        this.deliveriesService = deliveriesService;
    }

    @PostMapping("/addDelivery")
    public Response addDelivery(@RequestParam int suppliersId,
                                @RequestParam int timestamp,
                                @RequestParam(required = false) String note) {

        return deliveriesService.addDelivery(suppliersId, timestamp, note);
    }

    @PostMapping("/addEntrance")
    public Response addEntrance(@RequestParam int deliveryId,
                                @RequestParam List<ReceiptElementModel> receiptElements) {

        return deliveriesService.addEntrance(deliveryId, receiptElements);
    }

    @GetMapping("/getDeliveries")
    public List<DeliveryModel> getDeliveries() {
        return deliveriesService.get();
    }

    @GetMapping("/getSuppliers")
    public List<SuppliersModel> getSuppliers() {
        return deliveriesService.getSuppliers();
    }

    @GetMapping("/getReceiptsByDeliveryId")
    public List<ReceiptsModel> getReceiptsByDeliveryId(@RequestParam int deliveryId) {
        return deliveriesService.getReceiptsByDeliveryId(deliveryId);
    }
}
