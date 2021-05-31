package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.MaterialExpenseReasonModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialExpenseReasonRepository extends CrudRepository<MaterialExpenseReasonModel, Long> {

}
