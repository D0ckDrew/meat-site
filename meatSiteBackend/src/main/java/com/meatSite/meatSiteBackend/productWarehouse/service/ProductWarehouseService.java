package com.meatSite.meatSiteBackend.productWarehouse.service;

import com.meatSite.meatSiteBackend.database.model.ItemsInMaterialsWarehouseModel;
import com.meatSite.meatSiteBackend.database.model.MaterialModel;
import com.meatSite.meatSiteBackend.database.model.MaterialReceiptsLogModel;
import com.meatSite.meatSiteBackend.database.repository.ItemsInMaterialsWarehouseRepository;
import com.meatSite.meatSiteBackend.database.repository.MaterialReceiptsLogRepository;
import com.meatSite.meatSiteBackend.database.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ProductWarehouseService {

    private final MaterialReceiptsLogRepository materialReceiptsLogRepository;
    private final ItemsInMaterialsWarehouseRepository itemsInMaterialsWarehouseRepository;
    private final MaterialRepository materialRepository;

    @Autowired
    public ProductWarehouseService(MaterialReceiptsLogRepository materialReceiptsLogRepository,
                                   ItemsInMaterialsWarehouseRepository itemsInMaterialsWarehouseRepository,
                                   MaterialRepository materialRepository) {
        this.materialReceiptsLogRepository = materialReceiptsLogRepository;
        this.itemsInMaterialsWarehouseRepository = itemsInMaterialsWarehouseRepository;
        this.materialRepository = materialRepository;
    }


    @Transactional
    public Long addMaterialFromWarehouse(MaterialReceiptsLogModel materialReceiptsLog, MaterialReceiptsLogModel oldMaterialReceiptsLog) {
        if (materialReceiptsLog.getQuantityRemains() == null || materialReceiptsLog.getQuantityRemains() == 0.0) {
            materialReceiptsLog.setQuantityRemains(materialReceiptsLog.getQuantity());
        }

        if (materialReceiptsLog.getDate() == null) {
            materialReceiptsLog.setDate(new Timestamp(new Date().getTime()));
        }

        MaterialReceiptsLogModel savedMaterialReceiptsLog = materialReceiptsLogRepository.save(materialReceiptsLog);

        ItemsInMaterialsWarehouseModel itemsInMaterialsWarehouse = new ItemsInMaterialsWarehouseModel();
        itemsInMaterialsWarehouse.setMaterialId(materialReceiptsLog.getMaterialId());

        if (oldMaterialReceiptsLog != null) {
            if (oldMaterialReceiptsLog.getQuantity() > materialReceiptsLog.getQuantity()) {
                itemsInMaterialsWarehouse.setQuantity(oldMaterialReceiptsLog.getQuantity() - materialReceiptsLog.getQuantity());
                reduceMaterialFromWarehouse(itemsInMaterialsWarehouse);
            } else if (oldMaterialReceiptsLog.getQuantity() < materialReceiptsLog.getQuantity()) {
                itemsInMaterialsWarehouse.setQuantity(materialReceiptsLog.getQuantity() - oldMaterialReceiptsLog.getQuantity());
                addMaterialFromWarehouse(itemsInMaterialsWarehouse);
            }
        } else {
            itemsInMaterialsWarehouse.setQuantity(materialReceiptsLog.getQuantity());
            addMaterialFromWarehouse(itemsInMaterialsWarehouse);
        }

        return savedMaterialReceiptsLog.getId();
    }

    public void addMaterialFromWarehouse(ItemsInMaterialsWarehouseModel itemsInMaterialsWarehouse) {
        List<ItemsInMaterialsWarehouseModel> warehouseItem = itemsInMaterialsWarehouseRepository.getFirstByMaterialId(itemsInMaterialsWarehouse.getMaterialId());

        if (warehouseItem.size() > 0) {
            itemsInMaterialsWarehouse.setId(warehouseItem.get(0).getId());
            itemsInMaterialsWarehouse.setQuantity(warehouseItem.get(0).getQuantity() + itemsInMaterialsWarehouse.getQuantity());
        }

        itemsInMaterialsWarehouseRepository.save(itemsInMaterialsWarehouse);
    }

    public void reduceMaterialFromWarehouse(ItemsInMaterialsWarehouseModel itemsInMaterialsWarehouse) {
        List<ItemsInMaterialsWarehouseModel> warehouseItem = itemsInMaterialsWarehouseRepository.getFirstByMaterialId(itemsInMaterialsWarehouse.getMaterialId());

        if (warehouseItem.size() > 0) {
            itemsInMaterialsWarehouse.setId(warehouseItem.get(0).getId());
            itemsInMaterialsWarehouse.setQuantity(warehouseItem.get(0).getQuantity() - itemsInMaterialsWarehouse.getQuantity());
        } else {
            return;
        }

        itemsInMaterialsWarehouseRepository.save(itemsInMaterialsWarehouse);
    }

    public List<MaterialModel> getMaterials(){
       return materialRepository.get();
    }
}
