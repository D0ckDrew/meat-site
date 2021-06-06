package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.MaterialModel;
import com.meatSite.meatSiteBackend.database.model.SuppliersModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends CrudRepository<MaterialModel, Long> {

    @Query("SELECT m FROM MaterialModel m")
    List<MaterialModel> get();

}
