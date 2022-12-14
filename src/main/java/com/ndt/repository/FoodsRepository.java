/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndt.repository;

import com.ndt.pojo.Comments;
import com.ndt.pojo.Foods;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tannn
 */
public interface FoodsRepository {
    List<Foods> getFood (Map<String, String> params, int page);
    int countFood();
    boolean addFood(Foods f);
    boolean deleteFood(int id);
//    Comments addComment(String content, int foodId);
//    List<Object[]> cateStats();
//    List<Object[]> revenueStats(String kw, Date fromDate, Date toDate);
}
