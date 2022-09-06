/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ndt.service;

import com.ndt.pojo.Comments;
import com.ndt.pojo.Foods;
import java.util.List;

/**
 *
 * @author tannn
 */
public interface CommentService {
    List<Comments> getComments();
    Foods getFoodById(int id);
    Comments addComment(String content, int foodId);
}
