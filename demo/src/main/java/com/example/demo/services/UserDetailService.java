package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MeitModel;
import com.example.demo.model.UserDetailModel;
import com.example.demo.repository.MeitRepository;
import com.example.demo.repository.UserDetailRepository;

@Service
public class UserDetailService {
    

    @Autowired
    private UserDetailRepository userDetailRepository;

    public ArrayList<UserDetailModel> getAllUserDetail(){
        return userDetailRepository.getAllUserDetail();
    }

   public boolean addUserDetail(UserDetailModel user){
        userDetailRepository.save(user);
        return true;
   }

   public ArrayList<UserDetailModel> getAllUserDetailByUsername(String username){
    return userDetailRepository.getAllUserDetailByUsername(username);
   }

   public boolean updateDescription(String description, String usrename){
    return userDetailRepository.updateDescription(description,usrename);
   }

   public boolean updateEmail(String email, String usrename){
    return userDetailRepository.updateEmail(email,usrename);
   }

   public boolean updateUsername(String username_new, String usrename){
    return userDetailRepository.updateUsername(username_new,usrename);
   }

}
