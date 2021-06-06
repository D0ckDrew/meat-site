package com.meatSite.meatSiteBackend.materialWarehouse.api;

import com.meatSite.meatSiteBackend.database.model.DeliveryModel;
import com.meatSite.meatSiteBackend.database.model.MaterialModel;
import com.meatSite.meatSiteBackend.database.model.ReceiptsModel;
import com.meatSite.meatSiteBackend.database.model.SuppliersModel;
import com.meatSite.meatSiteBackend.deliveries.service.DeliveriesService;
import com.meatSite.meatSiteBackend.materialWarehouse.model.ReceiptElementModel;
import com.meatSite.meatSiteBackend.materialWarehouse.service.MaterialWarehouseService;
import com.meatSite.meatSiteBackend.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materialWarehouse")
@CrossOrigin(origins = "http://localhost:3000")
public class MaterialWarehouseApi {

    private final MaterialWarehouseService materialWarehouseService;

    @Autowired
    public MaterialWarehouseApi(MaterialWarehouseService materialWarehouseService) {
        this.materialWarehouseService = materialWarehouseService;
    }

    @GetMapping("/getMaterials")
    public List<MaterialModel> getMaterials() {
        return materialWarehouseService.getMaterials();
    }
}
