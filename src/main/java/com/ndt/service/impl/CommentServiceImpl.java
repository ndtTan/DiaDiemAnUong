/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.service.impl;

import com.ndt.pojo.Comments;
import com.ndt.pojo.Foods;
import com.ndt.repository.CommentRepository;
import com.ndt.service.CommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tannn
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    
    @Override
    public List<Comments> getComments() {
        return this.commentRepository.getComments();
    }

    @Override
    public Comments addComment(String content, int foodId) {
        return this.commentRepository.addComment(content, foodId);
    }

    @Override
    public Foods getFoodById(int id) {
        return this.commentRepository.getFoodById(id);
    }
    
}
