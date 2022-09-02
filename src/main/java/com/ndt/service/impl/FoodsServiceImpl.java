/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.service.impl;

import com.ndt.pojo.Foods;
import com.ndt.repository.FoodsRepository;
import com.ndt.service.FoodsService;
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

    @Override
    public List<Foods> getFood(Map<String, String> params, int page) {
        return this.foodsRepository.getFood(params, page);
    }

    @Override
    public int countFood() {
        return this.foodsRepository.countFood();
    }
}
