package com.example.demo.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("USER_DETAIL")
public class UserDetailModel {

    @Id
    @Column("ID")
    private Long id;
    @Column("USERNAME")
    private String username;
    @Column("EMAIL")
    private String email;
    @Column("DESCRIPTION")
    private String description;


    public UserDetailModel(Long id, String username, String email,String description) {
        super();
        this.id = id;
        this.username = username;
        this.email = email;
        this.description=description;
    }


    public UserDetailModel() {
    }

   
}
