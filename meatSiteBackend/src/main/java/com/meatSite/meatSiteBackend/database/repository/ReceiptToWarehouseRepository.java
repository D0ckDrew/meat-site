package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.ReceiptToWarehouseModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptToWarehouseRepository extends CrudRepository<ReceiptToWarehouseModel, Long> {

}
