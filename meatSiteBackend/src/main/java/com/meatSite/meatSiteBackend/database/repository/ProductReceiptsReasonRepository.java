package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.ProductReceiptsReasonModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReceiptsReasonRepository extends CrudRepository<ProductReceiptsReasonModel, Long> {

}
