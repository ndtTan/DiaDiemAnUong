/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndt.repository.impl;

import com.ndt.pojo.Category;
import com.ndt.pojo.Foods;
import com.ndt.pojo.Order;
import com.ndt.pojo.Receipt;
import com.ndt.pojo.ReceiptDetail;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import com.ndt.repository.FoodsRepository;
import java.util.Date;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tannn
 */
@Repository
@Transactional
@PropertySource("classpath:databases.properties")
public class FoodsRepositoryImpl implements FoodsRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;

    @Override
    public List<Foods> getFood(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Foods> q = b.createQuery(Foods.class);
        Root root = q.from(Foods.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("name").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }

            String fp = params.get("fromPrice");
            if (fp != null) {
                Predicate p = b.greaterThanOrEqualTo(root.get("price").as(Long.class),
                        Long.parseLong(fp));
                predicates.add(p);
            }

            String tp = params.get("toPrice");
            if (tp != null) {
                Predicate p = b.lessThanOrEqualTo(root.get("price").as(Long.class),
                        Long.parseLong(tp));
                predicates.add(p);
            }

            String cateId = params.get("cateId");
            if (cateId != null) {
                Predicate p = b.equal(root.get("categoryId"), Integer.parseInt(cateId));
                predicates.add(p);
            }

            q.where(predicates.toArray(new Predicate[]{}));

        }

        q.orderBy(b.desc(root.get("id")), b.desc(root.get("name")));

        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public int countFood() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("SELECT COUNT(*) FROM Foods");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public boolean addFood(Foods f) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            session.save(f);
            return true;
        } catch (Exception ex) {
            System.err.println("Thêm thất bại" + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteFood(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        try {
            Foods f = session.get(Foods.class, id);
            session.delete(f);
            return true;
        } catch (Exception ex) {
            System.err.println("Thêm thất bại" + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

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
        Root rD = q.from(Receipt.class);
        Root rR = q.from(ReceiptDetail.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rR.get("foodId"), rF.get("id")));
        predicates.add(b.equal(rR.get("receiptId"), rD.get("id")));
        
        q.multiselect(rF.get("id"), rF.get("name"),
                b.sum(b.prod(rR.get("price"), rR.get("amount"))));
        
        if (kw != null)
            predicates.add(b.like(rF.get("name"), kw));
        
        if (fromDate != null)
            predicates.
        
        q.where(predicates.toArray(new Predicate[] {}));
        q.groupBy(rF.get("id"));
        
        Query query = session.createQuery(q);
        return query.getResultList();
    }
}
