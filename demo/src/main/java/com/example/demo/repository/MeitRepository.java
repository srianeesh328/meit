package com.example.demo.repository;

import com.example.demo.model.MeitModel;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MeitRepository extends CrudRepository<MeitModel,Long> {

    @Query("SELECT * FROM MEIT")
    public ArrayList<MeitModel> getAllMeits();
    
    @Query("SELECT * FROM MEIT WHERE USERNAME = :username")
    public ArrayList<MeitModel> getMeitsById(
        @Param("username") String username
    );

    @Query("SELECT * FROM MEIT WHERE MEITID = :meitid")
    public ArrayList<MeitModel> getMeitsByMeitId(
        @Param("meitid") String meitid
    );

    @Modifying
    @Query("UPDATE MEIT SET CONCEPT = :concept WHERE ID = :id")
    public boolean updateMeitById(
        @Param("concept") String concept,
        @Param("id") Long id
    );

    @Modifying
    @Query("DELETE FROM MEIT WHERE MEITID = :meitid")
    public boolean deleteMeitByMeitId(
        @Param("meitid") String meitid
    );

    @Modifying
    @Query("DELETE FROM MEIT WHERE ID = :id")
    public boolean markMeitPaid(
        @Param("id") int id
    );

    
}
