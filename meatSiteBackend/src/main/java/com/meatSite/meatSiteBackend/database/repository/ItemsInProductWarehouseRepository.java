package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.ItemsInProductWarehouseModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsInProductWarehouseRepository extends CrudRepository<ItemsInProductWarehouseModel, Long> {

}
