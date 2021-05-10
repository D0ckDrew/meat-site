package com.meatSite.meatSiteBackend.user.repository;

import com.meatSite.meatSiteBackend.user.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username = :username")
    List<User> getByUsername(String username);

//    List<User> findByDate(Date date);
//
//    // пример кастомного запроса который возвращает Stream (Java 8 Stream API)
//    @Query("SELECT u FROM User u WHERE u.email = :email")
//    List<User> findByEmailReturnStream(@Param("email") String email);
}
