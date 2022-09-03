/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.controllers;

import com.ndt.pojo.Foods;
import com.ndt.service.FoodsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author tannn
 */
@RestController
@RequestMapping("/api")
public class ApiFoodController {
    @Autowired
    private FoodsService foodService;
    
    @GetMapping("/food")
    public ResponseEntity<List<Foods>> getFood() {
        return new ResponseEntity<>(this.foodService.getFood(null, 0), HttpStatus.OK);
    }
    
    @DeleteMapping ("/food/{foodId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFood(@PathVariable(value = "foodId") int id) {
        this.foodService.deleteFood(id);
    }
}
