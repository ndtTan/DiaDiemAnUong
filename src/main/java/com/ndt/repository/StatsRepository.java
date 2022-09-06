/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndt.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author tannn
 */
public interface StatsRepository {
    List<Object[]> cateStats();
    List<Object[]> revenueStats(String kw, Date fromDate, Date toDate);
}
