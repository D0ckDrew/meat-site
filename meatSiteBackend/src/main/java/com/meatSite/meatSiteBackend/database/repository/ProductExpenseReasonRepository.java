package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.ProductExpenseReasonModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductExpenseReasonRepository extends CrudRepository<ProductExpenseReasonModel, Long> {

}
