package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.MaterialReceiptsLogModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialReceiptsLogRepository extends CrudRepository<MaterialReceiptsLogModel, Long> {

}
