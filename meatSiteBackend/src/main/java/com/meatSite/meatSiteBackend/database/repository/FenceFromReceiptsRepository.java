package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.FenceFromReceiptsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FenceFromReceiptsRepository extends CrudRepository<FenceFromReceiptsModel, Long> {

}
