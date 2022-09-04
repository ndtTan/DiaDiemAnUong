/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndt.pojo.Foods;
import com.ndt.repository.FoodsRepository;
import com.ndt.service.FoodsService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tannn
 */
@Service
public class FoodsServiceImpl implements FoodsService{
    @Autowired
    private FoodsRepository foodsRepository; 
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Foods> getFood(Map<String, String> params, int page) {
        return this.foodsRepository.getFood(params, page);
    }

    @Override
    public int countFood() {
        return this.foodsRepository.countFood();
    }

    @Override
    public boolean addFood(Foods f) {
        try {
                Map r = this.cloudinary.uploader().upload(f.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                f.setImgFood((String) r.get("secure_url"));
                
                return this.foodsRepository.addFood(f);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
         
            return false;
    }

    @Override
    public boolean deleteFood(int id) {
        return this.foodsRepository.deleteFood(id);
    }

    @Override
    public List<Object[]> cateStats() {
        return this.foodsRepository.cateStats();
    }

    @Override
    public List<Object[]> revenueStats(String kw, Date fromDate, Date toDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
