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
import com.example.demo.services.MeitService;

@RestController
@RequestMapping(
    path = "/meit"
)
public class MeitController {
    int temp;
    @Autowired
    private MeitService meitService;

    @GetMapping("/")
    public @ResponseBody ResponseEntity<String> getTest(){
        return ResponseEntity.ok().body("Test passed");
    }

    @GetMapping("/all")
        public @ResponseBody ResponseEntity<ArrayList<MeitModel>> getAll(){
            return ResponseEntity.ok().body(meitService.getAllMeits());
       }
    @PostMapping("/newMeit")
    public ResponseEntity<ArrayList<MeitModel>> newMeit(@RequestBody MeitModel meit){
        //Generar uin nuevo meitid
        int temp=0;
        for (MeitModel existingMeit: meitService.getAllMeits()){
            int temp1=Integer.parseInt(existingMeit.getMeitid());

            if (temp1 > temp) {
                temp=temp1;
              }
        }
        meit.setMeitid(String.valueOf(temp+1));
        meit.setConcept(meit.getConcept()+" Participants: "+meit.getUsername());
        if (meitService.addMeit(meit)){
            System.out.println("Meit added");
        }
        return ResponseEntity.ok().body(meitService.getAllMeits());
    }

    @PostMapping("/joinMeit")
    public ResponseEntity<ArrayList<MeitModel>> joinMeit(@RequestBody MeitModel meit){
        //Generar uin nuevo meitid
        System.out.println(meit.getMeitid());
        //get the concept
        String newconcept = new String();
        for(MeitModel meitsByUsername: meitService.getMeitByMeitId(meit.getMeitid())){
            if (isInteger(meitsByUsername.getExpense())==false){
                meit.setConcept(meitsByUsername.getConcept()); 
                meit.setExpense(meitsByUsername.getExpense());
                meit.setConcept(meit.getConcept()+", "+meit.getUsername());
                newconcept=meit.getConcept();
            }
        }
        //change all concepts 
        for(MeitModel meitsByUsername: meitService.getMeitByMeitId(meit.getMeitid())){
            if (isInteger(meitsByUsername.getExpense())==false){
                System.out.println(meitsByUsername.getUsername()+":"+meitsByUsername.getId());
                meitService.updateMeitById(newconcept, meitsByUsername.getId());
            }
        }
        
        if (meitService.addMeit(meit)){
            System.out.println("Meit added");
        }
        return ResponseEntity.ok().body(meitService.getAllMeits());
    }

    @PostMapping("/getMeit")
    public ResponseEntity<ArrayList<MeitModel>> getMeit(@RequestBody MeitModel meit){
        System.out.println("Getting meits from");
        System.out.println(meit.getUsername());

        ArrayList<MeitModel> meitbyuser = new ArrayList<MeitModel>();

        for(MeitModel meitsByUsername: meitService.getMeitById(meit.getUsername())){
            if (isInteger(meitsByUsername.getExpense())==false){
                meitbyuser.add(meitsByUsername);
            }
        }
        return ResponseEntity.ok().body(meitbyuser);
    }

    @PostMapping("/getMeitsById")
    public ResponseEntity<ArrayList<MeitModel>> getMeitsById(@RequestBody MeitModel meit){
        System.out.println("Getting meits from");
        System.out.println(meit.getUsername());

        ArrayList<MeitModel> meitbyuser = new ArrayList<MeitModel>();

        for(MeitModel meitsByMeitId: meitService.getMeitByMeitId(meit.getMeitid())){
            if (isInteger(meitsByMeitId.getExpense())){
                meitbyuser.add(meitsByMeitId);
            }
        }
        return ResponseEntity.ok().body(meitbyuser);
    }



    @PostMapping("/addExpenseToMeit")
    public ResponseEntity<ArrayList<MeitModel>> addExpenseToMeit(@RequestBody MeitModel meit){
        ArrayList<MeitModel> meitbyuser= new ArrayList<MeitModel>();
        if (meitService.addMeit(meit)){
            System.out.println("Meit added");
        }
        return ResponseEntity.ok().body(meitbyuser);
    }



    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

}
