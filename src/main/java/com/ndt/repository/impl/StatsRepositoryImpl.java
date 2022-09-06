/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.repository.impl;

import com.ndt.pojo.Category;
import com.ndt.pojo.Foods;
import com.ndt.pojo.Receipt;
import com.ndt.pojo.ReceiptDetail;
import com.ndt.repository.StatsRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import java.util.Date;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tannn
 */
@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Object[]> cateStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rF = q.from(Foods.class);
        Root rC = q.from(Category.class);
        q.where(b.equal(rF.get("categoryId"), rC.get("id")));

        q.multiselect(rC.get("id"), rC.get("categoryName"), b.count(rF.get("id")));
        q.groupBy(rC.get("id"));

        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public List<Object[]> revenueStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rF = q.from(Foods.class);
        Root rR = q.from(Receipt.class);
        Root rD = q.from(ReceiptDetail.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rD.get("foodId"), rF.get("id")));
        predicates.add(b.equal(rD.get("receiptId"), rR.get("id")));
        
        q.multiselect(rF.get("id"), rF.get("name"),
                b.sum(b.prod(rD.get("price"), rD.get("amount"))));
        
        if (kw != null)
            predicates.add(b.like(rF.get("name"), kw));
        
        if (fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rR.get("createDate"), fromDate));
        
        if (toDate != null)
            predicates.add(b.lessThanOrEqualTo(rR.get("createDate"), toDate));
        
        q.where(predicates.toArray(new Predicate[] {}));
        q.groupBy(rF.get("id"));
        
        Query query = session.createQuery(q);
        return query.getResultList();
    }
    
}
