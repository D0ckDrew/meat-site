package com.meatSite.meatSiteBackend.materialWarehouse.service;

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
public class MaterialWarehouseService {

    private final MaterialReceiptsLogRepository materialReceiptsLogRepository;
    private final ItemsInMaterialsWarehouseRepository itemsInMaterialsWarehouseRepository;
    private final MaterialRepository materialRepository;

    @Autowired
    public MaterialWarehouseService(MaterialReceiptsLogRepository materialReceiptsLogRepository,
                                    ItemsInMaterialsWarehouseRepository itemsInMaterialsWarehouseRepository,
                                    MaterialRepository materialRepository) {
        this.materialReceiptsLogRepository = materialReceiptsLogRepository;
        this.itemsInMaterialsWarehouseRepository = itemsInMaterialsWarehouseRepository;
        this.materialRepository = materialRepository;
    }


    @Transactional
    public Long addMaterialFromWarehouseLog(MaterialReceiptsLogModel materialReceiptsLog, MaterialReceiptsLogModel oldMaterialReceiptsLog) {
        if (materialReceiptsLog.getQuantityRemains() == null || materialReceiptsLog.getQuantityRemains() == 0) {
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
        ItemsInMaterialsWarehouseModel addingItem = new ItemsInMaterialsWarehouseModel(itemsInMaterialsWarehouse.getQuantity(), itemsInMaterialsWarehouse.getMaterialId());

        List<ItemsInMaterialsWarehouseModel> warehouseItem = itemsInMaterialsWarehouseRepository.getFirstByMaterialId(itemsInMaterialsWarehouse.getMaterialId());
        if (warehouseItem.size() > 0) {
            addingItem.setId(warehouseItem.get(0).getId());
            addingItem.setQuantity(warehouseItem.get(0).getQuantity() + addingItem.getQuantity());
        }

        itemsInMaterialsWarehouseRepository.save(addingItem);
    }

    public void reduceMaterialFromWarehouse(ItemsInMaterialsWarehouseModel itemsInMaterialsWarehouse) {
        ItemsInMaterialsWarehouseModel removedItem = new ItemsInMaterialsWarehouseModel(itemsInMaterialsWarehouse.getQuantity(), itemsInMaterialsWarehouse.getMaterialId());

        List<ItemsInMaterialsWarehouseModel> warehouseItem = itemsInMaterialsWarehouseRepository.getFirstByMaterialId(itemsInMaterialsWarehouse.getMaterialId());

        if (warehouseItem.size() > 0) {
            removedItem.setId(warehouseItem.get(0).getId());
            removedItem.setQuantity(warehouseItem.get(0).getQuantity() - removedItem.getQuantity());
        } else {
            return;
        }

        itemsInMaterialsWarehouseRepository.save(removedItem);
    }

    public ItemsInMaterialsWarehouseModel getItemInMaterialsWarehouse(int materialId) {
        List<ItemsInMaterialsWarehouseModel> warehouseItem = itemsInMaterialsWarehouseRepository.getFirstByMaterialId(materialId);
        if (warehouseItem.size() > 0) {
            return warehouseItem.get(0);
        }
        return new ItemsInMaterialsWarehouseModel(0.0, materialId);
    }

    public List<MaterialModel> getMaterials(){
       return materialRepository.get();
    }
}
