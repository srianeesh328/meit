package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Table("MEIT")
@Builder
public class MeitModel {

    @Id
    @Column("ID")
    private Long id;
    @Column("MEITID")
    private String meitid;
    @Column("USERNAME")
    private String username;
    @Column("EXPENSE")
    private String expense;
    @Column("CONCEPT")
    private String concept;


    public MeitModel(Long id, String meitid, String username, String expense,String concept){
        super();
        this.id=id;
        this.meitid=meitid;
        this.username=username;
        this.expense=expense;
        this.concept=concept;
        
    }


    public MeitModel() {
    }
    
}
