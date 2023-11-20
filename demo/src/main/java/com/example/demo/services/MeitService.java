package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.MeitModel;
import com.example.demo.repository.MeitRepository;

@Service
public class MeitService {
    

    @Autowired
    private MeitRepository meitRepository;

    public ArrayList<MeitModel> getAllMeits(){
        return meitRepository.getAllMeits();
    }

    public boolean addMeit(MeitModel meit){
        meitRepository.save(meit);
        return true;
    }

    public ArrayList<MeitModel> getMeitById(String meitid){
        return meitRepository.getMeitsById(meitid);
    }

    public ArrayList<MeitModel> getMeitByMeitId(String meitid){
        return meitRepository.getMeitsByMeitId(meitid);
    }

    public boolean updateMeitById(String concept, Long id){
        return meitRepository.updateMeitById(concept, id);
    }

    public boolean deleteMeitByMeitId(String meitid){
        return meitRepository.deleteMeitByMeitId(meitid);
    }

    public boolean markMeitPaid(int id){
        return meitRepository.markMeitPaid(id);
    }

}
