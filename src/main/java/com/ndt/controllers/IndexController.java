/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.controllers;

import com.ndt.service.CategoryService;
import com.ndt.service.CommentService;
import com.ndt.service.FoodsService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

;

/**
 *
 * @author tannn
 */
@Controller
@ControllerAdvice
public class IndexController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private FoodsService foodsService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private Environment env;

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
    }

    @RequestMapping("/")
    public String index(Model model,
            @RequestParam Map<String, String> params) {

        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("foods", this.foodsService.getFood(params, page));
        model.addAttribute("pageCounter", this.foodsService.countFood());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("page.size")));

        return "index";
    }
    
    @GetMapping("/food/{foodId}")
    public String foodDetail(Model model, 
            @PathVariable(value = "foodId") int id) {
        model.addAttribute("food", this.commentService.getFoodById(id));
        
        return "food-detail";
    }
    
//    @GetMapping("/food/{foodId}")
//    public String productDetails(Model model, @PathVariable(value = "productId") int id) {
//        model.addAttribute("product", this.foodsService.getFoodById(id));
//        return "food-detail";
//    }
}
