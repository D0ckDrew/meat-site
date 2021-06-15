package com.meatSite.meatSiteBackend.materialWarehouse;

import com.meatSite.meatSiteBackend.database.model.ItemsInMaterialsWarehouseModel;
import com.meatSite.meatSiteBackend.materialWarehouse.service.MaterialWarehouseService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MaterialWarehouseTest {
    private final static ItemsInMaterialsWarehouseModel TEST_RESOURCE = new ItemsInMaterialsWarehouseModel(
            123.5,
            -1
    );

    @Autowired
    private MaterialWarehouseService materialWarehouseService;

    @Test
    public void materialWarehouseTest(){
        ItemsInMaterialsWarehouseModel item = materialWarehouseService.getItemInMaterialsWarehouse(TEST_RESOURCE.getMaterialId());
        Double oldQuantity = item.getQuantity();

        materialWarehouseService.addMaterialFromWarehouse(TEST_RESOURCE);
        ItemsInMaterialsWarehouseModel newItem = materialWarehouseService.getItemInMaterialsWarehouse(TEST_RESOURCE.getMaterialId());
        Assert.assertEquals(newItem.getQuantity(), oldQuantity + TEST_RESOURCE.getQuantity(), 0.0);

        materialWarehouseService.reduceMaterialFromWarehouse(TEST_RESOURCE);
        newItem = materialWarehouseService.getItemInMaterialsWarehouse(TEST_RESOURCE.getMaterialId());
        Assert.assertEquals(newItem.getQuantity(), oldQuantity, 0.0);
    }
}
