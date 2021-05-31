package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.FenceFromWarehouseModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FenceFromWarehouseRepository extends CrudRepository<FenceFromWarehouseModel, Long> {

}
