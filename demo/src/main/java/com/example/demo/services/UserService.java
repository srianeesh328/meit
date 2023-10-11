package com.example.demo.services;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService{

    @Autowired
    private UsersRepository userRepository;

    public boolean userRegister(UserModel userToAdd){
        if (isInUsers(userToAdd)){
            return false;
        }
        userRepository.save(userToAdd);
        System.out.println("Se ha añadido el usuario: "+userToAdd.getUsername());
        return true;

    }

    public boolean isInUsers(UserModel user){
        ArrayList<UserModel> users= (ArrayList<UserModel>) userRepository.getAllUsers();
        for (UserModel userI:users){
            if (user.getUsername().equals(userI.getUsername())){
                System.out.println("En la base de datos ya existe el username: "+user.getUsername());
                return true;
            }
        }
        return false;
    }



}
