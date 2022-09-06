/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.service.impl;


import com.ndt.repository.StatsRepository;
import com.ndt.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tannn
 */
@Service
public class StatsServiceImpl implements StatsService{
    @Autowired
    private StatsRepository statsRepository; 

    @Override
    public List<Object[]> cateStats() {
        return this.statsRepository.cateStats();
    }
    
    @Override
    public List<Object[]> revenueStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.revenueStats(kw, fromDate, toDate);
    }
}
