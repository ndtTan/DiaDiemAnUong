/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.repository.impl;

import com.ndt.pojo.Comments;
import com.ndt.pojo.Foods;
import com.ndt.pojo.User;
import com.ndt.repository.CommentRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tannn
 */
@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Comments> getComments() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Comments");
        
        return q.getResultList();
    }

    @Override
    public Comments addComment(String content, int foodId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Comments c = new Comments();
        c.setContent(content);
        c.setCmtFoodId(this.getFoodById(foodId));
        c.setCmtUserId(session.get(User.class, 1));
        
        session.save(c);
        
        return c;
    }

    @Override
    public Foods getFoodById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Foods.class, id);
    }
    
}
