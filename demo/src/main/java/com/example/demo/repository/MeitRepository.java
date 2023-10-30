package com.example.demo.repository;

import com.example.demo.model.MeitModel;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MeitRepository extends CrudRepository<MeitModel,Long> {

    @Query("SELECT * FROM MEIT")
    public List<MeitModel> getAllMeits();

}
