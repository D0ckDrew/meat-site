package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.DeliveryModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends CrudRepository<DeliveryModel, Long> {

    @Query("SELECT d FROM DeliveryModel d")
    List<DeliveryModel> get();

}
