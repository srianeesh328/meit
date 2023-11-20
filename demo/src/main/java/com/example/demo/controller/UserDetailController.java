package com.example.demo.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.print.attribute.standard.Media;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MeitModel;
import com.example.demo.model.UserDetailModel;
import com.example.demo.services.MeitService;
import com.example.demo.services.UserDetailService;

@RestController
@RequestMapping(
    path = "/userdetail" 
)
public class UserDetailController {
    int temp;
    @Autowired
    private UserDetailService userDetailService;

    @PostMapping("/getUserDetails")
    public ResponseEntity<ArrayList<UserDetailModel>> getUserDetails(@RequestBody UserDetailModel user){
               System.out.println("Getting details of:"+user.getUsername());
                System.out.println(userDetailService.getAllUserDetailByUsername(user.getUsername()));
        return ResponseEntity.ok().body(userDetailService.getAllUserDetailByUsername(user.getUsername()));

    }

    @PostMapping("/postUserDetails")
    public ResponseEntity<ArrayList<UserDetailModel>> postUserDetails(@RequestBody UserDetailModel user){
        System.out.println("Update user  detaisl detected:"+user.getUsername()+user.getEmail()+user.getDescription());
        System.out.println(userDetailService.getAllUserDetailByUsername(user.getUsername()));
        
        if (userDetailService.getAllUserDetailByUsername(user.getUsername()).isEmpty()){
           System.out.println("Creating user details...");
            userDetailService.addUserDetail(user);
        }
        else{
           System.out.println("Updating user details...");
            userDetailService.updateDescription(user.getDescription(), user.getUsername());
            userDetailService.updateEmail(user.getEmail(), user.getUsername());
            userDetailService.updateUsername(user.getUsername(), user.getUsername());
        }
        return ResponseEntity.ok().body(userDetailService.getAllUserDetailByUsername(user.getUsername()));
    }

    @GetMapping("/")
    public ResponseEntity<ArrayList<UserDetailModel>> getAllUserDetails(){
        return  ResponseEntity.ok().body(userDetailService.getAllUserDetail());
    }
}
