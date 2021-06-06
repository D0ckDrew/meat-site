package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.ReceiptsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiptsRepository extends CrudRepository<ReceiptsModel, Long> {

    List<ReceiptsModel> getAllByDeliveryId(Integer deliveryId);

    List<ReceiptsModel> getAllByDeliveryIdAndMaterialReceiptsLogById_MaterialId(Integer deliveryId, Integer materialId);
}
