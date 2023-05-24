package com.flightbackend.flightbookingfinal.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.flightbackend.flightbookingfinal.models.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String>{

    @Query(value="SELECT * FROM chosenflightsproto.user_db WHERE username = :newUser", nativeQuery=true)
    List<UserModel> findByUsername(@Param("newUser") String newUser);

}
