package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.OutputMaterialsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutputMaterialsRepository extends CrudRepository<OutputMaterialsModel, Long> {

}
