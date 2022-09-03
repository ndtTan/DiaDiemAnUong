/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ndt.pojo.Foods;
import com.ndt.service.FoodsService;
import java.io.IOException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tannn
 */
@Controller
@RequestMapping("/admin")
public class FoodController {
    @Autowired
    private FoodsService foodsService;
    
    @GetMapping("/food")
    public String list(Model model) {
        model.addAttribute("food", new Foods());
        return "food";
    }
    
    @PostMapping("/food")
    public String add(Model model, @ModelAttribute(value = "food") @Valid Foods f ,
            BindingResult r) {
        if (!r.hasErrors()) {
            if (this.foodsService.addFood(f) == true)
                return "redirect:/";
            else 
                model.addAttribute("errMsg", "Có sự cố");
        }
        
        
        return "food";
    }
}
