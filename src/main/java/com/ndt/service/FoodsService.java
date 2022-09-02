/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndt.service;

import com.ndt.pojo.Foods;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tannn
 */
public interface FoodsService {
    List<Foods> getFood (Map<String, String> params, int page);
    int countFood();
}
