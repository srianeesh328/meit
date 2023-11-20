package com.example.demo.repository;

import com.example.demo.model.MeitModel;
import com.example.demo.model.UserDetailModel;
import com.example.demo.model.UserModel;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public interface UserDetailRepository extends CrudRepository<UserDetailModel,Long> {

    @Query("SELECT * FROM USER_DETAIL")
    public ArrayList<UserDetailModel> getAllUserDetail();

    @Query("SELECT * FROM USER_DETAIL WHERE USERNAME = :username")
    public ArrayList<UserDetailModel> getAllUserDetailByUsername(
        @Param("username") String username
    );

    @Modifying
    @Query("UPDATE USER_DETAIL SET DESCRIPTION = :description WHERE USERNAME = :username")
    public boolean updateDescription(
        @Param("description") String description,
        @Param("username") String username
    );

    @Modifying
    @Query("UPDATE USER_DETAIL SET EMAIL = :email WHERE USERNAME = :username")
    public boolean updateEmail(
        @Param("email") String email,
        @Param("username") String username
    );

    @Modifying
    @Query("UPDATE USER_DETAIL SET USERNAME = :username_new WHERE USERNAME = :username")
    public boolean updateUsername(
        @Param("username_new") String username_new,
        @Param("username") String username
    );
}
