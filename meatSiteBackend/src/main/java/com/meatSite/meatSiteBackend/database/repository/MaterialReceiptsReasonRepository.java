package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.MaterialReceiptsReasonModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialReceiptsReasonRepository extends CrudRepository<MaterialReceiptsReasonModel, Long> {

}
