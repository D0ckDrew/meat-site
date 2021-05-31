package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.ProductExpenseLogModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductExpenseLogRepository extends CrudRepository<ProductExpenseLogModel, Long> {

}
