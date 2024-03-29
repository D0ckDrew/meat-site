package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.ItemsInMaterialsWarehouseModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsInMaterialsWarehouseRepository extends CrudRepository<ItemsInMaterialsWarehouseModel, Long> {

    List<ItemsInMaterialsWarehouseModel> getFirstByMaterialId(Integer materialId);


}
