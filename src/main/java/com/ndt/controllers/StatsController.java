/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.controllers;

import com.ndt.service.FoodsService;
import com.ndt.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tannn
 */
@Controller
@RequestMapping("/admin")
public class StatsController {
    @Autowired
    private StatsService statsService;
    
    @GetMapping("/cate-stats")
    public String cateStats(Model model) {
        model.addAttribute("stats", this.statsService.cateStats());
        return "cate-stats";
    }
    
    @GetMapping("/rev-stats")
    public String revenueStats(Model model) {;
        model.addAttribute("revenueStats", this.statsService.revenueStats(null, null, null));
        return "rev-stats";
    }
    
}
