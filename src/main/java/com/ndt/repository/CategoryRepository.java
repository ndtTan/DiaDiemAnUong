/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.repository;

import com.ndt.pojo.Category;
import java.util.List;

/**
 *
 * @author tannn
 */
public interface CategoryRepository {
    List<Category> getCategories();
}
