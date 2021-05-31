package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.ProductReceiptsLogModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReceiptsLogRepository extends CrudRepository<ProductReceiptsLogModel, Long> {

}
