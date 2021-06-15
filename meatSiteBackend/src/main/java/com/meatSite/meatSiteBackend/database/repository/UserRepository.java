package com.meatSite.meatSiteBackend.database.repository;

import com.meatSite.meatSiteBackend.database.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

    List<UserModel> getFirstByUsername(String username);

    void deleteByUsername(String username);

}
