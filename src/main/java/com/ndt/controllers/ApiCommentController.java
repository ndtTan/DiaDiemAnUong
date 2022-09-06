/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.controllers;

import com.ndt.pojo.Comments;
import com.ndt.service.CommentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author tannn
 */
@RestController
@RequestMapping("/api")
public class ApiCommentController {
    @Autowired
    private CommentService commentService;
    
    @GetMapping("/comments")
    public ResponseEntity<List<Comments>> getComments() {
        
        return new ResponseEntity<>(this.commentService.getComments(), HttpStatus.OK);
    }
    
    @PostMapping(path = "/products/{productId}/comments", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comments> addComment(@RequestBody Map<String, String> params) {
        String content = params.get("content");
        int foodId = Integer.parseInt(params.get("foodId"));
        
        Comments c = this.commentService.addComment(content, foodId);
        
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
}
